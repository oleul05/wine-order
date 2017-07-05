/**I used StackOverflow/Coderanch, treehouse,
 * Created  on 2/22/2017.
 */

//fonction utiliser pour faire validation formulaire table commande


function validerFormulaireClient() {
    //message d'alerte pour verifier que le code javascript est pris en consideration par l,APPLICATION
    //SI CODE JAVASCRIPT PAS PRIS EN CONSIDERATION  je n'aurais pas ce message d'alerte
    //si je click ok il continue d'executer le code de validation

    //  alert('Début de la fonction : validerFormulaireClient().');

    //1) ToDo declarer variable pertininent pour validation formulaire
    var valide = true;


    var dateString = document.forms["order"]["txtNaissance"].value;

    var isDate = true;
    if (dateString == "") {
        isDate = false;
    } else {
        //try to see if the text in the date cannot be parsed as date
        var d = Date.parse(dateString);
        if ((typeof d === 'undefined' || !d))
            isDate = false;
    }

    var age;
    //if the text is date try to calculate the age
    if (isDate) {
        //crete the date
        birthday = new Date(dateString);
        var ageDifMs = Date.now() - birthday.getTime();
        var ageDate = new Date(ageDifMs); // miliseconds from epoch
        // remove 1970 for the epoch calculation
        age = Math.abs(ageDate.getUTCFullYear() - 1970);
    }


    //                     [ID_FORMULAIRE][NAME_DU_CHAMP_INPUT]
    var prenom = document.forms["order"]["txtPrenom"].value; //prenom entrer ds le formulaire
    var nom = document.forms["order"]["txtNom"].value;  //nom entrer ds le formulaire
    var adresse = document.forms["order"]["txtAdresse"].value; //Adresse entrer ds le formulaire

    var telephone = document.forms["order"]["txtTelephone"].value; //numero telephone saisi ds formulaire

    var phoneno; //numero standard attendu
    phoneno = /^(?:(?:\+?1\s*(?:[.-]\s*)?)?(?:\(\s*([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9])\s*\)|([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9]))\s*(?:[.-]\s*)?)?([2-9]1[02-9]|[2-9][02-9]1|[2-9][02-9]{2})\s*(?:[.-]\s*)?([0-9]{4})(?:\s*(?:#|x\.?|ext\.?|extension)\s*(\d+))?$/;


    // TODO 2) variables du formulaire a valider

    // TODO 2.1) Validation de l"age

    //pour debugging et voir ce qui se passe
    // alert("L'âge capturé par le JavaScript est : " + age);

    //autre message d'alerte pour debugger et voir code js pris en consideration
    //click ok au message et il continuera
    //pour debugging
    //   alert('Avant validation si age est vide.');

    //// Si vide
    if ((typeof age === 'undefined' || !age)) {

        alert("svp remplir la date de naissance");
        valide = false;
    }

    //pour debugging
    // alert('Avant validation si est mineur');
    // Si mineur
    if (age < 19) {

        //pour avertir que moins de 19 ans
        alert("Impossible de continuer: Vous devez avoir au moins 19 ans.");
        valide = false;
    }


    //TODO 2.2) validation prenom

    // Si prenom est vide
    if (prenom == "") {

        alert("svp remplir le prenom");
        valide = false;
    }

    // Si nom est vide
    if (nom == "") {

        alert("svp remplir le nom");
        valide = false;
    }


    // Si adresse est vide
    if (adresse == "") {

        alert("svp remplir l'adresse");
        valide = false;
    }

    //TODO 2.3) Validation telephone

    // Si telephone est vide
    if (telephone == "") {

        alert("svp remplir le telephone");
        valide = false;
    }


    /*if (!telephone.match(phoneno)) {
        alert("svp saisir un numero valide");
        valide = false;
    }*/



    // Effectuer la soumission du formulaire via un click virtuel en JavaScript
    if (valide)
        document.getElementById("order").submit();



    //pour debugging
    //   alert('Fin de la fonction : validerFormulaireClient().');

}