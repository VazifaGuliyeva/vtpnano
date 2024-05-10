package com.example.vtpnano.mapper;


import com.example.vtpnano.dto.EventDto;
import com.example.vtpnano.dto.MemberDto;
import com.example.vtpnano.entity.Events;
import com.example.vtpnano.entity.Member;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {

    List<EventDto> toEventDtoList(List<Events> events);


    EventDto toEventDto(Events events);

    Events toEvent(EventDto eventDto);
}
