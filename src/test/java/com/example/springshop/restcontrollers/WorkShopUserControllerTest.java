package com.example.springshop.restcontrollers;

import com.example.springshop.services.DefaultWorkshopUserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/testdata.sql")
class WorkShopUserControllerTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Mock
    private DefaultWorkshopUserService workshopUserService;
    private final MockMvc mvc;
    WorkShopUserControllerTest(DefaultWorkshopUserService workshopUserService, MockMvc mvc) {
        this.workshopUserService = workshopUserService;
        this.mvc = mvc;
    }

    @Test
    void  unknownUserGivesStatusNotFound() throws Exception{
        mvc.perform(get("/WorkshopUser/{id}",-1))
                .andExpect(status().isNotFound());
    }



}