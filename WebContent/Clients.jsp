<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- Import jstl taglibray to use jstl tag in jsp -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clients</title>
<link rel="stylesheet" type="text/css" href="assets/styles/mainPage.css" /> <!-- Link with css file -->
</head>
<body>
	
	<h1>Clients</h1>
    <table class="alternate">
        <tr>
            <th># Client</th>
            <th>Nom</th>
            <th>Prenom</th>
            <th>Adresse</th>
            <th>Naissance</th>
            <th>#Téléphone</th>
        </tr>
       <c:forEach items="${list}" var="client"> <!-- Retrieve all the list data which we pass from controller by jsp foreach loop -->
        <tr>
            <td>
               ${client.id} <!-- get the id from the list --> 
            </td>
            <td>
                ${client.nom}
            </td>
            <td>
                 ${client.prenom}
            </td>
            <td>
                 ${client.adresse}
            </td>
            <td>
                 ${client.naissance}
            </td>
            <td>
                 ${client.telephone}
            </td>
        </tr>
        </c:forEach>
    </table>
    <a href="index.jsp"><button class="center" onclick="window.location.href=''">Home</button></a>
</body>
</html>