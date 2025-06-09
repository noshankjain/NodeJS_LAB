<!-- JSP directives -->
<%@ page contentType="text/html" pageEncoding="UTF-8" language="Java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>JSP Basic Example</title>
    </head>
    <body>
        <h1>JSP Hello World!</h1>
        
        <p>
        <h2>Using JSP scriptlets</h2>
   
        <%
            String param1 = request.getParameter("param1");
            String description;
            
            if (param1.length() < 5)
            {
                description = "Very short value passed for param1";
            }
            else
            {
                description = "param1 length is " + param1.length();
            }
        %>

        <b>Parameter in request is: <%= request.getParameter("param1").toString() %> </b>
        <b>Description: <%= description %> </b>
        </p>
  
        <br>
        
        <p>
        <h2>Using JSP Expression Language and JSP Tag Library</h2>
        <b>Parameter in request is: ${param.param1} </b>
       
        <c:choose>
            <c:when test="${param.param1.length() < 5}">
                <b>Description: Very short value passed for param1 </b>
            </c:when>
            <c:otherwise>
                <b>Description: param1 length is ${param.param1.length()} </b>
            </c:otherwise>
        </c:choose>
        </p>

    </body>
</html>