package com.charitha.practise.controller;

import com.charitha.practise.util.CRUDOperation;
import com.charitha.practise.model.Event;
import com.charitha.practise.service.EventService;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EventController {

    private EventService eventService;

    EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping(method= RequestMethod.GET)
    public List<Event> findAll() {
        return eventService.findAll();
    }

    @RequestMapping(method= RequestMethod.POST)
    public Event eventCRUD(@RequestParam String operationType, @RequestBody Event event) throws Exception {
        switch (Enum.valueOf(CRUDOperation.class, operationType)) {
            case ADD:
                return eventService.create(event);
            case EDIT:
                return eventService.edit(event);
            case DELETE:
                eventService.delete(event);
                return null;
            default:
                return null;
        }
    }
}
