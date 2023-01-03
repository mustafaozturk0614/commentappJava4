package com.bilgeadam.commentappJava4.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorType {


    BAD_REQUEST_ERROR(5000, "Hatalı Parametre", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(1000, "Aramakta oldugunuz kullanıcı sistemde kayıtlı değildir", HttpStatus.INTERNAL_SERVER_ERROR),
    USER_NOT_CREATED(1003, "kULLANICI OLUŞTURULAMDI", HttpStatus.INTERNAL_SERVER_ERROR),
    VALUE_NOT_FOUND_IN_NAMES(1001, "Aramakta oldugunuz veri kullanıcı isimlerinde bulunmamaktadır", HttpStatus.INTERNAL_SERVER_ERROR),
    VALUE_NOT_FOUND_IN_EMAILS(1002, "Aramakta oldugunuz veri kullanıcı emaillerinde bulunmamaktadır", HttpStatus.INTERNAL_SERVER_ERROR),

    PRODUCT_NOT_FOUND(2000, "Aramakta oldugunuz ürün sistemde kayıtlı değildir", HttpStatus.INTERNAL_SERVER_ERROR),
    PRODUCT_ALREADY_EXISTS_IN_FAVOURITE_LIST(2001, "Ürün zaten favori listesinde var", HttpStatus.INTERNAL_SERVER_ERROR),

    PRODUCT_NOT_CREATED(2003, "ÜRÜN OLUŞTURULAMDI", HttpStatus.INTERNAL_SERVER_ERROR),

    PRODUCTCOMMENT_NOT_FOUND(3000, "Aramakta oldugunuz yorum sistemde kayıtlı değildir", HttpStatus.INTERNAL_SERVER_ERROR),
    PRODUCTCOMMENT_NOT_CREATED(3003, "YORUM OLUŞTURULAMDI", HttpStatus.INTERNAL_SERVER_ERROR),

    LIKE_NOT_CREATED(4003, "LIKE OLUŞTURULAMDI", HttpStatus.INTERNAL_SERVER_ERROR),
    LIKE_ALREADY_EXIST(4004, "LIKE Daha Once Oluşturulmuştur", HttpStatus.INTERNAL_SERVER_ERROR);


    private int code;
    private String message;
    HttpStatus httpStatus;


}
