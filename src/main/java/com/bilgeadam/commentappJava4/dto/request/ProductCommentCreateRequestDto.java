package com.bilgeadam.commentappJava4.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCommentCreateRequestDto {

    private String comment;
    private Long productId;
    private Long userId;
}
