package com.backend.skate.api.persistence.crud;

import com.backend.skate.api.persistence.entity.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminCrudRepository extends CrudRepository<Admin, Integer> {
}
