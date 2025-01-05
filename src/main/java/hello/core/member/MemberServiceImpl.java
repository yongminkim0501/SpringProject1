package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component//컴포넌트를 사용하면 autowired를 사용할 수 밖에 없음
        // 그러지 않으면 의존관계를 설정할 수 있는 방법이 없음.
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    //ac.getBean(MemberRepository.class) 이거와 같이 움직인다고 생각하면 됨
    @Autowired // autowired라는 기능을 생성자에 붙여주면 멤버 리파지토리
    // 타입에 맞는 애를 찾아와서 의존관계 주입을 자동으로 연결해서 주입해줌
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    ///Test 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
