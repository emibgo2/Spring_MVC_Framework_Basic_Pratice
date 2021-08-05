package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService ;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        //Given ( a 환경이 주어졌을때 )
        Member member = new Member(1L, "memberA", Grade.VIP);

        //When ( b 활동을 했을 때 )
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //Then ( 결과 )
        Assertions.assertThat(member).isEqualTo(findMember);        // 검증 API

    }
}
