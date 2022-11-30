package com.example.Hellospring.service;

import com.example.Hellospring.domain.Member;
import com.example.Hellospring.repository.MemberRepositiry;
import com.example.Hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepositiry memberRepositiry;

    // DI설정
    @Autowired // 의존관계 주입
    public MemberService(MemberRepositiry memberRepositiry) {
        this.memberRepositiry = memberRepositiry;
    }

    /* 회원가입 */
    public Long join(Member member) {

        //같은 이름이 있는 중복 회원 , ctrl+alt+v = 변수 추출 , ctrl+Alt+M : 메서드 추출
        validateDuplicateMember(member);
        memberRepositiry.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepositiry.findByName(member.getName())
             .ifPresent( m ->{
                 throw new IllegalStateException("이미 존재하는 회원입니다");
         });
    }

    /* 전체 회원 조회 */
    public List<Member> findMembers(){
        return memberRepositiry.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepositiry.findById(memberId);
    }

}
