package com.employee.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.employee.test.controller.EmployeeController;
import com.employee.test.entity.EmployeeEntity;
import com.employee.test.service.EmployeeService;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
    
    @MockBean
    EmployeeService employeeService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getEmployeeDetailsTest() throws Exception{
        EmployeeEntity entity = new EmployeeEntity();
        entity.setId(new Long(1));
        entity.setName("Allan");
        entity.setDesignation("Lead");
        Optional<EmployeeEntity> optional = Optional.of(entity);
        Mockito.when(employeeService.gEmployeeDetail(Mockito.anyLong())).thenReturn(optional);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employee/1").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());
        String expectedStr = "{'id': 1,'name': 'Allan','designation': 'Lead'}";
        JSONAssert.assertEquals(expectedStr, mvcResult.getResponse().getContentAsString(), false);
    }
}
