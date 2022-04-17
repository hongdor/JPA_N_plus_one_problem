package com.hong.toyproject.member;

import com.hong.toyproject.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class MemberExceptionAdvice {

    private final Logger logger = LoggerFactory.getLogger(MemberExceptionAdvice.class);

    @ExceptionHandler(MemberNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorResponse MemberNotFoundHandler(MemberNotFoundException ex){
        logger.error("MemberNotFoundException", ex);
        return new ErrorResponse(ex);
    }
}
