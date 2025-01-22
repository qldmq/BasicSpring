package ksh.BasicSpring.controller;

import ksh.BasicSpring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired  // memberService를 스프링이 스프링 컨테이너에 있는 memberService를 가져와 연결해줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
