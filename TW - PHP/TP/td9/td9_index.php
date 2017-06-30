<?php
	//Importation du fichier de connexion à la base de donnée
	include('php/DB_connect.php');
	include('php/functions.php');
?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
	<head>
		<title>TD9 - Interface Web</title>
		<meta charset="UTF-8" />
		<link rel="stylesheet" href="style/style.css" />
	</head>
	
	<body>
		<?php
			echo formVoies("59009","reponseAdresses.php");
		?>
		
		<h2>Réponses aux questions SQL</h2>
		<div class="code">
			<span class="legend">Code: SQL<a href="td9.zip" title="Télécharger">Télécharger</a></span>
			<code>
			<?php
				$file = fopen('files/contraintes.sql','r');
				$line = fgets($file);
				
				while ($line != false)
				{
					echo colorSQL($line) . '<br />';
					$line = fgets($file);
				}
				fclose($file);
			?>
			</code>
		</div>
	</body>
</html>