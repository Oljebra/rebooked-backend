package com.personal.rebooked.utils;

import com.personal.rebooked.category.dto.CreateCategoryDTO;
import com.personal.rebooked.user.dto.CreateUserDto;
import com.personal.rebooked.user.role.dto.CreateRoleDTO;
import java.util.List;

public class Constants {

    public static List<CreateRoleDTO> userRoleList = List.of(
            new CreateRoleDTO("user", "USER"),
            new CreateRoleDTO("seller", "SELLER"),
            new CreateRoleDTO("admin", "ADMIN"),
            new CreateRoleDTO("superAdmin", "SUPER ADMIN"));

    public static CreateUserDto superAdminDetails = new CreateUserDto(
            "super_admin@rebooked.com",
            "Super Admin",
            "Admin_123",
            "superAdmin",
            true,
            null);

    public static List<CreateCategoryDTO> categoryList = List.of(
            new CreateCategoryDTO("Classic Literature", "Classic literature books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/book-classic.svg", true),
            new CreateCategoryDTO("Contemporary Fiction", "Modern fiction books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/book.svg", true),
            new CreateCategoryDTO("Mystery & Thriller", "Mystery and thriller books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/magnifying-glass.svg", true),
            new CreateCategoryDTO("Science Fiction", "Sci-fi books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/rocket.svg", true),
            new CreateCategoryDTO("Fantasy", "Fantasy books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/wand-sparkles.svg", true),
            new CreateCategoryDTO("Romance", "Romance books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/heart.svg", true),
            new CreateCategoryDTO("Historical Fiction", "Historical fiction books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/landmark.svg", true),
            new CreateCategoryDTO("Horror", "Horror books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/ghost.svg", true),
            new CreateCategoryDTO("Biographies & Memoirs", "Biography books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/user-pen.svg", true),
            new CreateCategoryDTO("Self-Help", "Self-help books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/hand-holding-heart.svg", true),
            new CreateCategoryDTO("Business & Economics", "Business books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/briefcase.svg", true),
            new CreateCategoryDTO("Science & Nature", "Science books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/flask.svg", true),
            new CreateCategoryDTO("History", "History books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/monument.svg", true),
            new CreateCategoryDTO("Travel", "Travel books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/plane.svg", true),
            new CreateCategoryDTO("True Crime", "True crime books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/handcuffs.svg", true),
            new CreateCategoryDTO("Philosophy", "Philosophy books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/brain.svg", true),
            new CreateCategoryDTO("Textbooks", "Academic textbooks",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/graduation-cap.svg", true),
            new CreateCategoryDTO("Reference Books", "Reference materials",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/books.svg", true),
            new CreateCategoryDTO("Study Guides", "Study materials",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/memo-pad.svg", true),
            new CreateCategoryDTO("Essays & Academic Papers", "Academic papers",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/file-lines.svg", true),
            new CreateCategoryDTO("Picture Books", "Children's picture books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/images.svg", true),
            new CreateCategoryDTO("Middle Grade Fiction", "Middle grade books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/child.svg", true),
            new CreateCategoryDTO("Young Adult Fantasy", "YA fantasy books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/dragon.svg", true),
            new CreateCategoryDTO("Young Adult Contemporary", "YA contemporary books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/user-graduate.svg", true),
            new CreateCategoryDTO("Cookbooks & Food", "Cooking books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/utensils.svg", true),
            new CreateCategoryDTO("Gardening", "Gardening books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/seedling.svg", true),
            new CreateCategoryDTO("Crafts & DIY", "Craft books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/scissors.svg", true),
            new CreateCategoryDTO("Health & Fitness", "Health books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/dumbbell.svg", true),
            new CreateCategoryDTO("Sports & Outdoors", "Sports books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/baseball.svg", true),
            new CreateCategoryDTO("Photography", "Photography books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/camera.svg", true),
            new CreateCategoryDTO("Art & Design", "Art books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/palette.svg", true),
            new CreateCategoryDTO("Music & Performing Arts", "Music books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/music.svg", true),
            new CreateCategoryDTO("Film & TV", "Film and TV books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/film.svg", true),
            new CreateCategoryDTO("Spiritual Growth", "Spiritual books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/om.svg", true),
            new CreateCategoryDTO("Religious Texts", "Religious books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/place-of-worship.svg", true),
            new CreateCategoryDTO("Meditation & Mindfulness", "Meditation books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/peace.svg", true),
            new CreateCategoryDTO("Poetry", "Poetry books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/feather.svg", true),
            new CreateCategoryDTO("Comics & Graphic Novels", "Comic books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/masks-theater.svg", true),
            new CreateCategoryDTO("Short Story Collections", "Short story books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/bookmark.svg", true),
            new CreateCategoryDTO("Rare & Collectible Editions", "Rare books",
                    "https://site-assets.fontawesome.com/releases/v6.5.1/svgs/solid/gem.svg", true));

    public enum RegistrationType {
        GOOGLE,
        FACEBOOK,
        EMAIL
    }

    public enum BookStatus {
        ACTIVE,
        INACTIVE,
        SOLD
    }

    public enum TimeQuery {
        LAST_WEEK,
        LAST_TWO_WEEKS,
        LAST_MONTH,
        LAST_SIX_MONTHS,
        LAST_YEAR
    }

    public enum ChatType {
        BiLL,
        MESSAGE
    }
}
