package com.devtest.els.test.service.utils;

import com.devtest.els.test.domain.Salaried;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Utils {

    public static String creteriaMethode(Salaried salaried, String creteria){
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
