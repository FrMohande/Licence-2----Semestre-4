//Il te faut un dossier images/ dans lequel il y a deux images, valid.png et invalid.png
//Ajouter une balise <div id="checkDiv"></div> dans ton forumaire d'inscription

function checkPassword()
{
	//Obtention de tous les champs de type password
	var passFields = document.querySelectorAll('input[type="password"]');
	//Obtention de la balise div d'id checkDiv
	var checkDiv = document.getElementById('checkDiv');
	if (passFields[1].value == passFields[2].value)
	{
		checkDiv.innerHTML = '<img src="images/valid.png" alt="valid" />';
	}
	else
	{
		checkDiv.innerHTML = '<img src="images/invalid.png" alt="invalid" />';
	}
}

function setupEvent()
{
	var passFields = document.querySelectorAll('input[type="password"]');
	passFields[1].addEventListener('keyup',checkPassword);
	passFields[2].addEventListener('keyup',checkPassword);
}

window.addEventListener('load',setupEvent);