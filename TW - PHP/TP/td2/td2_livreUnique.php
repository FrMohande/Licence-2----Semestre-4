<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>PHP - TD2</title>
		<meta charset="UTF-8" />
	</head>
	<body>
		<?php
			//Exercice 1
			include_once("php/functions.php");
			$file = fopen('files/exempleLivre.txt','r');
			$line = fgets($file);
			
			while ($line != false)
			{
				echo proprieteToHTML(propriete($line));
				$line = fgets($file);
			}
			
			fclose($file);
		?>
	</body>
</html>
	