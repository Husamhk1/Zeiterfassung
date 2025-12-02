/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Timesheet.EmployeeRegister;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author husam.qasem
 */
public class TestEntry {

    private static Entry ent = new Entry();
    private static DatabankConnection conn = new DatabankConnection();

    public void testEntryElements(String tableName) throws IOException, SQLException {
        List<Entry> entEle = new ArrayList<Entry>();
        float workT = 0.0f;

        //EmployeesEntery 
        if (tableName.equalsIgnoreCase("employees")) {
            Entry testData = new Entry(0, "firstName", "lastName", "emailadress", "postion");
            testData.setFirstName("MusterVorname");
            testData.setLastName("MusterNachname");
            testData.setEmailAdress("MusterVorname.MusterNachname@Tradui.de");
            testData.setPostion("Consultant");
            entEle.add(testData);
        } else if (tableName.equalsIgnoreCase("projects")) {
            Entry testData = new Entry(0, "projectNumber", "projectName", "description");
            testData.setProjectNumber("SDLZ1265656");
            testData.setProjectName("TAN");
            testData.setDescription("test");
            entEle.add(testData);
        } else if (tableName.equalsIgnoreCase("timeRecording")) {
            Entry testData = new Entry(0, 0, 0, "startTime", "endTime", 0.f, "comment");
            testData.setEmployee_ID(1);
            testData.setProject_ID(5);
            testData.setStartTime("8:0");
            testData.setEndTime("17:00");
            testData.setRestTime(1.0f);
            testData.setComment("testcomment");
            testData.setWorkTime();
            entEle.add(testData);

        } else {

            Entry testData = new Entry(0, "firstName", "lastName", "emailAdress", "postion",
                    0, "projectName", "projectNumber", "description", 
                    0, 0, 0, "startTime", "endTime", 0.0f, 0.0f, "comment");
            testData.setFirstName("MusterVorname");
            testData.setLastName("MusterNachname");
            testData.setEmailAdress("MusterVorname.MusterNachname@Tradui.de");
            testData.setPostion("Consultant");
            testData.setProjectNumber("SDLZ000");
            testData.setProjectName("TestPorject");
            testData.setDescription("test");
            testData.setEmployee_ID(1);
            testData.setProject_ID(20);
            testData.setStartTime("8:0");
            testData.setEndTime("17:00");
            testData.setRestTime(1.0f);
            testData.setComment("test1");
            testData.setWorkTime();
            entEle.add(testData);
        }
        conn.addOneRecord(tableName, entEle);
        
        //conn.printTable(tableName, conn.findAllTable(tableName));
        //conn.printTable(tableName, conn.findeById(9, tableName));

    }

}
