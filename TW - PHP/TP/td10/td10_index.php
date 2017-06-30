<?php
	require_once('php/auth.php');
	$personne = $_SESSION['personne'];
	if (!isset($_SESSION['avatar']))
	{
		$avatar = "images/avatar_def.png";
	}
?>
<!DOCTYPE html>                                      
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">                              
	<head>                                                                                         
		<meta charset="UTF-8"/>                         
		<title>Page à accès contrôlé</title>
		<link rel="stylesheet" type="text/css" href="style/style_authent.css" />
	</head>
	
	<body>
		<header>
			<h1>
				<?php
					echo "<img class=\"avatar\" src=\"$avatar\" />";
					echo "{$personne->prenom} {$personne->nom}";
				?>
				<a href="logout.php">Se déconnecter</a>
				<a href="moncompte.php">Mon compte</a>
				<form action="php/find_user.php" method="GET">
					<input type="text" name="interet" maxlength="20" />
					<input type="submit" value="Rechercher" />
				</form>
			</h1>
		</header>
		<div id="content">
			Cette page est un peu vide, non ?
		</div>
	</body>
</html>