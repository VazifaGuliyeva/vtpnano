package com.example.vtpnano.controller;

import com.example.vtpnano.dto.MemberDto;
import com.example.vtpnano.entity.Member;
import com.example.vtpnano.repository.MemberRepository;
import com.example.vtpnano.service.MemberImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/members")
@AllArgsConstructor
public class MemberController {

    private final MemberImpl memberImpl;

    @GetMapping
    public List<MemberDto> getAll() {
        return memberImpl.getAll();
    }
    @GetMapping("/{id}")
    public MemberDto getById(@PathVariable UUID id) {
        return memberImpl.getById(id);
    }
    @PostMapping
    public void createMember(@RequestBody MemberDto memberDto) {
        memberImpl.createMember(memberDto);


    }
    @PutMapping("/{id}")
    public void updateMember(@PathVariable UUID id,@RequestBody MemberDto memberDto) {
        memberImpl.updateMember(id,memberDto);

    }
    @DeleteMapping
    public void deleteAllMember() {
        memberImpl.deleteAllMember();

    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        memberImpl.deleteById(id);

    }
    @GetMapping("/search/{name}")
    public List<MemberDto> searchMember(@PathVariable String name) {
        return memberImpl.searchMember(name);
    }

}
