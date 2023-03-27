package com.demo.web;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import com.demo.exception.RecordNotFoundException;
import com.demo.model.EmployeeEntity;
import com.demo.service.EmployeeService;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {EmployeeController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeControllerTest {
    @Autowired
    private EmployeeController employeeController;

    @MockBean
    private EmployeeService employeeService;

    /**
     * Method under test: {@link EmployeeController#getEmployeeById(Long)}
     */
    @Test
    public void testGetEmployeeById() throws Exception {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmail("jane.doe@example.org");
        employeeEntity.setFirstName("Jane");
        employeeEntity.setId(1L);
        employeeEntity.setLastName("Doe");
        when(employeeService.getEmployeeById((Long) any())).thenReturn(employeeEntity);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employees/{id}", 1L);
        MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":1,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"email\":\"jane.doe@example.org\"}"));
    }

    /**
     * Method under test: {@link EmployeeController#getEmployeeById(Long)}
     */
    @Test
    public void testGetEmployeeById2() throws Exception {
        when(employeeService.getEmployeeById((Long) any())).thenThrow(new RecordNotFoundException("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employees/{id}", 1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link EmployeeController#createOrUpdateEmployee(EmployeeEntity)}
     */
    @Test
    public void testCreateOrUpdateEmployee() throws Exception {
        when(employeeService.getAllEmployees()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employees");
        MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link EmployeeController#deleteEmployeeById(Long)}
     */
    @Test
    public void testDeleteEmployeeById() throws Exception {
        doNothing().when(employeeService).deleteEmployeeById((Long) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/employees/{id}", 1L);
        MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("\"FORBIDDEN\""));
    }

    /**
     * Method under test: {@link EmployeeController#deleteEmployeeById(Long)}
     */
    @Test
    public void testDeleteEmployeeById2() throws Exception {
        doThrow(new RecordNotFoundException("An error occurred")).when(employeeService).deleteEmployeeById((Long) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/employees/{id}", 1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link EmployeeController#deleteEmployeeById(Long)}
     */
    @Test
    public void testDeleteEmployeeById3() throws Exception {
        doNothing().when(employeeService).deleteEmployeeById((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/employees/{id}", 1L);
        deleteResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("\"FORBIDDEN\""));
    }

    /**
     * Method under test: {@link EmployeeController#createOrUpdateEmployee(EmployeeEntity)}
     */
    @Test
    public void testCreateOrUpdateEmployee2() throws Exception {
        when(employeeService.getAllEmployees()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/employees");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

