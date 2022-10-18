package com.backend.skate.api.persistence.crud;

import com.backend.skate.api.persistence.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository<Category, Integer> {
}
