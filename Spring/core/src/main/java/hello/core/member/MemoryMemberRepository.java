package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

//구현 클래스
@Component
public class MemoryMemberRepository implements MemberRepository{

    //저장소
    private static Map<Long, Member> store = new HashMap<>();
    //오류처리는 생략
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
