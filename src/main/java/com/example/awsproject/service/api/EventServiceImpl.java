package com.example.awsproject.service.api;

import com.example.awsproject.model.Event;
import com.example.awsproject.repository.EventRepository;
import com.example.awsproject.service.EventService;
import com.example.awsproject.service.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.FileNotFoundException;


@Slf4j
@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public Mono<Event> create(Event event) {
        log.info("EventService, method create {} ", event);
        Event add = eventRepository.findById(event.getId()).block();

        if (add == null) {
            eventRepository.save(event);
        }
        return null;
    }

    @Override
    public Flux<Event> getAll() {
        log.info("EventService, method getAll {} ");
        return this.eventRepository.findAll()
                .onErrorMap(throwable -> new FileNotFoundException("there is no data to display"));
    }

    @Override
    public Mono<Event> getById(Long id) {
        log.info("EventService, method getById {} ", id);
        return this.eventRepository.findById(id)
                .onErrorMap(throwable -> new FileNotFoundException("no data available ID" + id));
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        log.info("EventService, method delete {} ", id);
        return this.eventRepository.deleteById(id)
                .onErrorMap(throwable -> new FileNotFoundException("no data available ID" + id));
    }

    @Override
    public boolean updateById(Long id, Event event) {
        log.info("EventService, method update {} ", id, " " + event);
        if (id == 0 && event == null) {
            throw new NotFoundException("ID == 0 and event==null check the correctness of the filling");
        }
        event = this.eventRepository.findById(id).block();
        this.eventRepository.save(event);
        return true;
    }
}
