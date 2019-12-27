package com.charitha.practise.service;

import com.charitha.practise.model.Event;
import com.charitha.practise.repository.EventRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private EventRepository eventRepository;

    EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> findAll() {
        return (List<Event>) eventRepository.findAll();
    }

    public Event create(Event event) {
        return eventRepository.save(event);
    }

    public Event edit(Event event) throws Exception {
        if (eventRepository.findById(event.getId()) != null) {
            return eventRepository.save(event);
        } else {
            throw new Exception("Event not found by Id:" + event.getId());
        }
    }

    public void delete(Event event) {
        eventRepository.delete(event);
    }
}
