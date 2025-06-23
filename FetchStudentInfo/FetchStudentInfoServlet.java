/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

@WebServlet(name = "FetchStudentInfoServlet", urlPatterns = {"/FetchStudentInfo"})
public class FetchStudentInfoServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(FetchStudentInfoServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
        // Fetch the roll number from the request parameter
        String rollnoParam = request.getParameter("rollno");

        if (rollnoParam != null && !rollnoParam.isEmpty()) {
            try {
                int rollno = Integer.parseInt(rollnoParam);
                
                // Create an instance of StudentDAO and get the student details
                StudentDAO studentDAO = new StudentDAO(logger);
                Student student = studentDAO.getStudentByRollno(rollno);
                
                // Set the student object in the request scope
                if (student != null) {
                    request.setAttribute("student", student);
                } else {
                    request.setAttribute("message", "No student found with this roll number: " + rollno);
                }
                
            } catch (NumberFormatException e) {
                // If the rollno is not a valid number, set an error message
                request.setAttribute("message", "Invalid roll number.");
            }
        } else {
            request.setAttribute("message", "Roll number is required.");
        }

        // Forward the request to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/StudentInfo.jsp");
        dispatcher.forward(request, response);
    }

}