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

    // 회원 ID로 조회
    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    // 회원 이름으로 조회
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    // 전체 회원 조회
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
