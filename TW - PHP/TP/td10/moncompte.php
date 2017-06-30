<?php
	require_once('php/auth.php');
	include('php/DB_connect.php');
	$personne = $_SESSION['personne'];
?>
<!DOCTYPE html>                                        
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">                              
	<head>                                                                                         
		<meta charset="UTF-8"/>                         
		<title>Mon compte</title>
		<link rel="stylesheet" type="text/css" href="style/register.css" />
		<script type="text/javascript" src="script/modify.js"></script>
	</head>
	<body>
		<a href="td10_index.php">Accueil</a>
		<div id="register">
			<span class="red">Mon compte | modifier mot de passe</span>
			<form action="php/modify.php" method="post" enctype="multipart/form-data">
				<label>Mot de passe actuel: </label>
				<input type="password" name="myPassword" id="myPassword" autofocus />
				
				<div class="collumn">
					<label>Nouveau mot de passe: </label>
					<input type="password" name="newPassword" id="newPassword" />
					<label>Centres d'interets: </label>
					<?php
						$req = $bdd->prepare('SELECT sujet FROM interets WHERE login= :login');
						$login = $_SESSION['ident']->login;
						$req->bindParam('login',$login);
						$req->execute();
						
						$data = $req->fetch();
						echo '<input type="text" name="interets" value="' . $data['sujet'] . '" placeholder="Séparé d\'une virgule" maxlength="20" />';
					?>
				</div>
				<div class="collumn">
					<label>Retapez password: </label>
					<input type="password" name="checkPassword" id="checkPassword" />
					<label>Modifier votre avatar: </label>
					<input type="file" name="avatar" />
					<input type="submit" value="Modifier" />
				</div>
			</form>
		</div>
	</body>
</html>