package com.bilgeadam.commentappJava4.dto.request;

import com.bilgeadam.commentappJava4.repository.entity.EUserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreateRequestDto {
    @NotBlank
    private String name;
    @NotBlank
    private String surName;
    @Email
    private String email;
    @Size(min = 4, max = 32, message = "Şifre en az 4 karakter en fazla 32 karakter olmalıdır")
    private String password;
    @Builder.Default
    private EUserType userType = EUserType.USER;

}
