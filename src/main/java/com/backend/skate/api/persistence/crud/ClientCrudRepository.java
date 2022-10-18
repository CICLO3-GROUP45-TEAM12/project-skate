package com.backend.skate.api.persistence.crud;

import com.backend.skate.api.persistence.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository<Client, Integer> {
}
