package io.namoosori.travelclub.web.store.jpastore;

import io.namoosori.travelclub.web.aggregate.club.TravelClub;
import io.namoosori.travelclub.web.store.ClubStore;
import io.namoosori.travelclub.web.store.jpastore.jpo.TravelClubJpo;
import io.namoosori.travelclub.web.store.jpastore.repository.ClubRepository;
import io.namoosori.travelclub.web.util.exception.NoSuchClubException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ClubJpaStore implements ClubStore {

    private ClubRepository clubRepository;

    public ClubJpaStore(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public String create(TravelClub club) {
        //create메서드가 service를 통해 호출이된다 -> 새롭게 등록되어야하는 파라미터 club이 넘어옴->jpo로 변경 ->db저장
        clubRepository.save(new TravelClubJpo(club));
        System.out.println("club.getId() = " + club.getId());
        return club.getId();
    }

    @Override
    public TravelClub retrieve(String clubId) {
        Optional<TravelClubJpo> clubJpo = clubRepository.findById(clubId);
        if (!clubJpo.isPresent()) {
            throw new NoSuchClubException(String.format("Travle(%s) is not found.",clubId));
        }
        //optional로 되어있으니 get()한거임
        return clubJpo.get().toDomain();
    }

    @Override
    public List<TravelClub> retrieveByName(String name) {
        List<TravelClubJpo> clubJpos = clubRepository.findAllByName(name);
        return clubJpos.stream().map(clubJpo -> clubJpo.toDomain()).collect(Collectors.toList());
    }

    @Override
    public List<TravelClub> retrieveAll() {
        List<TravelClubJpo> clubJpos = clubRepository.findAll();
        //domain객체로 변환
//       return clubJpos.stream().map(clubJpo -> clubJpo.toDomain()).collect(Collectors.toList());
        return clubJpos.stream().map(TravelClubJpo::toDomain).collect(Collectors.toList());


    }

    @Override
    public void update(TravelClub club) {
        clubRepository.save(new TravelClubJpo(club));
        /*
        jpa에서는 post를 하거나 put할때 처음 select를 통해 해당 데이터가 있는지 확인. 없으면 넣고 있으면 업데이트를 진행한다
        * */
    }

    @Override
    public void delete(String clubId) {
        clubRepository.deleteById(clubId);
    }

    @Override
    public boolean exists(String clubId) {
        return clubRepository.existsById(clubId);
    }
}
