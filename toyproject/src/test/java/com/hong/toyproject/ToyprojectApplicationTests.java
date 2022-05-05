package com.hong.toyproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hong.toyproject.member.MemberController;
import com.hong.toyproject.member.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;


@AutoConfigureMockMvc
//@ContextConfiguration
@SpringBootTest
@ExtendWith(SpringExtension.class)
//@WebMvcTest(MemberController.class)
public class ToyprojectApplicationTests {

	@Autowired
	protected MockMvc mockMvc;

	@Autowired
	protected ObjectMapper objectMapper;

}
