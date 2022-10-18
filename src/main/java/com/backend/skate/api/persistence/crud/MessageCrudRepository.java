package com.backend.skate.api.persistence.crud;

import com.backend.skate.api.persistence.entity.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
