/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Timesheet.EmployeeRegister;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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

     // Read all records from my Database Sample :)
      public List<Entry> findAll() throws IOException, SQLException{
        List<Entry> rows = new ArrayList<>();
        String sql = "SELECT employeeID, firstName, lastName, emailAdress, postion FROM Employee";
        try (
               Connection conn = DriverManager.getConnection(url);
               Statement stmt  = conn.createStatement();
               ResultSet rs    = stmt.executeQuery(sql) ){
         System.out.println("Connection to SQLite has been established to the Database:" + url );
            // loop through the result set
            while (rs.next()) {
                rows.add( new Entry(rs.getInt("employeeID"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("emailAdress"),rs.getString("postion")));
         
            }
        } catch (SQLException e) {
            
            System.out.println(e.getMessage() );
        }
    return rows;
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

}
