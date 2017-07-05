<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- Import jstl taglibray to use jstl tag in jsp -->
<!DOCTYPE html>

<html>
<head runat="server">
    <meta name="viewport" content="width=device-width" />
    <title>Comfirmation du commande</title>
    <link rel="stylesheet" type="text/css" href="assets/styles/mainPage.css" /> <!-- Link with css file -->
</head>
<body>

    <h1>Comfirmation de la commande</h1>
    <table class="alternate">
        <tr>
            <th># Commande</th>
            <th>Nom</th>
            <th>Prenom</th>
            <th>Adresse</th>
            <th>#Téléphone</th>
            <th>Vin</th>
            <th>Date et Heure</th>
        </tr>
        <c:forEach items="${cl}" var="con"> <!-- Retrieve all the list data which we pass from controller by jsp foreach loop -->
        <tr>
        
            <td>
                ${con.id}
            </td>
            <td>
                ${con.nom}
            </td>
            <td>
                ${con.prenom}
            </td>
            <td>
                ${con.address}
            </td>
            <td>
                ${con.telephone}
            </td>
             <td>
                ${con.description}
            </td>
            <td>
                ${con.dateHeure}
            </td> 
           
        </tr>
         </c:forEach>     
    </table>
    <a href="index.jsp"><button class="center">Home</button></a>
</body>
</html>
