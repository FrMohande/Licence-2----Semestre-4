//Information : Ton code PHP doit d�finir la classe de tous les <td> si noir class="noir", si blanc class="blanc" sinon class=""
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
  //si la case cliqu�e n'a aucune class de couleur (class="")
  if (this.className == "")
    {
      this.className = "blanc"; //on red�fini sa class
    }
  //si la case cliqu�e est de class blanc (class="blanc")
  else if (this.className == "blanc")
    {
      this.className = "noir";
    }
  //si la case cliqu�e est de class noir (class="noir")
  else
    {
      this.className = "";
    }
}

function setupEvent()
{
  //On r�cup�re dans un tableau tous les �l�ment td d'un tableau
  var tab = document.querySelectorAll('table td');
  for (var i = 0; i < tab.length; i++)
    {
	  //on affect � tout les �lement du tableau (qui sont des <td>) l'evenenment 'click' appelant la fonction changeColor
      tab[i].addEventListener('click',changeColor)
    }
}

//On affect � la page l'evenenment 'load' qui, quand celle-ci est compl�tement charg�e, on execute la fonction setupEvent
window.addEventListener('load',setupEvent);