package com.backend.skate.api.persistence.crud;

import com.backend.skate.api.persistence.entity.Skate;
import org.springframework.data.repository.CrudRepository;

public interface SkateCrudRepository extends CrudRepository<Skate, Integer> {
}
