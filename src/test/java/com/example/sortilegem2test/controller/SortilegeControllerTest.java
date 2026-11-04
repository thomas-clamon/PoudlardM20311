package com.example.sortilegem2test.controller;

import com.example.sortilegem2test.dto.SortilegeDto;
import com.example.sortilegem2test.services.SorcierService;
import com.example.sortilegem2test.services.SortilegeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SortilegeController.class)
class SortilegeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockitoBean
    SorcierService sorcierService;

    @MockitoBean
    SortilegeService sortilegeService;


    @Test
    void should400_when_name_upper_to_30() throws Exception {
        // Arrange
        // on prepare un dto qui depasse 30 carathere sur le nom
        SortilegeDto dto = new SortilegeDto();
        dto.setNom("toto".repeat(70));
        // access on appelle notre endponit
        mockMvc.perform(post("/Sortilege/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().is(400));
    }
    @Test
    void should400_when_bad_sorcier() throws Exception {
        SortilegeDto dto = new SortilegeDto();
        dto.setNom("Reparo");
        dto.setType_sort("BLANCHE");

        Integer ID = 32;
        dto.setId_sorcier(ID);

        Mockito.when(sorcierService.exist(ID)).thenReturn(false);
        mockMvc.perform(post("/Sortilege/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().is(400));
    }

}