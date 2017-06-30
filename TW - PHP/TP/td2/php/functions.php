<?php
	/*
		Définition:
			enSpan: string -> string
		Paramètres:
			$str: Une chaine de caractère
		Résultat:
			Une chaine contenant des element HTML span pour chaque sous-chaine
		CU:
			Aucune
	*/
	function enSpan($str)
	{
		$res = "";
		$tab = explode('-',$str);
		for ($i = 0; $i < sizeof($tab); $i++)
		{
			$res .= "<span>" . trim($tab[$i]) . "</span>";
		}
		return $res;
	}
	
	/*
		Définition:
			propriete: string -> assocArray
		Paramètres:
			ligne: Une ligne d'un fichier de propriété de livre
		Résultat:
			Un tableau associatif avec comme clé la propriété du livre et comme valeur la valeur de la propriété
		CU:
			Aucune
	*/
	function propriete($ligne)
	{
		$tab = explode(':',$ligne);
		return array(trim($tab[0]) => trim($tab[1]));
	}
	
	/*
		Définition:
			proprieteToHTML: assocArray -> string
		Paramètres:
			prop: Un talbeau associatif de propriété sur un livre
		Résultat:
			Du code HTML en fonction de la propriété du livre
		CU:
			Aucune
	*/
	function proprieteToHTML($prop)
	{
		if (key($prop) == "couverture")
		{
			return '<li class="newlivre"><div class="' . key($prop) .  '">
				<img src="images/' . substr($prop[key($prop)],0,strlen($prop[key($prop)])) . '" alt="key" />
			</div>';
		}
		elseif (key($prop) == "titre")
		{
			return "<h2 class=\"" . key($prop) .  "\">" . $prop[key($prop)] . "</h2>";
		}
		elseif (key($prop) == "année")
		{
			return "<time class=\"" . key($prop) .  "\">" . $prop[key($prop)] . "</time>";
		}
		elseif (key($prop) == "catégorie")
		{
			return "<div class=\"" . key($prop) .  "\">" . $prop[key($prop)] . "</div></li>";
		}
		else
		{
			return "<div class=\"" . key($prop) .  "\">" . $prop[key($prop)] . "</div>";
		}
	}
?>