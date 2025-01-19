package ksh.BasicSpring.repository;

import ksh.BasicSpring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {   // 테스트는 서로 순서에 의존하지 않아야함

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach  // 메서드 실행이 끝날때마다 실행되는 메서드
    public void afterEach() {   // 테스트가 끝나면 데이터를 클리어해줘야함
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);


        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
        
        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
