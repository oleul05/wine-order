<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head runat="server">
<!-- Web Page Title -->
<title>Commande du vin</title>

<!-- CSS Links -->
<link rel="stylesheet" type="text/css" href="assets/styles/reset.css">
<link rel="stylesheet" type="text/css" href="assets/styles/style.css">

<!-- JS Links -->
<!-- dossier Javascript MIS ds le head je refere au fichier Commande.js . instruction est Javascript/Commande.js -->
<script type="text/javascript" src="assets/scripts/Commande.js"></script>
<meta name="viewport" content="width=device-width" />
</head>

<body>
	<div id="main">
		<h2>Creation d'une commande</h2>
		<p>Vous devez faire un choix pour la commande ....</p>
		<form id="order" name="order" method="post" action="Commande">
		
			<div class="clientForm">
				<h4>Nouveau client</h4>
				<br>
				<div class="forms_fields">
					Prenom: <input type="text" id="inputPrenom" name="txtPrenom"><br>
					Nom: <input type="text" id="inputNom" name="txtNom"><br>
					<label id="labelNaissance">Date de Naissance: </label> 
					<input type="text" id="inputNaissance" name="txtNaissance" placeholder="1980-01-01"><br> 
					Adresse: <input type="text" id="inputAdresse" name="txtAdresse"><br>
					T&eacute;l&eacute;phone: <input type="text" id="inputTelephone"
						name="txtTelephone" placeholder="(123) 456-7890"><br>
					Description du Vin:

					<!-- fonction select permet de creer drop down menu qu'on choisi -->

					<select style="margin-bottom: 25px;" name="txtVin" id="inputVin">
						<c:forEach items="${allVin}" var="vin"> <!-- Retrieve all the list data which we pass from controller by jsp foreach loop -->
							<option value="${vin.id}">${vin.description}</option> <!-- Show the vin id and description -->
						</c:forEach>
					</select><br>
				</div>


				<div class="form-actions">
					<!--
                    BOUTON PERSONNALISÉ DE SOUMISSION DU FORMULAIRE

                    Description : Transformation d'un tag 'button submit' en bouton personnalisé avec un div

                    But : Éviter la soumission automatisée du formulaire.
                    Effet : Permettre le traitement de code JavaScript et ainsi permettre de contrôler le moment de la
                            soumission du formulaire entièrement en JavaScript.

                    Notes supplémentaires :

                        Code de test :  Instruction prise pour tester que notre bouton personnalisé peut bel et bien
                                        recevoir un clic. on click est a l'interieur  de bracket du div onmouseleave
                            onclick="alert('Un click a été effectué');"
                     -->

					<button type="button" onmouseover="document.body.style.cursor = 'pointer';" onmouseleave="document.body.style.cursor = '';"
						id="btnSoumettrenew" onclick="validerFormulaireClient();">
						Soumettre Votre Commande</button>
				</div>

			</div>
		</form>

		<!-- For. for returning customer OS: A completer Soumettre votre commande eet faire comme ds nouveau client-->
		<form id="returning_order" method="post" action="CommandeConfirmation">
			<div class="menuForm">
				<h4>Client existant</h4>
				<br>
				<div class="forms_fields">
					<input type="text" id="inputId" name="txtRetId" placeholder="Numero Client" required><br> 
					<input type="text" id="inputRetPrenom" name="txtRetPrenom" placeholder="Prenom" required><br>
					<input type="text" id="inputRetNom" name="txtRetNom" placeholder="Nom" required><br> 
					Description du Vin: 
					<select name="txtRetVin" id="inputRetVin">
						<c:forEach items="${allVin}" var="vin">
							<option value="${vin.id}">${vin.description}</option>
						</c:forEach>
					</select>
				</div>

				<div class="form-actions">
					<button type="submit" name="submit" class="input_button">Soumettre Votre Commande</button>
				</div>
			</div>
		</form>
	</div>

	<a href="index.jsp"><button class="center">Cancel</button></a>

	<div id="footer"></div>
</body>
</html>