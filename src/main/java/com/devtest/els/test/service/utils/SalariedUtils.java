package com.devtest.els.test.service.utils;

import com.devtest.els.test.domain.Salaried;

/**
 * Utility class for salaried Management.
 */
public final class SalariedUtils {

    private SalariedUtils(){
        // no instances
        // class is final and the constructor is private
    }
    /**
     * getValueByCreteria
     * @param salaried (Salried)
     * @param creteria (String) : key filter
     * @return value of property creteria
     */
    public static String getValueByCreteria(Salaried salaried, String creteria){
        switch (creteria){
            case "fullname":
                return salaried.getFullname();
            case "category":
                return  salaried.getCategory();
            case "description":
                return  salaried.getDescription();
            case "address":
                return  salaried.getAddress();
            default: return  "";
        }
    }
}
