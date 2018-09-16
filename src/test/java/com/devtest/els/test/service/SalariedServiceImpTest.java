package com.devtest.els.test.service;

import com.devtest.els.test.domain.Salaried;
import com.devtest.els.test.repository.SalariedRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

/**
 * Test class for the SalariedService service.
 *
 * @see SalariedServiceImp
 */
@RunWith(MockitoJUnitRunner.class)
public class SalariedServiceImpTest {
    @Mock
    private SalariedRepository salariedRepository;

    @InjectMocks
    private SalariedServiceImp salariedServiceImp;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(salariedServiceImp);
    }

    @Test
    public void testGetAllSalarieds() {
        /* create entity */
        List<Salaried> salariedList = createEntitys();
        /* when */
        when(salariedRepository.findAll()).thenReturn(salariedList);
        List<Salaried> listSalariedRerieved = salariedServiceImp.getAllSalarieds();
        /* assert */
        assertEquals(salariedList,listSalariedRerieved);
    }
    @Test
    public void testCreateManySalaried() {
        /* create entity */
        List<Salaried> salariedList = createEntitys();
        /* when */
        when(salariedRepository.saveAll(salariedList)).thenReturn(salariedList);
        List<Salaried> listSalariedRerieved = salariedServiceImp.createManySalaried(salariedList);
        /* assert */
        assertEquals(salariedList,listSalariedRerieved);
    }
    @Test
    public void testGetAllSalariedsNoDuplicateByCreteria() {
        // create entity
        List<Salaried> salariedList = createEntitys();
        // when
        when(salariedRepository.findAll()).thenReturn(salariedList);

        List<Salaried> listSalariedRerievedByFullName = salariedServiceImp.getAllSalariedsNoDuplicateByCreteria("fullname");

        assertTrue(listSalariedRerievedByFullName
                .stream().collect(Collectors.groupingBy(Salaried::getFullname)).size() <= 2);
    }
    /**
     * Create a list of salaried.
     *
     * This is a static method, as tests for entity Salaried,
     */
    public static List<Salaried> createEntitys() {
        Salaried salaried1 = new Salaried();
        salaried1.setId("1");
        salaried1.setFullname("john");
        salaried1.setAddress("paris");
        salaried1.setCategory("webDev");
        salaried1.setDescription("web");
        Salaried salaried2 = new Salaried();
        salaried2.setId("2");
        salaried2.setFullname("smith");
        salaried2.setAddress("paris2");
        salaried2.setCategory("scrum master");
        salaried2.setCategory("management");
        Salaried salaried3 = new Salaried();
        salaried3.setId("3");
        salaried3.setFullname("smith");
        salaried3.setAddress("paris");
        salaried3.setCategory("scrum master");
        salaried3.setCategory("management");
        List<Salaried> salariedList = new ArrayList<Salaried>();
        salariedList.add(salaried1);
        salariedList.add(salaried2);
        salariedList.add(salaried3);
        return salariedList;
    }
}
