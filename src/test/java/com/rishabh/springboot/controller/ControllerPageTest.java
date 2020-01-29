package com.rishabh.springboot.controller;

import antlr.build.Tool;
import com.rishabh.springboot.databasecontroller.BranchRepo;
import com.rishabh.springboot.databasecontroller.DataBaseImplementaion;
import com.rishabh.springboot.databasecontroller.DataBaseRepo;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
class ControllerPageTest {

    @InjectMocks
    ControllerPage cp;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();


    @Mock
    private DataBaseRepo dataBaseRepo;

    @Mock
    private BranchRepo branchRepo;



    @Mock
    DataBaseImplementaion dataBase;

    private MockMvc mockMvc;
    @BeforeEach
    void setUp() {
    //    initMocks(this);
//        DataBaseImplementaion dataBase = Mockito.mock(DataBaseImplementaion.class);
//        ControllerPage cp = Mockito.spy(ControllerPage.class);


        initMocks(this);
        ControllerPage controller = new ControllerPage();
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void homePage() {

        String val = cp.homePage();
        assertEquals("index",val);
    }


    @Test
    void login() {

        ModelAndView mv = cp.login("rishabh","rishabh123");
        System.out.println(mv);

    }

    @Test
    void ctc_page() {
    }

    @Test
    void ctc_page1() {
    }

    @Test
    void findUserDetail() {



    }

    @Test
    void newUser() {

        DataBaseImplementaion dataBaseImplementaion = new DataBaseImplementaion("first","first");//whichever data your entity class have

        Mockito.when((Mockito.any(Employee.class))).thenReturn(emp);

        mockMvc.perform(MockMvcRequestBuilders.post("/employees")
                .content(asJsonString(emp))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));


    }

    @Test
    void deleteUser() {



    }

    @Test
    void updateUser() {
    }
}