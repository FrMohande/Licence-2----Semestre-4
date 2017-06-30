<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>PHP - TD4</title>
		<meta charset="UTF-8" />
		<!--<link rel="stylesheet" href="style/style.css" />-->
	</head>
	<body>
		<?php
			include("php/functions.php");
			require("php/class/Commune.class.php");
			$file = fopen('files/communes.csv','r');
			$tab = loadCommune($file);
			echo '<table>';
			foreach ($tab as $key => $value)
			{
				if ($key != "deptcomm")
				{
					echo '<tr>
						<td>' . $value->getINSEE() . '</td>
						<td>' . $value->getFullName() . '</td>
						<td><a href="td4_presCne.php?insee=' . $value->getINSEE() . '" target="blank">Plus d\'informations</a></td>
					</tr>';
				}
				else
				{
					echo '<tr>
						<td>' . $value->getINSEE() . '</td>
						<td>' . $value->getFullName() . '</td>
						<td>Lien vers la commune</td>
					</tr>';
				}
			}
			echo '</table>';
			fclose($file);
		?>
	</body>
</html>