package com.example.awsproject.rest.api;

import com.example.awsproject.model.Event;
import com.example.awsproject.rest.EventRestControllerV1;
import com.example.awsproject.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/events/")
public class EventRestControllerV1Impl implements EventRestControllerV1 {

    private final EventService eventService;

    @Override
    @PostMapping
    public Mono<Event> create(@RequestBody Event event) {
        log.info("EventRestControllerV1, method create {} ", event);
        return this.eventService.create(event);
    }

    @Override
    @GetMapping
    public Flux<Event> getAll() {
        log.info("EventRestControllerV1, method getAll {} ");
        return this.eventService.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public Mono<Event> getById(@PathVariable Long id) {
        log.info("EventRestControllerV1, method getById {} ", id);
        return this.eventService.getById(id);
    }

    @Override
    @PostAuthorize("returnObject.owner==principal.username")
    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        log.info("EventRestControllerV1, method delete {} ", id);
        return this.eventService.deleteById(id);
    }

    @Override
    @PutMapping("/{id}")
    public boolean update(@PathVariable Long id, Event event) {
        log.info("EventRestControllerV1, method update {} ", id);
        return this.eventService.updateById(id, event);

    }
}
