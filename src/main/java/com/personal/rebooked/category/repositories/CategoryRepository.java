package com.personal.rebooked.category.repositories;

import com.personal.rebooked.category.models.Category;

import org.checkerframework.checker.units.qual.C;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends MongoRepository<Category, String> {
    Optional<Category> findByName(String name);

    @Aggregation(pipeline = {
            "{ $match: { isSeeded: true } }",
            "{ $lookup: { from: 'books', localField: 'books', foreignField: '_id', as: 'books' } }",
            "{ $addFields: { booksCount: { $size: '$books' } } }",
            "{ $sort: { booksCount: -1 } }",
            "{ $limit: ?0 }",
    })
    List<Category> findTopCategories(int limit);
}
