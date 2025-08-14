package com.personal.rebooked.seed;

import com.personal.rebooked.category.CategoryService;
import com.personal.rebooked.category.dto.CreateCategoryDTO;
import com.personal.rebooked.category.models.Category;
import com.personal.rebooked.user.UserService;
import com.personal.rebooked.user.dto.CreateUserDto;
import com.personal.rebooked.user.models.User;
import com.personal.rebooked.user.role.RoleService;
import com.personal.rebooked.user.role.dto.CreateRoleDTO;
import com.personal.rebooked.user.role.models.Role;
import com.personal.rebooked.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@RequiredArgsConstructor
@Component
public class Seeder implements ApplicationRunner {

    private final RoleService roleService;

    private final UserService userService;

    private final CategoryService categoryService;

    private final Logger logger = Logger.getLogger(Seeder.class.getName());

    @Override
    public void run(ApplicationArguments args) throws Exception {
        seedRoles();
        seedSuperAdmin();
        seedCategories();
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
}
