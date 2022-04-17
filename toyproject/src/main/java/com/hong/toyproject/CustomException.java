package com.hong.toyproject;

import com.hong.toyproject.member.MemberErrorCode;

public class CustomException extends RuntimeException{

    private ErrorCode errorCode;

    public CustomException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode(){
        return this.errorCode;
    }

}
