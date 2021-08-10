package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository ;

    @Autowired // 생성자에 Autowired 시
    // MemberRepository 파일에 맞는 애를 찾아와서 의존 관계에 맞는 객체를 자동으로 연결해서 주입
    // ac.getBean(MemberRepository.class) 와 비슷한 역할
    public MemberServiceImpl(MemberRepository memberRepository) {
        this. memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
