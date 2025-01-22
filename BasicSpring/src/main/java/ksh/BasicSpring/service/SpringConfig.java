package ksh.BasicSpring.service;

import ksh.BasicSpring.repository.MemberRepository;
import ksh.BasicSpring.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());   // 스프링빈에 등록된 memberRepository를 MemberService에 넣어줌
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
