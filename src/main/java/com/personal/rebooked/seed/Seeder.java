package com.personal.rebooked.seed;

import com.personal.rebooked.book.BookService;
import com.personal.rebooked.book.dto.CreateBookDto;
import com.personal.rebooked.book.models.Tag;
import com.personal.rebooked.book.repositories.TagRepository;
import com.personal.rebooked.category.CategoryService;
import com.personal.rebooked.category.dto.CreateCategoryDTO;
import com.personal.rebooked.category.models.Category;
import com.personal.rebooked.file.FileService;
import com.personal.rebooked.file.models.File;
import com.personal.rebooked.user.UserService;
import com.personal.rebooked.user.dto.CreateUserDto;
import com.personal.rebooked.user.models.User;
import com.personal.rebooked.user.role.RoleService;
import com.personal.rebooked.user.role.dto.CreateRoleDTO;
import com.personal.rebooked.user.role.models.Role;
import com.personal.rebooked.utils.Constants;
import com.personal.rebooked.utils.Misc;
import lombok.RequiredArgsConstructor;
import opennlp.tools.parser.Cons;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static com.personal.rebooked.utils.Misc.generateRandomPrice;
import static com.personal.rebooked.utils.Misc.getRandomElement;

@RequiredArgsConstructor
@Component
public class Seeder implements ApplicationRunner {

    private final RoleService roleService;

    private final UserService userService;

    private final CategoryService categoryService;

    private final Logger logger = Logger.getLogger(Seeder.class.getName());
    private final TagRepository tagRepository;
    private final FileService fileService;
    private final BookService bookService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        seedRoles();
        seedSuperAdmin();
        seedCategories();
//        seedBooks();
    }

    private void seedRoles() {
        List<CreateRoleDTO> roleDTOList = Constants.userRoleList;
        for (CreateRoleDTO createRoleDTO : roleDTOList) {
            try {
                Role role = roleService.getRoleByName(createRoleDTO.name());
            } catch (Exception e) {
                Role role = roleService.createRole(createRoleDTO);
                logger.info(String.format("Role %s created", role.getName()));
            }
        }
    }

    private void seedSuperAdmin() {
        try {
            User user = userService.findUserByEmail(Constants.superAdminDetails.email());
        } catch (Exception e) {
            User user = userService.createUser(Constants.superAdminDetails);
            logger.info(String.format("Super admin %s created", user.getFullName()));
        }

    }

    private void seedCategories() {
        List<CreateCategoryDTO> categoryDTOList = Constants.categoryList;
        for (CreateCategoryDTO createCategoryDTO : categoryDTOList) {
            categoryService.upsert(createCategoryDTO);
        }
    }

    private void seedBooks() {
        // Future implementation for seeding books
        // Fetch all available IDs
        List<String> categoryIds = categoryService.findAll()
                .stream()
                .map(Category::getId)
                .toList();

        List<String> tagNames = tagRepository.findAll()
                .stream()
                .map(Tag::getName)
                .toList();

        List<String> imageIds = fileService.getAllFiles()
                .stream()
                .map(File::getId)
                .toList();

        List<CreateBookDto> books = new ArrayList<>();

        for (Constants.BookData bookData : Constants.SAMPLE_BOOKS) {
            CreateBookDto bookDto = createBookDto(bookData, categoryIds, tagNames, imageIds);
            books.add(bookDto);
        }

        while (books.size() < 500) {
            Constants.BookData generatedBook = generateRandomBook();
            books.add(createBookDto(generatedBook, categoryIds, tagNames, imageIds));
        }

        User adminUser = userService.findUserByEmail(Constants.superAdminDetails.email());
        for (CreateBookDto bookDto : books) {
            try {
                bookService.create(adminUser, bookDto);
            } catch (Exception e) {
                logger.warning(String.format("Failed to add book %s: %s", bookDto.title(), e.getMessage()));
            }
        }
    }

    private CreateBookDto createBookDto(Constants.BookData bookData, List<String> categoryIds,
                                        List<String> tagNames, List<String> imageIds) {
        return new CreateBookDto(
                bookData.title(),
                bookData.author(),
                Misc.generateRandomPrice(),
                bookData.description(),
                Misc.getRandomElement(imageIds), // cover image
                Misc.getRandomIds(imageIds, 2, 4), // 2-4 additional images
                Misc.getRandomIds(categoryIds, 1, 10), // 1-10 categories
                tagNames.isEmpty() ? null : Misc.getRandomIds(tagNames, 0, 3) // 0-4 tags
        );
    }

    private Constants.BookData generateRandomBook() {
        Random random = new Random();
        String title;
        String author = getRandomElement(Constants.AUTHORS);
        String description;

        // Generate title using various patterns
        if (random.nextBoolean()) {
            // Pattern: Prefix + Suffix
            title = getRandomElement(Constants.TITLE_PREFIXES) + " " + getRandomElement(Constants.TITLE_SUFFIXES);
        } else {
            // Pattern: The + Adjective + Noun
            List<String> adjectives = Arrays.asList("Ancient", "Broken", "Silent", "Golden",
                    "Forgotten", "Sacred", "Dark", "Bright", "Eternal", "Mysterious");
            List<String> nouns = Arrays.asList("Journey", "Secret", "Promise", "Dream",
                    "Legend", "Story", "Mystery", "Adventure", "Quest", "Discovery");
            title = "The " + getRandomElement(adjectives) + " " + getRandomElement(nouns);
        }

        description = generateDescription(title);

        return new Constants.BookData(title, author, description);
    }

    private String generateDescription(String title) {
        List<String> templates = Arrays.asList(
                "A captivating tale that explores the depths of %s and the human condition.",
                "An extraordinary journey through %s that will leave readers questioning everything.",
                "A masterful exploration of %s, weaving together themes of love, loss, and redemption.",
                "Set against the backdrop of %s, this novel delves into the complexities of modern life.",
                "A thought-provoking examination of %s that challenges conventional wisdom.",
                "An unforgettable story of courage and determination in the face of %s.",
                "A richly detailed narrative that brings %s to vivid life on every page.",
                "A compelling drama that unfolds against the setting of %s and human resilience."
        );

        List<String> themes = Arrays.asList(
                "family dynamics", "societal change", "personal growth", "historical events",
                "technological advancement", "cultural identity", "moral dilemmas", "human nature",
                "social justice", "environmental challenges", "political upheaval", "spiritual awakening"
        );

        return String.format(getRandomElement(templates), getRandomElement(themes));
    }
}
