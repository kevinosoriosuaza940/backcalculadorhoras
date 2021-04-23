package com.app.backIas.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ControlDate {
    public Date formatDate(String date) throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-M-dd HH:mm");
        parser.setTimeZone(TimeZone.getTimeZone("UTC"));
        return parser.parse(date);
    }
}
