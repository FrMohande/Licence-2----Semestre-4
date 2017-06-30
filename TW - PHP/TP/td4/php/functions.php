<?php
	/*
		Définition:
			floadCommune : file -> Commune assocArray
		Paramètres:
			$file : un fichier ouvert
		Resultat:
			Un tableau associatif d'objet commune
		CU:
			Aucune
	*/
	function loadCommune($file)
	{
		$res = array();
		$communeTab =  fgetcsv($file);
		while ($communeTab != false)
		{
			$commune = new Commune($communeTab);
			$res[$commune->getINSEE()] = $commune;
			$communeTab =  fgetcsv($file);
		}
		return $res;
	}
	
	/*
		Définition:
			createErrorPage : string -> HTML string
		Paramètres:
			$msg : Le message d'erreur à afficher
		Resultat:
			Une page d'erreur
		CU:
			Aucune
	*/
	function createErrorPage($msg)
	{
		return '<div class="error">
			<span>Erreur de saisie !</span>
			<p>
				' . $msg . '
			</p>
		</div>';
	}
?>