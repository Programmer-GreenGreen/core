package hello.core.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId); //memberid 로 멤버를 찾는다
}
