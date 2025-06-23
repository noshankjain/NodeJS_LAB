<%@ page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Information</title>
</head>
<body>
    <h1>Student Information</h1>

    <!-- Display message if no student found or if there's any error -->
    <c:if test="${not empty message}">
        <p>${message}</p>
    </c:if>

    <!-- Display student details if student object is not null -->
    <c:if test="${not empty student}">
        <table border="1">
            <tr>
                <th>Roll No</th>
                <th>Name</th>
                <th>Age</th>
            </tr>
            <tr>
                <td>${student.rollno}</td>
                <td>${student.name}</td>
                <td>${student.age}</td>
            </tr>
        </table>
    </c:if>
</body>
</html>