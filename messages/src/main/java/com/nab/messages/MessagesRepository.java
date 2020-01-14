package com.nab.messages;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagesRepository extends ReactiveCrudRepository<Message, String> {
}
