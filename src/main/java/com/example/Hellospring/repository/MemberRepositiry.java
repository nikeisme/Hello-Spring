package com.example.Hellospring.repository;

import com.example.Hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepositiry {

    Member save(Member member);
    Optional<Member> findById(Long id); // Null 값을 대비하여 Optional로 설정
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
