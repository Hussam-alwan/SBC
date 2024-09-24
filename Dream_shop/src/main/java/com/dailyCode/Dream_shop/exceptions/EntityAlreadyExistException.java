package com.dailyCode.Dream_shop.exceptions;

import org.springframework.http.HttpStatus;

public record EntityAlreadyExistException(String message,Throwable throwable,HttpStatus httpStatus) {
}
