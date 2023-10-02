package com.mypay.banking.adapter.in.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mypay.banking.domain.FirmBankingRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class FirmBankAccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    @DisplayName("은행 계좌 간 송금 요청.")
    void registerFirmBankingAmount() throws Exception {
        FirmBankAccountRequest 요청객체 = new FirmBankAccountRequest("카카오뱅크", "1234-3233-4443-2344", "네이버뱅크", "1234-1234-1234-1234", 10000);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/banking/firmbanking/request")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(요청객체))
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

}