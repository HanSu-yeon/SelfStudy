package io.namoosori.travelclub.web.controller;

import io.namoosori.travelclub.web.aggregate.club.TravelClub;
import io.namoosori.travelclub.web.service.ClubService;
import io.namoosori.travelclub.web.service.sdo.TravelClubCdo;
import io.namoosori.travelclub.web.shared.NameValueList;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/club")
public class ClubController {

    private ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @PostMapping("/club") //localhost:8090/club  <-데이터가 바디에 담겨온다 @RequestBody붙여줌
    public String register(@RequestBody TravelClubCdo travelClubCdo) {
        return clubService.registerClub(travelClubCdo);
    }

    @GetMapping("/club/all")
    public List<TravelClub> findAll(){
        return clubService.findAll();
    }

    @GetMapping("/club/{clubId}")
    public TravelClub find(@PathVariable String clubId) {
        return clubService.findClubById(clubId);
    }

     @GetMapping("/club") //스트링검색 localhost:8090/club?name=JavaClub  @RequestParam
    public List<TravelClub> findByName(@RequestParam String name) {
        return clubService.findClubsByName(name);
    }

    @PutMapping("/club/{clubId}")  //nameValueList: 수정한값들
    public void modify(@PathVariable String clubId, @RequestBody NameValueList nameValueList) {
        clubService.modify(clubId,nameValueList);
    }


    @DeleteMapping("/club/{clubId}")
    public void delete(@PathVariable String clubId) {
        clubService.remove(clubId);
    }
}

