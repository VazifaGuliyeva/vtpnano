package com.example.vtpnano.controller;

import com.example.vtpnano.dto.EventDto;
import com.example.vtpnano.entity.Events;
import com.example.vtpnano.service.EventImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/events")
@AllArgsConstructor
public class EventController {

    private final EventImpl eventImpl;
    @GetMapping
    public List<EventDto> getAll() {
        return eventImpl.getAll();
    }

    @GetMapping("/{id}")
    public EventDto getById(@PathVariable UUID id) {
        return eventImpl.getById(id);
    }
    @PostMapping
    public void createEvent(@RequestBody EventDto eventDto) {
        eventImpl.createMember(eventDto);

    }
    @PutMapping
    public void updateEvent(@PathVariable UUID id,@RequestBody EventDto eventDto) {
        eventImpl.updateMember(id,eventDto);

    }
    @DeleteMapping
    public void deleteAllMember() {

        eventImpl.deleteAllMember();
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {

        eventImpl.deleteById(id);

    }

}
