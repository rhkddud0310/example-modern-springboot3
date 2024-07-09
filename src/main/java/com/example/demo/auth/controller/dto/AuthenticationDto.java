package com.example.demo.auth.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;

public final class AuthenticationDto { // final: 습관상 붙이면 좋은 거.
    private AuthenticationDto() {} // 습관상 붙이면 좋은 거.

    // DTO 만들기에 최적화된 클래스 (JDK 16+)
    @Builder
    public record SignUpRequest(
            @NotBlank // null, "", " "
            @Pattern(regexp = "^[a-z]+[a-z0-9]{3,30}$")
            String username,
            @NotBlank
            @Pattern(regexp = "(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,100}$")
            String password,
            @NotBlank
            String nickname
    ) {
        // compact 생성자 (소괄호가 없는 생성자)
        public SignUpRequest {
            // 생성자 파라미터 검토하고 수정 가능
            // nickname = nickname.trim(); // trim(): 앞뒤 공백 제거
            nickname = nickname.strip(); // strip(): 앞뒤 '공백으로 보이는 모든 유니코드상의 문자' 제거
        }
    }

    @Builder
    public record SignUpResponse() {}
}