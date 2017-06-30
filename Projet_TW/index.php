<?php
	//Importation du fichier de connexion à la base de donnée
	require_once('lib/api.php');
	session_start();
	if(!isset($_SESSION['mode'])){
		$_SESSION['mode'] = 0 ; /* 0 = mode vignettes, 1 = mode diaporama */
	}
?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
	<head>
		<title>Phototèque</title>
		<meta charset="UTF-8"/>
		<link rel="stylesheet" href="style/style.css" />
		<script type="text/javascript" src="scripts/script.js"></script>
	</head>
	<body>
	<!-- barre horizontal -->
	<div class="header">
		<div class="headercentrage">
			<div class="logo">
				<img width="177" height="20" src="./images/logo.png" alt="logo"/>
			</div>
			<div class="log">
				<ul>
					<li id="lisearch"><input type="search" id="search" placeholder="Recherche..." value=""/></li>
					<li id="accueil" class="class-nav-item">Accueil</li>
					<li id="membersGal" class="class-nav-item">Membres</li>
					<?php
						connectionDisplay();
					?>
					<?php
						modeDisplay();
					?>
				</ul>
			</div>
		</div>
	</div>
	<!-- Gallerie  -->
	<div class="conteneur">
		<div class="mea">
		</div>
	</div>	
	</body>
</html>
