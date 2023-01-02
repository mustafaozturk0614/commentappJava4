package com.bilgeadam.commentappJava4.dto.response;

import com.bilgeadam.commentappJava4.repository.entity.EUserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreateResponseDto {

    private String name;
    private String surName;
    private String email;
    private EUserType userType;

}
