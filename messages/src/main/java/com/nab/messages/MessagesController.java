package com.nab.messages;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log4j2
@RestController
@CrossOrigin
public class MessagesController {
    
    @Autowired
    private MessagesRepository repository;

    @GetMapping("/messages/v0/messages")
    public Flux findAll() {
        log.info("findAll");
        return repository.findAll();
    }

    @PostMapping("/messages/v0/messages")
    public Mono create(@RequestBody Message message){
        log.info("save {}", message.toString());
        return repository.save(message);
    }
}