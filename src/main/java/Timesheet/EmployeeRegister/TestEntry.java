/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Timesheet.EmployeeRegister;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author husam.qasem
 */
public class TestEntry {

    private static Entry ent = new Entry();
    private static DatabankConnection data = new DatabankConnection();

    public void testEntryElements(String tableName) {
        List<Entry> entEle = new ArrayList<>();
        //EmployeesEntery 
        if (tableName.equalsIgnoreCase("employees")) {
            Entry testData = new Entry("firstName", "lastName", "emailadress", "postion");
            testData.setFirstName("Farzam");
            testData.setLastName("Karimi");
            testData.setEmailAdress("Farzam.Karimi@Tradui.de");
            testData.setPostion("Consultant");
            entEle.add(testData);
        } else if (tableName.equalsIgnoreCase("projects")) {
            Entry testData = new Entry("projectNumber", "projectName", "description");
            testData.setProjectNumber("SDLZ12656");
            testData.setProjectName("Radolfzell");
            testData.setDescription("test");
            entEle.add(testData);
        } else {
            Entry testData = new Entry(0,0,"startTime","endTime",0.f,"comment");
            testData.setEmployee_ID(13212);
            testData.setProject_ID(54646);
            testData.setStartTime("9:0");
            testData.setEndTime("18:00");
            testData.setRestTime(2.0f);
            testData.setComment("testcomment");            
                    
            entEle.add(testData);
        }

        

        //data.addOneRecord(tableName, entEle);
       ent.setWorkTime(entEle.get(0).getStartTime(), entEle.get(0).getEndTime(),entEle.get(0).getRestTime());
        
    }

}
