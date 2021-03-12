package com.cha.wenance.controller;
import com.cha.wenance.entity.BitcoinEntity;
import com.cha.wenance.gethttprequest.GetHttpDataRequest;
import com.cha.wenance.model.Bitcoin;
import com.cha.wenance.model.BitcoinConvert;
import com.cha.wenance.service.BitCoinServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = BitcoinController.class)
class BitcoinControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BitCoinServiceImpl bitCoinService;
    @Autowired
    private ObjectMapper objectMapper;

    private List<BitcoinEntity> bitcoinEntityList;
    @BeforeEach
    void setUp() {
        Bitcoin bitcoinEntity = new Bitcoin(1L,45000,"BTC","UDS");
    }

    @Test
    @Scheduled(fixedRate = 10000)
    void saveBitcoin_iscreated_ok() throws Exception {
        given(bitCoinService.save()).willAnswer((invocation)->invocation.getArguments());

        this.mockMvc.perform(post("/v1/bitpost")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bitCoinService.findBy(1L))))
                .andExpect(status().isCreated());
    }

    @Test
    void findAll() {
    }

    @Test
    void getAverageBitcoins() {
    }

    @Test
    void getVarPorcBitcoins() {
    }
}