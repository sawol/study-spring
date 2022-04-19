package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // MemberServiceImpl는 추상화(MemberRepository)와 구체화(MemoryMemberRepository) 모두 의존하고 있음
    private final MemberRepository memberRepository;

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
