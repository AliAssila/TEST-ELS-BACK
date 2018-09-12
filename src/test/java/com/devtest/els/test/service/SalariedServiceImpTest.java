package com.devtest.els.test.service;

import com.devtest.els.test.domain.Salaried;
import com.devtest.els.test.repository.SalariedRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

/**
 * Test class for the SalariedService service.
 *
 * @see SalariedServiceImpTest
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
    public void testCreateManySalaried() {
        // create entity
        List<Salaried> salariedList = createEntitys();
        // when
        when(salariedRepository.save(salariedList)).thenReturn(salariedList);
        List<Salaried> listSalariedRerieved = salariedServiceImp.createManySalaried(salariedList);
        assertEquals(salariedList,listSalariedRerieved);
    }
    @Test
    public void testGetAllSalariedsNoDuplicateByCreteria() {
        // create entity
        List<Salaried> salariedList = createEntitys();
        // when
        when(salariedRepository.save(salariedList)).thenReturn(salariedList);

        List<Salaried> listSalariedRerievedByFullName = salariedServiceImp.getAllSalariedsNoDuplicateByCreteria("fullname");

        assertTrue(listSalariedRerievedByFullName
                .stream().collect(Collectors.groupingBy(Salaried::getFullname)).size() <= 1);

        List<Salaried> listSalariedRerievedByCategory = salariedServiceImp.getAllSalariedsNoDuplicateByCreteria("category");

        assertTrue(listSalariedRerievedByCategory
                .stream().collect(Collectors.groupingBy(Salaried::getCategory)).size() <= 1);

        List<Salaried> listSalariedRerievedByAddress = salariedServiceImp.getAllSalariedsNoDuplicateByCreteria("address");

        assertTrue(listSalariedRerievedByAddress
                .stream().collect(Collectors.groupingBy(Salaried::getAddress)).size() <= 1);

        List<Salaried> listSalariedRerievedByDescription = salariedServiceImp.getAllSalariedsNoDuplicateByCreteria("description");

        assertTrue(listSalariedRerievedByAddress
                .stream().collect(Collectors.groupingBy(Salaried::getDescription)).size() <= 1);

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
        salaried2.setCategory("scrum master");
        salaried2.setCategory("management");
        Salaried salaried3 = new Salaried();
        salaried3.setId("3");
        salaried3.setFullname("smith");
        salaried3.setAddress("paris");
        salaried3.setCategory("scrum master");
        salaried3.setCategory("management");
        List<Salaried> salariedList = new LinkedList<>();
        salariedList.add(salaried1);
        salariedList.add(salaried2);
        salariedList.add(salaried3);
        return salariedList;
    }
}
