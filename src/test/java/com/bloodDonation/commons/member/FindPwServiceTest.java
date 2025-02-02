package com.bloodDonation.commons.member;

import com.bloodDonation.member.service.FindPwService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
//초기화된 비밀번호 업데이트 및 메일전송 테스트
@SpringBootTest
public class FindPwServiceTest {

    @Autowired
    private FindPwService service;

    @Test
    @DisplayName("비밀번호 초기화 및 초기화된 메일 이메일 전송 테스트")
    void resetTest(){
        assertDoesNotThrow(() -> service.reset("qkrthdus5147@gmail.com"));
    }
}
