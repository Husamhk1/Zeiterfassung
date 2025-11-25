/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Timesheet.EmployeeRegister;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author husam.qasem
 */
public class Timesheet {

   
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Timesheet.class);
    private static final DatabankConnection conn = new DatabankConnection();
    private static final TestEntry test = new TestEntry();
    private static final Entry enter = new Entry();
    public static void main(String[] args) throws SQLException, IOException {

        String TableName = "employees";
        String time = "10:15";
        LOGGER.info("Willcoome to the Timesheet");
        
        conn.connectUrl();
        //test.testEntryElements(TableName);
        //conn.printTable(TableName);
     
        
        
        System.out.println(enter.convertFSTDec(time));
        System.out.println(enter.convertTheInputTimeToLocalTime(time));
        test.testEntryElements("");
        System.out.println(conn.findeById(1, TableName));
        
    }
}
