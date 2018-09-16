package com.devtest.els.test.service.util;

import com.devtest.els.test.domain.Salaried;
import com.devtest.els.test.service.utils.SalariedUtils;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

/**
 * Class Test
 * @see SalariedUtils
 */
public class SalariedUtilsTest {
    private static final String DEFAULT_ID = "1";
    private static final String DEFAULT_FULLNAME = "jhon";
    private static final String DEFAULT_CATEGORY = "webdev";
    private static final String DEFAULT_ADDRESS = "paris";
    private static final String DEFAULT_DESCRIPTION = "web";

    @Test
    public void testGetValueByCreteria() {
     Salaried salaried = new Salaried();
     salaried.setId(DEFAULT_ID);
     salaried.setFullname(DEFAULT_FULLNAME);
     salaried.setAddress(DEFAULT_ADDRESS);
     salaried.setCategory(DEFAULT_CATEGORY);
     salaried.setDescription(DEFAULT_DESCRIPTION);
     String creteria = "fullname";
     String result = SalariedUtils.getValueByCreteria(salaried,creteria);
     assertEquals("jhon",result);
    }

}
