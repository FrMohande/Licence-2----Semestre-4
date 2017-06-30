<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>PHP - TD2</title>
		<meta charset="UTF-8" />
		<link rel="stylesheet" href="style/style.css" />
	</head>
	<body>
		<?php
			include_once("php/functions.php");
			$file = fopen('files/livres.txt','r');
			$line = fgets($file);
			echo "<ul>";
			while ($line != false)
			{
				if (strlen($line) != 2)
				{
					echo proprieteToHTML(propriete($line));
				}
				$line = fgets($file);
			}
			echo "</ul>";
			fclose($file);
		?>
	</body>
</html>