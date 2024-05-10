package com.example.vtpnano.repository;

import com.example.vtpnano.dto.MemberDto;
import com.example.vtpnano.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MemberRepository extends JpaRepository<Member, UUID> {

}
