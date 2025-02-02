package com.bloodDonation.configs;

import com.bloodDonation.commons.interceptors.CommonInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@RequiredArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {

    private final CommonInterceptor commonInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //공통 인터셉터여서 모든 주소에 해당
        registry.addInterceptor(commonInterceptor);
                //모든 경로일때 생략가능
                //.addPathPatterns("/**");
    }
}
