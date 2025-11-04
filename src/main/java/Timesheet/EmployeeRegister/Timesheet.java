/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Timesheet.EmployeeRegister;

import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author husam.qasem
 */
public class Timesheet {

    private static final Logger LOGGER = LoggerFactory.getLogger(Timesheet.class);
    private static final DatabankConnection conn = new DatabankConnection();

    public static void main(String[] args) {

        System.out.println("Timesheet");       
        conn.connectUrl();
    }
}
