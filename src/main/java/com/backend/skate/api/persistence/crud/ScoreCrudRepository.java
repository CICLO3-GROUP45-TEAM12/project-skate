package com.backend.skate.api.persistence.crud;

import com.backend.skate.api.persistence.entity.Score;
import org.springframework.data.repository.CrudRepository;

public interface ScoreCrudRepository extends CrudRepository<Score, Integer> {
}
