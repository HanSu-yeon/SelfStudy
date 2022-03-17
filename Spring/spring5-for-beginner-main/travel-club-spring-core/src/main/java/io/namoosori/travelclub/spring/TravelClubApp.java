package io.namoosori.travelclub.spring;

import io.namoosori.travelclub.spring.aggregate.club.CommunityMember;
import io.namoosori.travelclub.spring.aggregate.club.TravelClub;
import io.namoosori.travelclub.spring.service.ClubService;
import io.namoosori.travelclub.spring.service.MemberService;
import io.namoosori.travelclub.spring.service.sdo.MemberCdo;
import io.namoosori.travelclub.spring.service.sdo.TravelClubCdo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Date;

public class TravelClubApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        String[] beanNames = context.getBeanDefinitionNames();
//        System.out.println(Arrays.toString(beanNames));

        MemberService memberService = context.getBean("memberServiceLogic", MemberService.class);

        String memberId = memberService.registerMember(
                new MemberCdo(
                        "test@mail.com",
                        "kim",
                        "test member",
                        "910-2901-2933",
                        "2022-05-02"));

        CommunityMember foundedMember = memberService.findMemberById(memberId);
        System.out.println(foundedMember.toString());

//        TravelClubCdo clubCdo = new TravelClubCdo("TravelClub", "Test TravelClub"); //cdo객체
//        ClubService clubService = context.getBean("clubService", ClubService.class);//빈을 찾아온다. clubservice를 통해 객체 넘겨줌

//        String clubId = clubService.registerClub(clubCdo);
//
//        TravelClub foundedClub = clubService.findClubById(clubId);
//        System.out.println("foundedClub.getName() = " + foundedClub.getName());
//        System.out.println("foundedClub.getIntro() = " + foundedClub.getIntro());
//        System.out.println(new Date(foundedClub.getFoundationTime()));
//


    }
}
