package io.namoosori.travelclub.spring.store.mapstore;

import io.namoosori.travelclub.spring.aggregate.club.TravelClub;
import io.namoosori.travelclub.spring.store.ClubStore;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("clubStore")
public class ClubMapStore implements ClubStore {

    //연결된 db가 없어서 LinkedHashmap을 사용해 저장
    private Map<String, TravelClub> clubMap;

    public ClubMapStore() {
        this.clubMap = new LinkedHashMap<>(); //hashmap을 인스턴스화 해준다
    }

    @Override
    public String create(TravelClub club) {
        clubMap.put(club.getId(), club);
        return club.getId();
    }

    @Override  //검색
    public TravelClub retrieve(String clubId) {
        return clubMap.get(clubId);
    }

    @Override  //동일한 이름의 클럽들이 있을수도 있음 ->List로 반환
    public List<TravelClub> retrieveByName(String name) {
        return clubMap.values().stream()
                .filter(club -> club.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public void update(TravelClub club) {
        clubMap.put(club.getId(), club);
    }

    @Override
    public void delete(String clubId) {
        clubMap.remove(clubId);
    }

    @Override
    public boolean exists(String clubId) {
//        return clubMap.containsKey(clubId); //방법1
        return Optional.ofNullable(clubMap.get(clubId)).isPresent(); //방법2
    }
}
