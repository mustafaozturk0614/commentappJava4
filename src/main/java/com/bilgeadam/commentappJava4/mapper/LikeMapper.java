package com.bilgeadam.commentappJava4.mapper;

import com.bilgeadam.commentappJava4.dto.request.LikeCreateRequestDto;
import com.bilgeadam.commentappJava4.dto.response.LikeResponseDto;
import com.bilgeadam.commentappJava4.repository.entity.Like;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LikeMapper {
    LikeMapper INSTANCE = Mappers.getMapper(LikeMapper.class);

    @Mappings({
            @Mapping(source = "userId", target = "user.id"),
            @Mapping(source = "productId", target = "product.id")
    })
    Like toLike(final LikeCreateRequestDto dto);

    LikeResponseDto toLikeResponseDto(final LikeCreateRequestDto dto);
}
