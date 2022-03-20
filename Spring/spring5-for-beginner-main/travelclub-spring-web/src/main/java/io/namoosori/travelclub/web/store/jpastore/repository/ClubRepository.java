package io.namoosori.travelclub.web.store.jpastore.repository;

import io.namoosori.travelclub.web.aggregate.club.TravelClub;
import io.namoosori.travelclub.web.store.jpastore.jpo.TravelClubJpo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubRepository extends JpaRepository<TravelClubJpo, String> {
                                                     //@Entity로 정의된 개체(Repository가 사용할 Entity), 식별자의 타입(여기선 String type의 id)

    //db에서 넘어올땐 jpo형태
   List<TravelClubJpo> findAllByName(String name);
}
