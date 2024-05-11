package com.example.vtpnano.repository;

import com.example.vtpnano.dto.MemberDto;
import com.example.vtpnano.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MemberRepository extends JpaRepository<Member, UUID> {

    List<Member> findByNameContainingIgnoreCaseOrSurnameContainingIgnoreCase(String name,String surname);
    List<Member> findMembersByNameContainingIgnoreCaseOrSurnameContainingIgnoreCase(String name,String surname);
    List<Member> findMembersByNameStartsWith(String name);

}
