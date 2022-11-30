package com.example.Hellospring.controller;

import com.example.Hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    // MemberController 뿐 아닌 다른 Controller가 사용할 수 있는 가능성이 있음.
//    private final MemberService memberService = new MemberService();

    private final MemberService memberService;

    @Autowired // 스프링 컨테이너 안에 있는 MemberService 연결, 의존관계 주입
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


}
