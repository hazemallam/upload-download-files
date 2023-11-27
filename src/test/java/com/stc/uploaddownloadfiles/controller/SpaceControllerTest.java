package com.stc.uploaddownloadfiles.controller;

import com.stc.uploaddownloadfiles.exceptions.GlobalExceptionHandler;
import com.stc.uploaddownloadfiles.model.Response;
import com.stc.uploaddownloadfiles.model.dto.ItemResponseDto;
import com.stc.uploaddownloadfiles.model.enums.ResponseStatus;
import com.stc.uploaddownloadfiles.service.SpaceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.net.http.HttpHeaders;
import java.security.Principal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class SpaceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GlobalExceptionHandler exceptionHandler;

    @Mock
    private SpaceService spaceService;

    @InjectMocks
    private SpaceController spaceController;

    @Value("${server.servlet.context-path}")
    private String contextPath;


    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(spaceController)
                .setControllerAdvice(exceptionHandler)
                .build();
    }

    @Test
    public void should_create_space_successfully() throws Exception {
        String body = "{\"name\":\"stc-assessment\",\"permissionGroup\":1,\"path\":\"path\"}";
        Mockito.when(spaceService.createSpace(Mockito.any())).thenReturn(new ItemResponseDto("stc-assessment", 1L));
        MvcResult mvcResult = this.mockMvc.perform(
                        MockMvcRequestBuilders.post(contextPath + "/space/create")
                                .header("Content-Type", MediaType.APPLICATION_JSON)
                                .content(body)

                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }





}