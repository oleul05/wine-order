<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head runat="server">
    <meta name="viewport" content="width=device-width" />
    <meta charset="UTF-8">
    <title>Wine site</title>
    <!-- <link href="assets/css/bootstrap.min.css" rel="stylesheet"> -->
    <link rel="stylesheet" type="text/css" href="assets/styles/mainPage.css" /> <!-- Link with css file -->
</head>
<body class="mainBody">
    <h1>Vignoble Bellusci</h1>
    <table>
        <tr>
            <td>
                <table>
                    <tr>
                        <td>
                            <a href="menu"><button>Menu</button></a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <a href="commandes"><button>Creer une commande</button></a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <a href="commande"><button>Voir commandes</button></a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <a href="client"><button>Clients</button></a>
                        </td>
                    </tr>
                </table>
            </td>
            <td>
                <div>
                    <img src="assets/images/wine.jpg" width="400">
                    <div>Propri&eacute;taire: Mario Bellusci.</div>
                    <br>
                    <div>Coordonnées: 613-222-5555</div>
                </div>
            </td>
        </tr>
    </table>

</body>
</html>
