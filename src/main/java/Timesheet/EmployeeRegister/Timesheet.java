/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Timesheet.EmployeeRegister;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import java.time.LocalDate;
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
    public static void main(String[] args) throws SQLException, IOException {

        
        LOGGER.info("Willcoome to the Timesheet");
        conn.connectUrl();
        test.testEntryElements("projects");
        //conn.printTable("timeRecording");
     
        
        
        
    }
}
