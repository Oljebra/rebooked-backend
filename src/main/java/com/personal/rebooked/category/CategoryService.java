package com.personal.rebooked.category;

import com.mongodb.client.result.UpdateResult;
import com.personal.rebooked.category.dto.CreateCategoryDTO;
import com.personal.rebooked.category.dto.UpdateCategoryDTO;
import com.personal.rebooked.category.models.Category;
import com.personal.rebooked.category.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;

import org.checkerframework.checker.units.qual.A;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final org.springframework.data.mongodb.core.MongoTemplate mongoTemplate;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(String id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
    }

    public Category findByName(String name) {
        return categoryRepository.findByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
    }

    public Category create(CreateCategoryDTO createCategoryDTO) {
        Category category = new Category();
        category.setName(createCategoryDTO.name());
        category.setDescription(createCategoryDTO.description());
        category.setImageUrl(createCategoryDTO.imageUrl());
        category.setIsSeeded(createCategoryDTO.isSeeded());
        return categoryRepository.save(category);
    }

    public void upsert(CreateCategoryDTO createCategoryDTO) {
        Query query = new Query(Criteria.where("name").is(createCategoryDTO.name()));
        Update update = new Update()
                .set("description", createCategoryDTO.description())
                .set("imageUrl", createCategoryDTO.imageUrl())
                .set("isSeeded", createCategoryDTO.isSeeded());

        mongoTemplate.upsert(query, update, Category.class);
    }

    public Category update(String id, UpdateCategoryDTO updateCategoryDTO) {
        Category category = findById(id);
        if (updateCategoryDTO.name() != null) {
            category.setName(updateCategoryDTO.name());
        }
        return categoryRepository.save(category);
    }

    public List<Category> fetchTopCategories(int limit) {
        List<Category> categories = categoryRepository.findTopCategories(limit);
        return categories;
    }

    public void delete(String id) {
        categoryRepository.deleteById(id);
    }

}
