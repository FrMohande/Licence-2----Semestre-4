<?php
	//Importation du fichier de connexion à la base de donnée
	include('php/functions.php');
?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
	<head>
		<title>TD9 - Reponse Adresses</title>
		<meta charset="UTF-8" />
	</head>
	
	<body>
		<h3>Numeros pour la Voie</h3>
		<?php
			if (isset($_GET['cVoie']) & isset($_GET['cCommune']))
			{
				echo listeAdresses($_GET['cCommune'],$_GET['cVoie']);
				echo '<a href="index.php" title="Retour">Retour</a>';
			}
			else
			{
				header('Location: index.php');
			}
		?>
	</body>
</html>