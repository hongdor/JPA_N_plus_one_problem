package com.hong.toyproject.member;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hong.toyproject.ToyprojectApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MemberTest extends ToyprojectApplicationTests {


    @Test
    public void memberTest() throws Exception {
        //Given
        String url = "/api/v1/members/1";

        //When
        ResultActions resultActions = this.mockMvc.perform(get(url));

        //Then
        resultActions.andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("memberId").value(1L))
                .andExpect(jsonPath("name").value("test"));
    }
}
