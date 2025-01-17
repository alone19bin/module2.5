package com.example.awsproject.repository;

import com.example.awsproject.model.Event;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends R2dbcRepository<Event, Long> {
}
