package com.example.Hellospring.repository;

import com.example.Hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repositiry = new MemoryMemberRepository();

    // Test 1번 이상의 실행이 끝난 후, 데이터 중복 방지를 위한 Repository clear
    @AfterEach
    public void afterEach() {
        repositiry.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repositiry.save(member);

        Member result = repositiry.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repositiry.save(member1);

        // Shift + F6 : 변수 한꺼번에 이름 변경 가능
        Member member2 = new Member();
        member2.setName("spring2");
        repositiry.save(member2);

        Member result = repositiry.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repositiry.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repositiry.save(member2);

        List<Member> result = repositiry.findAll();
        assertThat(result.size()).isEqualTo(2);
    }

}
