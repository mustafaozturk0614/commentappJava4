package com.bilgeadam.commentappJava4.mapper;

import com.bilgeadam.commentappJava4.dto.request.ProductCreateRequestDto;
import com.bilgeadam.commentappJava4.dto.response.ProductCreateResponseDto;
import com.bilgeadam.commentappJava4.repository.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductCreateResponseDto toProductCreateResponseDto(final Product product);

    Product toProduct(final ProductCreateRequestDto requestDto);

}
