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
public class Entry {
private List<Entry> enteries = new ArrayList<>();
    //Employer Data
    private int employeeID;
    private String firstName;
    private String lastName;
    private String emailAdress;
    private String postion;

    //Pojects Data
    private int projectID;
    private String ordernumber;
    private String projectName;
    private String description;

    //TimeRecording Data
    private int timeRecording_ID;
    private int employee_ID;
    private int project_ID;
    private String startTime;
    private String endTime;
    private String comment;

    //Constructor of Employees
    Entry(int employeeID, String firstName, String lastName, String emailAdress, String postion) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAdress = emailAdress;
        this.postion = postion;
    }

    //Constructor of Projects
    Entry(int projectID, String ordernumber, String projectName, String description) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.description = description;

    }

    //Constructor of TimeRecords
    Entry(int timeRecording_ID, int employee_ID, int project_ID, String startTime, String endTime, String comment) {
        this.timeRecording_ID = timeRecording_ID;
        this.employee_ID = employee_ID;
        this.project_ID = project_ID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.comment = comment;

    }

    Entry() {

    }
    
   
    /**
     * @return the employeeID
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * @param employeeID the employeeID to set
     */
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the emailAdress
     */
    public String getEmailAdress() {
        return emailAdress;
    }

    /**
     * @param emailAdress the emailAdress to set
     */
    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    /**
     * @return the postion
     */
    public String getPostion() {
        return postion;
    }

    /**
     * @param postion the postion to set
     */
    public void setPostion(String postion) {
        this.postion = postion;
    }

    /**
     * @return the projectID
     */
    public int getProjectID() {
        return projectID;
    }

    /**
     * @param projectID the projectID to set
     */
    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    /**
     * @return the ordernumber
     */
    public String getOrdernumber() {
        return ordernumber;
    }

    /**
     * @param ordernumber the ordernumber to set
     */
    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }

    /**
     * @return the projectName
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * @param projectName the projectName to set
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the timeRecording_ID
     */
    public int getTimeRecording_ID() {
        return timeRecording_ID;
    }

    /**
     * @param timeRecording_ID the timeRecording_ID to set
     */
    public void setTimeRecording_ID(int timeRecording_ID) {
        this.timeRecording_ID = timeRecording_ID;
    }

    /**
     * @return the employee_ID
     */
    public int getEmployee_ID() {
        return employee_ID;
    }

    /**
     * @param employee_ID the employee_ID to set
     */
    public void setEmployee_ID(int employee_ID) {
        this.employee_ID = employee_ID;
    }

    /**
     * @return the project_ID
     */
    public int getProject_ID() {
        return project_ID;
    }

    /**
     * @param project_ID the project_ID to set
     */
    public void setProject_ID(int project_ID) {
        this.project_ID = project_ID;
    }

    /**
     * @return the startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the endTime
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

}
