package com.dailyCode.Dream_shop.exceptions;

import org.springframework.http.HttpStatus;

public record EntityException(String message, Throwable throwable, HttpStatus httpStatus) {
}
