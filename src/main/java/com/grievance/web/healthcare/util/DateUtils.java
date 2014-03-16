/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grievance.web.healthcare.util;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.text.ParseException;

/**
 *
 * @author sabbani
 */
public class DateUtils {

    public static Date convertStringToData(String dateStr){
        Date sqlDate = null;
        java.util.Date date = null;
        try{
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd/mm/yyyy");
            date = sdf1.parse(dateStr);
            sqlDate = new Date(date.getTime());
        }catch(ParseException ex){
            ex.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return sqlDate;
    }
    public static java.sql.Timestamp convertStringToTimestamp(String dateStr){
        java.sql.Timestamp  sqlDate = null;
        java.util.Date date = null;
        try{
            SimpleDateFormat sdf1 = new SimpleDateFormat("mm/dd/yyyy");
            date = sdf1.parse(dateStr);
             sqlDate = new java.sql.Timestamp(date.getTime());
//            java.sql.Timestamp ts2 = java.sql.Timestamp.valueOf("2005-04-06 09:01:10");
//            java.util.Calendar calendar = java.util.Calendar.getInstance();
//            calendar.set(date.getYear()+1900, date.getMonth(), date.getDate(), date.getHours(), date.getMinutes(), date.getSeconds());
//            java.util.Date myDate = calendar.getTime();
//            sqlDate = new java.sql.Timestamp(myDate.getTime());
            System.out.println("today date: ="+sqlDate);
        }catch(ParseException ex){
            ex.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return sqlDate;
    }


}
