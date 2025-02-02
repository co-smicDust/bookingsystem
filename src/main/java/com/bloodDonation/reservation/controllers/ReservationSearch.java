package com.bloodDonation.reservation.controllers;

import lombok.Data;

import java.util.List;

@Data
public class ReservationSearch {
    private int page=1;
    private int limit = 20;
    private List<String> userId;

    /*
    private List<String> userName;
    private List<String> center;

    private List<Long> bookCode;


 */
    //예약 날짜 범위
    //private LocalDate sDate; //예약 시작날짜
    //private LocalDate eDate; //예약 끝 날짜
    private String sopt; //검새 옵션
    private String skey; //검색 키워드
}
