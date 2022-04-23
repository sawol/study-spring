package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    // MemberServiceImpl는 추상화(MemberRepository)와 구체화(MemoryMemberRepository) 모두 의존하고 있음
    private final MemberRepository memberRepository;

    @Autowired          // MemberRepository 타입과 맞는 빈을 찾아 넣어줌 == ac.getBean(MemberRepository.class)
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
}
