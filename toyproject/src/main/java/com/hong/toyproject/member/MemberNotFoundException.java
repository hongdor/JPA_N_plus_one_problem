package com.hong.toyproject.member;

import com.hong.toyproject.CustomException;

public class MemberNotFoundException extends CustomException {
    MemberNotFoundException(){
        super(MemberErrorCode.MEMBER_NOT_FOUND);
    }
}
