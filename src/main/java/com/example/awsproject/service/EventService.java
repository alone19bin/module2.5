package com.example.awsproject.service;

import com.example.awsproject.model.Event;
import com.example.awsproject.repository.EventRepository;
import com.example.awsproject.service.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.FileNotFoundException;


public interface EventService {
    Mono<Event> create(Event event);
    Flux<Event> getAll();
    Mono<Event> getById(Long id);
    Mono<Void> deleteById(Long id);
    boolean updateById(Long id, Event event);

}
