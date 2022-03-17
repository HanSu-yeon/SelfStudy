package io.namoosori.travelclub.spring.store.mapstore;

import io.namoosori.travelclub.spring.aggregate.club.CommunityMember;
import io.namoosori.travelclub.spring.store.MemberStore;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MemberMapStore implements MemberStore {

    //key는 member id
    private Map<String, CommunityMember> memberMap;

    public MemberMapStore() {
        this.memberMap = new LinkedHashMap<>();
    }


    @Override  //memberMap에 저장
    public String create(CommunityMember member) {
        memberMap.put(member.getId(), member);
        return member.getId();
    }

    @Override //커뮤니티 멤버 찾기
    public CommunityMember retrieve(String memberId) {
       return memberMap.get(memberId);

    }

    @Override
    public CommunityMember retrieveByEmail(String email) {
        //email이 key가 아니기 때문에 반복문을 돌린다
        CommunityMember targetMember = null;
        for (CommunityMember member : memberMap.values()) {
            if (member.getEmail().equals(email)) {
                targetMember = member;
                break;
            }
        }
        return targetMember;
    }

    @Override //동일한 이름을 갖는 커뮤니티 멤버를 리스트 타입으로 반환
    public List<CommunityMember> retrieveByName(String name) {
        return memberMap.values().stream()
                .filter(member-> member.getName().equals(name))
                .collect(Collectors.toList());

    }

    @Override  //넘어온 member파라미터는 이미 업데이트된 상태이다
    public void update(CommunityMember member) {
        memberMap.put(member.getId(), member);
    }

    @Override
    public void delete(String memberId) {
        memberMap.remove(memberId);
    }

    @Override
    public boolean exists(String memberId) {
        return Optional.ofNullable(memberMap.get(memberId)).isPresent();
    }
}
