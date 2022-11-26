package com.example.Hellospring.repository;

import com.example.Hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepositiry {

    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence =0L; // key값을 생성

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
