package com.mycompany.sessiontrackingwithcookie;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rama
 */
@WebServlet(name = "ServletExample1", urlPatterns = {"/SubmitADummyForm"})
public class ServletExample1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletExample1</title>");
            out.println("</head>");
            
            out.println("<body>");
            out.println("<h2>User given input is: " + request.getParameter("Text1") + "</h2><br>");
            out.println("<h2>Cookies are:<h2>");
            Cookie[] cookies = request.getCookies();
            if (cookies != null)
            {
                for (Cookie cookie : cookies)
                {
                    out.println("<h3>" + cookie.getName() + ": " + cookie.getValue() + "</h3><br>");
                }
            }       
            out.println("</body>");

            out.println("</html>");
        }
    }

}
