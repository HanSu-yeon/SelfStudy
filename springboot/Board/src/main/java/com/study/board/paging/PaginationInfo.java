package com.study.board.paging;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
//페이징 정보(화면 하단 페이지 번호) 계산용 클래스 https://congsong.tistory.com/26?category=749196
@Getter
@Setter
public class PaginationInfo {
    //페이징 계산에 필요한 파라미터들이 담길 클래스. Criteria클래스의 멤버 변수들에 대한 정보를 가지는 변수
    private Criteria criteria;
    //전체 데이터 개수
    private int totalRecordCount;
    //전체 페이지 개수(ex. 전체 데이터 수가 300개, 페이지당 출력할 데이터 개수가 10개 -->30페이지)
    private int totalPageCount;
    //페이지 리스트의 첫 페이지 번호
    private int firstPage;
    //페이지 리스트의 마지막 페이지 번호
    private int lastPage;
    //SQL의 조건절에 사용되는 첫 RNUM
    private int firstRecordIndex;
    //SQL의 조건절에 사용되는 마지막 RNUM
    private int lastRecordIndex;
    //이전 페이지 존재 여부
    private boolean hasPreviousPage;
    //다음 페이지 존재 여부
    private boolean hasNextPage;

    public PaginationInfo(Criteria criteria) {
        if(criteria.getCurrentPageNo()<1){
            criteria.setCurrentPageNo(1);
        }
        if (criteria.getRecordsPerPage() < 1 || criteria.getRecordsPerPage()>100) {
            criteria.setRecordsPerPage(10);
        }

        if (criteria.getPageSize() < 5 || criteria.getPageSize() > 20) {
            criteria.setPageSize(10);
        }
        this.criteria = criteria;
    }

    public void setTotalRecordCount(int totalRecordCount) {
        this.totalPageCount=totalRecordCount;
        //전체 데이터 개수가 1개 이상이면 calculation 메서드 실행
        if (totalRecordCount > 0) {
            calculation();
        }
    }

    private void calculation(){
        //전체 페이지 수(현재 페이지 번호가 전체 페이지 수보다 크면 현재 페이지 번호에 전체 페이지 수를 저장
        //전체 페이지 개수 = ((전체 데이터 개수-1)/페이지당 출력할 데이터 개수)+1
        totalPageCount = ((totalPageCount-1)/criteria.getRecordsPerPage())+1;
        //현재 페이지 번호 > 전체 페이지 개수의 값
        if (criteria.getCurrentPageNo() > totalPageCount) {
            //현재 페이지에 전체 페이지 개수를 저장
            criteria.setCurrentPageNo(totalPageCount);

        }
        //페이지 리스트의 첫 페이지 번호
        //((현재 페이지 번호 -1 ) / 화면 하단의 페이지 개수) * 화면 하단의 페이지 개수 + 1
        firstPage = ((criteria.getCurrentPageNo()-1) / criteria.getPageSize())*criteria.getPageSize()+1;

        //페이지 리스트의 마지막 페이지 번호(마지막 페이지가 전체 페이지 수보다 크면 마지막 페이지에 전체 페이지 수를 저장
        //마지막 페이지 번호 = (첫 페이지 번호 + 화면 하단의 페이지 개수) -1
        lastPage=firstPage+criteria.getPageSize()-1;
        if (lastPage > totalPageCount) {
            lastPage=totalPageCount;
        }

        //SQL의 조건절에 사용되는 첫 RNUM
        firstRecordIndex = (criteria.getCurrentPageNo()-1)*criteria.getRecordsPerPage();
        //SQL의 조건절에 사용되는 마지막 RNUM
        lastRecordIndex = criteria.getCurrentPageNo()* criteria.getRecordsPerPage();
        //이전 페이지 존재 여부
        hasPreviousPage = firstPage !=1;
        //다음 페이지 존재 여부
        hasNextPage=(lastPage * criteria.getRecordsPerPage()) < totalRecordCount;

    }
}
