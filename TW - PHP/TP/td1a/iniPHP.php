<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Premiers exercices PHP</title>
        <meta charset="UTF-8" />
        <link rel="stylesheet" href="iniPHP.css" />
    </head>
    <body>
        <header>
            <h1>Premier exercice PHP</h1>
            <h2>Réalisé par <span class="nom">Matthieu Lepers</span></h2>
        </header>
        <section>
            <h2>Question 1</h2>
			<?php
				date_default_timezone_set("Europe/Paris");
				echo "Nous sommes le " . date('d/m/Y');
			?>
		</section>
        <section>
            <h2>Question 2</h2>
			<?php
				echo "Version de PHP : " . PHP_VERSION . "<br />";
				echo "Système d'exploitation : " . PHP_OS;
			?>
		</section>
		<section>
            <h2>Question 3</h2>
			<?php
				$n = 8;
				$texte = "Auram est in unicuique autem nostrum, ne ponat Corruptio accipite vobis.";
				$valeur = "\$n vaut $n et \$texte vaut '$texte'";
				echo '<p>' . $valeur . '</p>';
			?>
		</section>
		<section>
            <h2>Question 4</h2>
			<?php
				for ($i = 0; $i < $n; $i++)
				{
					echo '<p>' . $texte . '</p>';
				}
			?>
		</section>
		<section>
            <h2>Question 5</h2>
			<?php
				$text = "Timoleon";
				for ($i = 0; $i < strlen($text); $i++)
				{
					echo '<p>' . substr($text,0,strlen($text) - $i) . '</p>';
				}
			?>
		</section>
		<section>
            <h2>Question 6</h2>
			<?php
				echo "<ul>";
				for ($i = 0; $i < strlen($text); $i++)
				{
					echo '<li>' . substr($text,0,strlen($text) - $i) . '</li>';
				}
				echo "</ul>";
			?>
		</section>
		<section>
            <h2>Question 7</h2>
			<?php
				echo "<ul>";
				for ($i = 2; $i < 10; $i++)
				{
					echo '<li>2*' . $i . '=' . (2*$i) . '</li>';
				}
				echo "</ul>";
			?>
		</section>
		<section>
            <h2>Question 8</h2>
			<?php
				echo "<ul>";
				for ($i = 2; $i < 10; $i++)
				{
					echo "<li><ul>";
					for ($j = 2; $j < 10; $j++)
					{
						echo '<li>' . $i . '*' . $j . '=' . ($i*$j) . '</li>';
					}
					echo "</ul></li>";
				}
				echo "</ul>";
			?>
		</section>
		<section>
            <h2>Question 9</h2>
			<?php
				echo "<table>";
				for ($i = 1; $i < 10; $i++)
				{
					echo "<tr>";
					for ($j = 1; $j < 10; $j++)
					{
						if ($i == 1 && $j == 1)
						{
							echo '<td>*</td>';
						}
						else
						{
							echo '<td>' . ($i*$j) . '</td>';
						}
					}
					echo "</tr>";
				}
				echo "</table>";
			?>
		</section>
    </body>
</html>