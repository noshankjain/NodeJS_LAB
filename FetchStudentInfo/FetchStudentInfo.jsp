<%@ page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Information</title>
</head>
<body>
    <h1>Fetch Student Information</h1>

    <!-- Form to input rollno and fetch student details -->
    <form action="FetchStudentInfo" method="get">
        <label for="rollno">Enter Roll No: </label>
        <input type="text" id="rollno" name="rollno" required>
        <button type="submit">Get Student Info</button>
    </form>
</body>
</html>

