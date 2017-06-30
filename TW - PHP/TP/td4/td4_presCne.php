<?php
	if (isset($_GET['insee']) && ((int) $_GET['insee'] >= 59001 && (int) $_GET['insee'] <= 59671) || ((int) $_GET['insee'] >= 62001&& (int) $_GET['insee'] <= 62909))
	{
		$insee = (string) $_GET['insee'];
	}
	else
	{
		$insee = 59100;
	}
?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>PHP - TD4</title>
		<meta charset="UTF-8" />
		<link rel="stylesheet" href="style/style.css" />
	</head>
	<body>
		<h1>Présentation de la Commune</h1>
		<table>
			<tr>
				<th>Nom</th>
				<th>Code Departement</th>
				<th>Code Commune</th>
				<th>Code Arrondissement</th>
				<th>INSEE</th>
				<th>Population</th>
				<th>Coodonnées</th>
			</td>
		<?php
			include("php/functions.php");
			require("php/class/Commune.class.php");
			$file = fopen('files/communes.csv','r');
			$tabCne = loadCommune($file);
			$object = $tabCne[$insee];
			
			$tab = $object->getCoordinates();
			echo '<tr>
					<td class="name">' . $object->getFullName() . '</td>
					<td>' . $object->getCountyCode() . '</td>
					<td>' . $object->getTownCode() . '</td>
					<td>' . $object->getBoroughCode() . '</td>
					<td>' . $insee . '</td>
					<td>' . $object->getPopulation() . '</td>
					<td>(' . $tab[0] . ',' . $tab[1] . ')</td>
				</tr>';
			fclose($file);
		?>
		</table>
	</body>
</html>