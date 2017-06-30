//Information : Ton code PHP doit définir la classe de tous les <td> si noir class="noir", si blanc class="blanc" sinon class=""
/*
	fichier style.css
	table td.noir { //les tds noir
		background-color: #000;
	}
	
	table td.blanc { //les tds blanc
		background-color: #FFF;
	}
	
	table td { //les autres tds
		background-color: #888;
	}
*/

function changeColor()
{
  //si la case cliquée n'a aucune class de couleur (class="")
  if (this.className == "")
    {
      this.className = "blanc"; //on redéfini sa class
    }
  //si la case cliquée est de class blanc (class="blanc")
  else if (this.className == "blanc")
    {
      this.className = "noir";
    }
  //si la case cliquée est de class noir (class="noir")
  else
    {
      this.className = "";
    }
}

function setupEvent()
{
  //On récupère dans un tableau tous les élément td d'un tableau
  var tab = document.querySelectorAll('table td');
  for (var i = 0; i < tab.length; i++)
    {
	  //on affect à tout les élement du tableau (qui sont des <td>) l'evenenment 'click' appelant la fonction changeColor
      tab[i].addEventListener('click',changeColor)
    }
}

//On affect à la page l'evenenment 'load' qui, quand celle-ci est complètement chargée, on execute la fonction setupEvent
window.addEventListener('load',setupEvent);