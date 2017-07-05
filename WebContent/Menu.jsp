<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- Import jstl taglibray to use jstl tag in jsp -->
<!DOCTYPE html>
<html>
<head runat="server">
    <meta name="viewport" content="width=device-width" />
    <title>Menu</title>
    <link rel="stylesheet" type="text/css" href="assets/styles/mainPage.css" /> <!-- Link with css file -->
</head>
<body>

    <h1>Menu</h1>
    <table class="alternate">
        <tr>
            <th># 1</th>
            <th>Description</th>
        </tr>
        <c:forEach items="${allVin}" var="vin"> <!-- Retrieve all the list data which we pass from controller by jsp foreach loop and set the list to var variable-->
        <tr>
            <td>
                ${vin.id}
            </td>
            <td>
                   ${vin.description}
            </td>
        </tr>
        </c:forEach>
    </table>
    <a href="index.jsp"><button class="center">Home</button></a>

</body>
</html>