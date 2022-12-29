package com.bilgeadam.commentappJava4.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorType {

    USER_NOT_FOUND(1000, "Aramakta oldugunuz kullanıcı sistemde kayıtlı değildir", HttpStatus.INTERNAL_SERVER_ERROR),
    VALUE_NOT_FOUND_IN_NAMES(1001, "Aramakta oldugunuz veri kullanıcı isimlerinde bulunmamaktadır", HttpStatus.INTERNAL_SERVER_ERROR),
    VALUE_NOT_FOUND_IN_EMAILS(1002, "Aramakta oldugunuz veri kullanıcı emaillerinde bulunmamaktadır", HttpStatus.INTERNAL_SERVER_ERROR);
    private int code;
    private String message;
    HttpStatus httpStatus;


}
