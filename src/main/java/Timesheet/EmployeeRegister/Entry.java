/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Timesheet.EmployeeRegister;

/**
 *
 * @author husam.qasem
 */
public class Entry {
    //Employer Data
    private int employeeID;
    private String firstName;
    private String lastName;
    private String emailAdress;
    private String postion;
    
    //Pojects Data
    private int projectID;
    private String ordernumber;
    private String ProjectName;
    private String Description;
    
    //TimeRecording Data
    private int TimeRecording_ID;
    private int Employee_ID;
    private int Project_ID;
    private String StartTime;
    private String EndTime;
    private String Comment;
    
    
    
    
    
    Entry(int employeeID, String firstName, String lastName, String emailAdress, String postion) {

        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAdress = emailAdress;
        this.postion = postion;
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
     * @return the ProjectName
     */
    public String getProjectName() {
        return ProjectName;
    }

    /**
     * @param ProjectName the ProjectName to set
     */
    public void setProjectName(String ProjectName) {
        this.ProjectName = ProjectName;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * @return the TimeRecording_ID
     */
    public int getTimeRecording_ID() {
        return TimeRecording_ID;
    }

    /**
     * @param TimeRecording_ID the TimeRecording_ID to set
     */
    public void setTimeRecording_ID(int TimeRecording_ID) {
        this.TimeRecording_ID = TimeRecording_ID;
    }

    /**
     * @return the Employee_ID
     */
    public int getEmployee_ID() {
        return Employee_ID;
    }

    /**
     * @param Employee_ID the Employee_ID to set
     */
    public void setEmployee_ID(int Employee_ID) {
        this.Employee_ID = Employee_ID;
    }

    /**
     * @return the Project_ID
     */
    public int getProject_ID() {
        return Project_ID;
    }

    /**
     * @param Project_ID the Project_ID to set
     */
    public void setProject_ID(int Project_ID) {
        this.Project_ID = Project_ID;
    }

    /**
     * @return the StartTime
     */
    public String getStartTime() {
        return StartTime;
    }

    /**
     * @param StartTime the StartTime to set
     */
    public void setStartTime(String StartTime) {
        this.StartTime = StartTime;
    }

    /**
     * @return the EndTime
     */
    public String getEndTime() {
        return EndTime;
    }

    /**
     * @param EndTime the EndTime to set
     */
    public void setEndTime(String EndTime) {
        this.EndTime = EndTime;
    }

    /**
     * @return the Comment
     */
    public String getComment() {
        return Comment;
    }

    /**
     * @param Comment the Comment to set
     */
    public void setComment(String Comment) {
        this.Comment = Comment;
    }

}
