package com.example.testfinerio.utils;

import java.text.ParseException;

public class Utils {

    public String dateFormat(String lastDate) throws ParseException {
        String date[] = lastDate.split("T");
        return date[0];
    }
}
