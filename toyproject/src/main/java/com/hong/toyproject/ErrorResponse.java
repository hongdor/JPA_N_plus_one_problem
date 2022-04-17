package com.hong.toyproject;


import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ErrorResponse {

    private String message;
    private Integer status;
    private String code;
    private LocalDateTime time;

    public ErrorResponse(CustomException ex){
        this.message = ex.getErrorCode().getMessage();
        this.status = ex.getErrorCode().getStatus();
        this.code = ex.getErrorCode().getCode();
        this.time = LocalDateTime.now();
    }
}
