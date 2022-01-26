package hello.core.member;

import hello.core.AppConfig;

//회원서비스
public class MemberServiceImpl implements  MemberService{

    private final MemberRepository memberRepository;


    //생성자를 통해서 구현체의 내용을 선택한다
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
        //다형성에 의해서 MemoryMemberRepository에 있는 save가 호출
    }

    @Override
    public Member findMember(Long memberId) {

        return  memberRepository.findById(memberId);
    }
}
