/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Timesheet.EmployeeRegister;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author husam.qasem
 */
public class Timesheet {

   
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Timesheet.class);
    private static final DatabankConnection conn = new DatabankConnection();
  

    public static void main(String[] args) throws SQLException, IOException {

        System.out.println("Willcoome to the Timesheet");       
        conn.connectUrl();
        conn.findAllInTablle("")//.forEach(System.out::println);
                .forEach(a -> System.out.println(a.getFirstName()+ "\t"+a.getStartTime()+"\t"+a.getProjectID()+ "\t"+a.getProjectName()+ "\t" + a.getOrdernumber()+ "\t"+a.getDescription()));
           
        
        
        
    }
}
