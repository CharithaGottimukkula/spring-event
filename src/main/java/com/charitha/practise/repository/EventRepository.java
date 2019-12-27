package com.charitha.practise.repository;

import com.charitha.practise.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, String> {
}
