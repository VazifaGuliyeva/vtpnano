package com.example.vtpnano.service;

import com.example.vtpnano.dto.MemberDto;
import com.example.vtpnano.entity.Member;
import com.example.vtpnano.errors.MemberNotFoundException;
import com.example.vtpnano.mapper.MemberMapper;
import com.example.vtpnano.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
@Component
@AllArgsConstructor
public class MemberImpl implements MemberService{

    private final MemberRepository memberRepository;

    private final MemberMapper memberMapper;
    @Override
    public List<MemberDto> getAll() {

        return memberMapper.toMemberDtoList(memberRepository.findAll());
    }

    @Override
    public MemberDto getById(UUID id) {

        return memberMapper.toMemberDto(memberRepository.findById(id).orElseThrow(()->new MemberNotFoundException("Member is not found")));
    }

    @Override
    public void createMember(MemberDto memberDto) {
        Member member1=memberMapper.toMember(memberDto);
        memberRepository.save(member1);

    }

    @Override
    public void updateMember(UUID id,MemberDto memberDto) {
        Member existingMember=memberRepository.findById(id).orElseThrow(()->new MemberNotFoundException("Member is not found"));

        existingMember.setId(memberDto.getId());
        existingMember.setName(memberDto.getName());
        existingMember.setSurname(memberDto.getSurname());
        existingMember.setAge(memberDto.getAge());
        existingMember.setGender(memberDto.getGender());
        existingMember.setQualification(memberDto.getQualification());
        existingMember.setUniversity(memberDto.getUniversity());
        existingMember.setMasterDegree(memberDto.getMasterDegree());

        memberRepository.save(existingMember);

    }

    @Override
    public void deleteAllMember() {
        memberRepository.deleteAll();

    }

    @Override
    public void deleteById(UUID id) {
        memberRepository.deleteById(id);

    }
}
