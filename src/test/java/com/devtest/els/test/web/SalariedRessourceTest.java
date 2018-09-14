package com.devtest.els.test.web;

import com.devtest.els.test.domain.Salaried;
import com.devtest.els.test.service.SalariedServiceImp;
import com.devtest.els.test.service.SalariedServiceImpTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;




import java.util.List;


import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test class for the Rest Controller  SalariedRessource.
 *
 * @see SalariedRessourceTest
 */
@RunWith(MockitoJUnitRunner.class)
public class SalariedRessourceTest {
    @Mock
    private SalariedServiceImp salariedServiceMock;

    @InjectMocks
    private SalariedRessource salariedRessource;

    private MockMvc restSalariedMockMvc;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(salariedRessource);
        this.restSalariedMockMvc = MockMvcBuilders.standaloneSetup(salariedRessource).build();
    }

    @Test
    public void testCreateSalaried() throws Exception {
        /* create entity */
        List<Salaried> salariedList = SalariedServiceImpTest.createEntitys();
        /* when */
        when(salariedServiceMock.createManySalaried(salariedList)).thenReturn(salariedList);
        /* then */
        restSalariedMockMvc.perform(post("/api/salaried")
                .contentType("application/json;charset=UTF-8")
                .content(asJsonString(salariedList)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", is("1")))
                .andExpect(jsonPath("$[0].fullname", is("john")));

        verify(salariedServiceMock, times(1)).createManySalaried(anyList());
        verifyNoMoreInteractions(salariedServiceMock);
    }
    @Test
    public void testGetAllSalriedNoDuplicate() throws Exception {
        /* create entity */
        List<Salaried> salariedList = SalariedServiceImpTest.createEntitys();
        /* when */
        when(salariedServiceMock.getAllSalariedsNoDuplicateByCreteria("fullname")).thenReturn(salariedList.subList(1,2));
        /* then */
        restSalariedMockMvc.perform(get("/api/salaried/fullname"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

        verify(salariedServiceMock, times(1)).getAllSalariedsNoDuplicateByCreteria("fullname");
        verifyNoMoreInteractions(salariedServiceMock);
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
