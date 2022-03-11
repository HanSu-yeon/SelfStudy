package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    //가입을하고 회원을 찾으려면 뭐가 필요할까? -> MemberRepository필요 -> 구현체(MemoryMemberRepository)도 선택해준다
    private final MemberRepository memberRepository;

    @Autowired //ac.getBean(MemberRepository.class)
    //MemberRepository의 구현객체가 뭐가 들어갈지를 생성자를 통해 결정
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        //다형성에의해 MemoryMemberRepository에 있는 save가 호출된다
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
