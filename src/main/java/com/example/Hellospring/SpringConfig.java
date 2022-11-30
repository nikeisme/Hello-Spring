package com.example.Hellospring;

import com.example.Hellospring.domain.Member;
import com.example.Hellospring.repository.MemberRepositiry;
import com.example.Hellospring.repository.MemoryMemberRepository;
import com.example.Hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// 자바 코드로 직접 스프링 빈 등록하기
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepositiry());
    }

    @Bean
    public MemberRepositiry memberRepositiry() {
        return new MemoryMemberRepository();
    }
}
