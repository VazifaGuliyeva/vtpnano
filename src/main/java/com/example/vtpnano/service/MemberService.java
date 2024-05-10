package com.example.vtpnano.service;

import com.example.vtpnano.dto.MemberDto;
import com.example.vtpnano.entity.Member;

import java.util.List;
import java.util.UUID;

public interface MemberService {

    List<MemberDto> getAll();

    MemberDto getById(UUID id);


    void createMember(MemberDto memberDto);

    void updateMember(UUID id,MemberDto member);

    void deleteAllMember();

    void deleteById(UUID id);
}
