package com.example.vtpnano.service;

import com.example.vtpnano.dto.EventDto;
import com.example.vtpnano.entity.Events;
import com.example.vtpnano.errors.EventNotFoundException;
import com.example.vtpnano.mapper.EventMapper;
import com.example.vtpnano.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
@Component
@AllArgsConstructor
public class EventImpl implements EventService{

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    @Override
    public List<EventDto> getAll() {
        return eventMapper.toEventDtoList(eventRepository.findAll());
    }

    @Override
    public EventDto getById(UUID id) {
        return eventMapper.toEventDto(eventRepository.findById(id).orElseThrow(()->new EventNotFoundException("Event is not found")));
    }

    @Override
    public void createMember(EventDto eventDto) {
        Events events=eventMapper.toEvent(eventDto);
        eventRepository.save(events);

    }

    @Override
    public void updateMember(UUID id,EventDto eventDto) {

        Events existingEvent=eventRepository.findById(id).orElseThrow(()-> new EventNotFoundException("Event is not found"));

        existingEvent.setId(eventDto.getId());
        existingEvent.setEventName(eventDto.getEventName());

        eventRepository.save(existingEvent);

    }

    @Override
    public void deleteAllMember() {

        eventRepository.deleteAll();

    }

    @Override
    public void deleteById(UUID id) {

        eventRepository.deleteById(id);

    }
}
