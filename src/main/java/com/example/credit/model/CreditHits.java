package com.example.credit.model;

import java.util.HashMap;

public class CreditHits {

    private static CreditHits creditHits=null;

    static int size=0;


    private CreditHits()
    {

    }

    public static CreditHits getInstance()
    {
        if(creditHits!=null)
            return  creditHits;
        else
        return new CreditHits();
    }

    public static int getSize() {
        return size;
    }

    public static void setSize(int size) {
        CreditHits.size = size;
    }

    public void counter()
    {
        size++;
    }

}
