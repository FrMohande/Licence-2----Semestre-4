<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>PHP - TD1b</title>
        <meta charset="UTF-8" />
		<script type="text/javascript" src="script/script.js"></script>
		<link rel="stylesheet" href="style/iniPHP.css" />
		<link rel="stylesheet" href="style/style.css" />
    </head>
    <body>
		<section>
            <h2>Exercice 1</h2>
			<?php
				echo "Liste des noms : ";
				echo "<select>";
				$file = fopen("files/liste_noms.txt","r");
				$line = fgets($file);
				while ($line !== false)
				{
					echo "<option>" . $line . "</option>";
					$line = fgets($file);
				}
				fclose($file);
				echo "</select>";
			?>
		</section>
		<section>
            <h2>Exercice 2 <code>JS</code></h2>
			<?php
				//début de tableau
				echo "<table><tbody>";
				
				//ouvertur du fichier en lecture
				$file = fopen("files/terrain" . rand(0,1) . ".txt","r");
				
				//On récupère la première ligne
				$line = fgets($file);
				
				//on calcule la longueur de cette ligne
				$len = strlen($line) - 1;
		
				//tant qu'on peut lire une ligne
				if ("terrain.txt" == true)
				{
					while ($line !== false)
					{
						//On ajoute une ligne au tableau
						echo "<tr>";
						for ($i = 0; $i < $len; $i++)
						{
							//On récupère le caractère à l'indice $i de la chaine $line
							$char = $line{$i};
							//Si c'est un B
							if ($char == "B")
							{
								echo "<td class=\"blanc\"></td>";
							}
							//si c'est un N
							elseif ($char == "N")
							{
								echo "<td class=\"noir\"></td>";
							}
							//Si c'est autre chose (ici un tiret)
							else
							{
								echo "<td class=\"\">" . "</td>";
							}
						}
						
						//On récupère la ligne suivante
						$line = fgets($file);
						
						//On termine la ligne de tableau
						echo "</tr>";
					}
				}
				else
				{
					echo "mauvais fichier";
				}
				//on ferme le fichier
				fclose($file);
				//fin de tableau
				echo "<tbody></table>";
			?>
		</section>
		<section>
            <h2>Exercice 3</h2>
			<?php
				$str = "AER+IGNIS+AQUA+PERDITIO+ORDO+TERRA";
				echo '<p>$str vaut : ' . $str . '</p>';
				$tab = explode('+',$str);
				for ($i = 0; $i < sizeof($tab); $i++)
				{
					echo "<span>" . trim($tab[$i]) . "</span><br />";
				}
				echo '<br />';
				
				/*
					Définition:
						enSpan : string -> HTML string
					Paramètres:
						$str = La chaine de caractère à formater
					Résultat:
						Toutes les sous-chaines séparé par un tiret sont mises dans un élement HTML <span>
					CU:
						Aucune
				*/
				function enSpan($str)
				{
					$res = "";
					$tab = explode('-',$str);
					for ($i = 0; $i < sizeof($tab); $i++)
					{
						$res = $res . "<span>" . trim($tab[$i],' ') . "</span>";
					}
					return $res;
				}
				echo 'htmlentities(enSpan("Dupont - durant")) = ' . htmlentities(enSpan("Dupont - durant"));
			?>
		</section>
    </body>
    
</html>