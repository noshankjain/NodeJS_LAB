/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.util.logging.Logger;

public class StudentDAO {
        // Database connection parameters
    private static final String DB_URL = "jdbc:sqlite:D:/SQLite/DBs/Student2DB";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    private static Logger logger;
    
    public StudentDAO(Logger logger)
    {
        this.logger = logger;
    }

    public Student getStudentByRollno(int rollnum) {
        Student student = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Step 1: Establish database connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "");

            // Step 2: Prepare the SQL query
            String sql = "SELECT * FROM students WHERE rollno = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, rollnum);  // Set the rollno in the query
            
            // Step 3: Execute the query
            rs = ps.executeQuery();

            // Step 4: Process the result set
            if (rs.next()) {
                int id = rs.getInt("rollno");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                student = new Student(id, name, age); // Create a student object with fetched data
            }
        } 
        catch (ClassNotFoundException e)
        {
            logger.warning("NRK8: ClassNotFoundException" + e);
        }
        catch (SQLException e) {
            logger.warning("NRK1: exception from JDBC" + e);
        } finally {         
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                logger.warning("NRK2: exception from JDBC" + e);
            }
        }

        return student;
    }
}