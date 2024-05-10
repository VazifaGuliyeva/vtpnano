package com.example.vtpnano.service;


import com.example.vtpnano.dto.EventDto;
import com.example.vtpnano.entity.Events;

import java.util.List;
import java.util.UUID;

public interface EventService {

    List<EventDto> getAll();

    EventDto getById(UUID id);


    void createMember(EventDto eventDto);

    void updateMember(UUID id,EventDto eventDto);

    void deleteAllMember();

    void deleteById(UUID id);




}
