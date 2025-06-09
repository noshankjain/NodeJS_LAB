<%-- 
    Document   : InitialWebPage
    Author     : Rama
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page for Cookie Example</title>
    </head>
    <body>
        <h1>Cookie Example</h1>
        
        <%
            Cookie cookie1 = new Cookie("ClientState", "PlacedOrder");
            response.addCookie(cookie1);
        %>
        
        <form method="post" action="SubmitADummyForm">
            <input type="text" name="Text1">
            <button>Submit</button>
        </form>

    </body>
</html>
