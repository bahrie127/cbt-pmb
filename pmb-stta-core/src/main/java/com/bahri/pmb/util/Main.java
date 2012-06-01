package com.bahri.pmb.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 3/27/12
 * Time: 12:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        String date="13-23-2012";
        String date2="3243232";

//        if(date.matches("\\d{1,2}[-/]\\d{1,2}[-/]\\d{4}")){
//            System.out.println("benar");
//        }   else {
//            System.out.println("salah");
//        }

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        format.parse(date);
    }
//    boolean isValidDate(String input)
//    {
//        try{ format.parse(input);return true;}
//        catch(Exception e){ return false; }
//    }



}
