![logo](https://github.com/co-smicDust/bookingsystem/blob/master/redbank.PNG)
# 헌혈의 집 예약 웹사이트

## 🔗INDEX
- 💉[프로젝트 소개](#프로젝트-소개)
  1. [프로젝트 기능](#1-프로젝트-기능)
  2. [사용 기술](#2-사용-기술)
  3. [실행 화면](#3-실행-화면)
     
- 🩸[구조 및 설계](#구조-및-설계)
  1. [DB 설계](#1-db-설계)
  2. [Flow Chart](#2-flow-chart)
     
- 💊[후기](#후기)

---

## 💉프로젝트 소개
중앙정보기술인재개발원의 Java 백엔드 개발자 국비과정에서 학습한 기술들을 토대로, 팀원들과 헌혈 예약 서비스를 제공하는 웹프로젝트를 진행했습니다. 
프로젝트가 끝난 후 개인적으로 아쉬웠던 부분들을 하나씩 업데이트했습니다.

- 진행 기간: 2023.12.31 ~ 2024.02.02


- 팀 구성 및 역할

  | 팀원 | 역할 |
  | ----- | -------|
  | 박도하 | 회원가입, 로그인 |
  | 윤예지 | 게시판 |
  | 장하영 | Front |
  | 정동화 | 마이페이지 |
  | 정민지 | 센터 예약, 예약 관리 |
  | 황보소영 | 센터 관리, 센터 검색 |


---

### 1. 프로젝트 기능
- 로그인 / 회원가입
- 마이페이지(전자문진, 헌혈내역조회)
- 헌혈의집 찾기
- 헌혈의집 상세 정보
- 헌혈 예약 
- 게시판(자주묻는질문, 고객상담)


### 2. 사용 기술
#### 2-1. 백엔드
|주요 프레임워크 / 라이브러리</span>|Build Tool / DataBase / etc...|
|---------------------------|------------------------------|
|- Java 17<br>- SpringBoot 3.2.0<br>- JPA(Spring Data JPA)<br>- Spring Security<br>- Thymeleaf<br>- Validation<br>- Lombok<br>- Spring Web|- Gradle 7.2<br>- Oracle 11<br>- kakaomap API|
#### 2-2. 프론트엔드
- Html/Css
- JavaScript
- Bootstrap 5.3.1


### 3. 실행 화면
<details><summary>메인 페이지</summary>
  <p>

- 로그인 전
  ![beforeLogin](https://github.com/co-smicDust/bookingsystem/blob/master/main.PNG)
  
- 로그인 후
  ![afterLogin](https://github.com/co-smicDust/bookingsystem/blob/master/login_main.PNG)

  </p>
</details>

<details><summary>헌혈의집</summary>
  <p>

- 헌혈의집 찾기
  ![centerSearch](https://github.com/co-smicDust/bookingsystem/blob/master/center_search.png)

- 헌혈의집 상세보기
  ![centerView](https://github.com/co-smicDust/bookingsystem/blob/master/center_view.png)

  </p>
</details>

<details><summary>헌혈 예약</summary>
  <p>

- Step1: 유의사항 안내
  ![reservationNotice](https://github.com/co-smicDust/bookingsystem/blob/master/reservation_notice.png)
  
- Step2: 헌혈의집과 날짜 선택
  ![centerSearch](https://github.com/co-smicDust/bookingsystem/blob/master/center_search.png)
  ![centerSearch](https://github.com/co-smicDust/bookingsystem/blob/master/center_view.png)

- Step3: 시간 및 방문인원 선택, 방문자 정보 기입
  ![reservationCenter](https://github.com/co-smicDust/bookingsystem/blob/master/reservation_center.PNG)

- Step4: 개인정보 수집 동의
  ![reservationAgreement](https://github.com/co-smicDust/bookingsystem/blob/master/reservation_agreement.png)

- Step5: 헌혈 예약 완료
  ![reservationComplete](https://github.com/co-smicDust/bookingsystem/blob/master/reservation_complete.png)

  </p>
</details>

---


## 🩸구조 및 설계
### 1. DB 설계
![ERD](https://github.com/co-smicDust/bookingsystem/blob/master/ERD.png)

### 2. Flow Chart
![FC](https://github.com/co-smicDust/bookingsystem/blob/master/reservation_flowchart.png)


---

## 💊후기

자바 국비과정에서 진행했기에 강사님의 코딩 스타일에 영향을 많이 받았던 프로젝트였습니다. 그에 따라 이전 프로젝트에서 중구난방이던 패키지 구조 및 네이밍 등이 체계적으로 발전하였습니다. 지난 5개월간 학습한 웹, 서버, DB 관련 작동 원리 및 연동 방법 또한 프로젝트 개발 과정을 통해 다시 한번 정리할 수 있었습니다. 그 외에 Thymeleaf, kakaomap 등 새로운 라이브러리 및 API를 공부하고 적용해볼 수 있었던 좋은 기회였습니다.
