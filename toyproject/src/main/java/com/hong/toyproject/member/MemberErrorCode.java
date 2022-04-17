package com.hong.toyproject.member;

import com.hong.toyproject.ErrorCode;

public enum MemberErrorCode implements ErrorCode {
    INVALID_PARAMETER(400, null, "Invalid Request Data"),
    MEMBER_NOT_FOUND(404, "C002", "Member Not Found");

    private final String code;
    private final String message;
    private final int status;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    MemberErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }
}
