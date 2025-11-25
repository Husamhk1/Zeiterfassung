/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Timesheet.EmployeeRegister;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author husam.qasem
 */
public class DatabankConnection {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabankConnection.class);
    // specify location of Databank
    File databank = new File("C:\\Users\\husam.qasem\\Documents\\NetBeansProjects\\Zeiterfassung\\databank\\DB_zeiterfassung.db");
    // Then open the friendsdb file with sqllite jdbc driver
    String url = "jdbc:sqlite:" + databank.getAbsolutePath();

    //Driver of Sqlite DataBase 
    String driver = "org.sqlite.JDBC";

    // Read all records of Employees from my Database Sample :)
    public List<Entry> findAllTable(String tableName) throws IOException, SQLException {
        List<Entry> rows = new ArrayList<>();
        String sql = "";

        if ((tableName.equalsIgnoreCase("employees")) || (tableName.equalsIgnoreCase("projects")) || (tableName.equalsIgnoreCase("timeRecording"))) {
            LOGGER.info("The Tablename is entered \t :{} ", tableName);
            sql = "SELECT * FROM " + tableName;
        } else {
            LOGGER.info("The tablename is't correct. Try again! :)");
            sql = "SELECT * FROM employees "
                    + "INNER JOIN projects on ProjectID = project_ID "
                    + "INNER JOIN timeRecording on employeeID = employee_ID";
        }
        try (
                Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            LOGGER.info("The filds of the Table  are \t :{}", tableName);
            // loop through the result set
            while (rs.next()) {
                if (tableName.equalsIgnoreCase("employees")) {

                    rows.add(new Entry(rs.getString("firstName"), rs.getString("lastName"), rs.getString("emailAdress"), rs.getString("postion")));
                } else if (tableName.equalsIgnoreCase("projects")) {

                    rows.add(new Entry(rs.getString("projectNumber"), rs.getString("projectName"), rs.getString("description")));
                } else if (tableName.equalsIgnoreCase("timeRecording")) {

                    rows.add(new Entry(rs.getInt("employee_ID"), rs.getInt("project_ID"), rs.getString("startTime"), rs.getString("endTime"), rs.getFloat("restTime"), rs.getString("comment")));
                } else {
                    LOGGER.info("The all filds of the databank will be printed her!");
                    rows.add(new Entry(rs.getInt("employeeID"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("emailAdress"), rs.getString("postion"),
                            rs.getInt("ProjectID"), rs.getString("projectNumber"), rs.getString("projectName"), rs.getString("description"),
                            rs.getInt("timeRecording_ID"), rs.getInt("employee_ID"), rs.getInt("project_ID"), rs.getString("startTime"), rs.getString("endTime"), rs.getFloat("workTime"), rs.getFloat("restTime"), rs.getString("comment")
                    ));
                }
            }
        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
        return rows;
    }

    public List<Entry> findeById(int id, String tableName) throws IOException, SQLException {
        List<Entry> rows = new ArrayList<>();

        try {
            if (tableName.equalsIgnoreCase("employees")) {

                //rows =  findAllTable(tableName).stream().filter((Entry ent) -> ((ent.getEmployeeID() == id)).collect(Collectors.toList());
                 
            }else if(tableName.equalsIgnoreCase("projects")){
                rows = findAllTable(tableName).stream().filter((Entry ent)->(ent.getProjectID()== id)).collect(Collectors.toList());
                
            }else {
                rows = findAllTable(tableName).stream().filter((Entry ent)->(ent.getTimeRecording_ID() == id)).collect(Collectors.toList());
            }
        } catch (Exception e) {
            LOGGER.info(e.getMessage());

        }

        return rows;
    }

    public void addOneRecord(String tableName, List<Entry> entry) {
        String sql = "";
        //Employees
        String firstName = entry.get(0).getFirstName();
        String lastName = entry.get(0).getLastName();
        String emailAdress = entry.get(0).getEmailAdress();
        String postion = entry.get(0).getPostion();

        //Projects
        String projectNumber = entry.get(0).getProjectNumber();
        String projectName = entry.get(0).getProjectName();
        String description = entry.get(0).getDescription();

        //TimeRecording
        int employee_ID = entry.get(0).getEmployee_ID();
        int project_Id = entry.get(0).getProject_ID();
        String startTime = entry.get(0).getStartTime();
        String endTime = entry.get(0).getEndTime();
        float workTime = entry.get(0).getWorkTime();
        float restTime = entry.get(0).getRestTime();
        String comment = entry.get(0).getComment();

        LOGGER.info("Insert a new Record in the Table of {} \t :", tableName);
        if (tableName.equalsIgnoreCase("employees")) {

            sql = "INSERT INTO employees(firstName,lastName,emailAdress,postion) VALUES(?,?,?,?)";

        } else if (tableName.equalsIgnoreCase("projects")) {

            sql = "INSERT INTO projects(projectNumber,projectName,description) VALUES(?,?,?)";
        } else {

            sql = "Insert INTO timeRecording("
                    + "(SELECT employee_ID FROM employees WHERE  firstName = " + firstName + "AND lastName =" + lastName + "),"
                    + "(SELECT project_ID FROM prjects WHERE projectName = " + projectName + "AND projectNumber =" + projectNumber + "),"
                    + "startTime, endTime, comment, workTime,restTime) VALUES(?,?,?,?,?,?,?)";
        }

        try {
            Connection conn = DriverManager.getConnection(url);
            PreparedStatement pre = conn.prepareStatement(sql);

            if (tableName.equalsIgnoreCase("employees")) {
                pre.setString(1, firstName);
                pre.setString(2, lastName);
                pre.setString(3, emailAdress);
                pre.setString(4, postion);
                LOGGER.info("The Record was added:\t{} {} {} {}", firstName, lastName, emailAdress, postion);
            } else if (tableName.equalsIgnoreCase("projects")) {
                pre.setString(1, projectNumber);
                pre.setString(2, projectName);
                pre.setString(3, description);
                LOGGER.info("The Record was added:\t{} {} {}", projectNumber, projectName, description);
            } else if (tableName.equalsIgnoreCase("timeRecording")) {
                pre.setInt(1, employee_ID);
                pre.setInt(2, project_Id);
                pre.setString(3, startTime);
                pre.setString(4, endTime);
                pre.setFloat(5, workTime);
                pre.setFloat(6, restTime);
                pre.setString(7, comment);

                LOGGER.info("The Record was added:\t{} {} {} {} {} {}", employee_ID, project_Id, startTime, endTime, workTime, restTime, comment);
            } else {
                LOGGER.info("There is an error ....");
            }

            pre.executeUpdate();
            LOGGER.info("The new recorde was added... :)");

        } catch (SQLException e) {

            LOGGER.error(e.getMessage());
        }

    }

    //Connnection to The SQLite Database    
    public Connection connectUrl() {
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            //System.out.println("??? Connection to SQLite has been established to the Database:" + url );
            LOGGER.info("Connection to SQLite is established:{}", url);

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());

        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    LOGGER.info("The Conection is closed");
                }
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
            }
        }
        return conn;
    }

    ;
    
    public void printTable(String tableName) throws SQLException, IOException {

        if (tableName.equalsIgnoreCase("employees")) {
            findAllTable(tableName).forEach(a -> {
                System.out.println(a.getEmployeeID() + "\t" + a.getFirstName() + "\t" + a.getLastName() + "\t" + a.getEmailAdress() + "\t" + a.getPostion());
            });
        } else if (tableName.equalsIgnoreCase("projects")) {
            findAllTable(tableName).forEach(a -> {
                System.out.println(a.getProjectID() + "\t" + a.getProjectNumber() + "\t" + a.getProjectName() + "\t" + a.getDescription());
            });
        } else if ((tableName.equalsIgnoreCase("timeRecording"))) {
            findAllTable(tableName).forEach(a -> {
                System.out.println(a.getTimeRecording_ID() + "\t" + a.getEmployee_ID() + "\t" + a.getProject_ID() + "\t" + a.getStartTime()
                        + "\t" + a.getEndTime() + "\t" + a.getWorkTime() + "\t" + a.getComment());
            });
        } else {
            LOGGER.info("The all filds of the databank will be printed her!");

            findAllTable(tableName).forEach(a -> {
                System.out.println(
                        a.getEmployeeID() + "\t" + a.getFirstName() + "\t" + a.getLastName() + "\t" + a.getEmailAdress() + "\t" + a.getPostion() + "\t"
                        + a.getProjectID() + "\t" + a.getProjectNumber() + "\t" + a.getProjectName() + "\t" + a.getDescription() + "\t"
                        + a.getTimeRecording_ID() + "\t" + a.getEmployee_ID() + "\t" + a.getProject_ID() + "\t" + a.getStartTime()
                        + "\t" + a.getEndTime() + "\t" + a.getWorkTime() + "\t" + a.getRestTime() + "\t" + a.getComment());
            });
        }

    }

}
