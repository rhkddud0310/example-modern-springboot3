package com.example.demo.auth.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(
        name = "account"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Account {
    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;

    private String username;
    private String password;
    private String nickname;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    private Instant createdAt;
    private Instant updatedAt;

    // setter 삼가기.
    // 수정할 부분만 모아서 update 메서드를 따로 만드는 것.

    public void updatePassword(String password) {
                this.password = password;
    }
}