package com.example.vtpnano.mapper;

import com.example.vtpnano.dto.MemberDto;
import com.example.vtpnano.entity.Member;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    List<MemberDto> toMemberDtoList(List<Member> members);


    MemberDto toMemberDto(Member member);

    Member toMember(MemberDto memberDto);
}
