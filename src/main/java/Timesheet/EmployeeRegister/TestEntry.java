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
    public void testEntryElements() {
        List<Entry> entEle = new ArrayList<>();

        Entry testData = new Entry("firstName", "lastName", "emailadress", "postion");
        testData.setFirstName("Ahmad");
        testData.setLastName("Hedili");
        testData.setEmailAdress("Ahmad.Hedili@Tradui.de");
        testData.setPostion("Consultant");
        entEle.add(testData);
        
        data.addOneRecord("employees", entEle);
    }

}
