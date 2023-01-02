package com.bilgeadam.commentappJava4.mapper;

import com.bilgeadam.commentappJava4.dto.request.UserCreateRequestDto;
import com.bilgeadam.commentappJava4.dto.response.UserCreateResponseDto;
import com.bilgeadam.commentappJava4.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {


    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(final UserCreateRequestDto dto);

    UserCreateResponseDto toUserCreateResponseDto(final User user);

    UserCreateResponseDto toUserCreateResponseDto(final UserCreateRequestDto dto);

}
