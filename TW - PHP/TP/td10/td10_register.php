<?php
	session_start();
?>
<!DOCTYPE html>                                        
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">                              
	<head>                                                                                         
		<meta charset="UTF-8"/>                         
		<title>Inscrivez-vous !</title>
		<link rel="stylesheet" type="text/css" href="style/register.css" />
		<script type="text/javascript" src="script/register.js"></script>
	</head>
	<body>
		<?php
			if (isset($_SESSION['errlog']) && $_SESSION['errlog'] != array())
			{
				echo '<div class="errors">';
				foreach ($_SESSION['errlog'] as $key => $value)
				{
					echo '<span class="red">Erreur de saisie dans le champ: '  . $key .  ', message associé: ' . $value . '</span>';
				}
				echo '</div>';
				unset($_SESSION['errlog']);
			}
		?>
		<a href="td10_index.php" title="Accueil">Accueil</a>
		<div id="register">
			<span class="red">Inscription</span>
			<form action="php/register.php" method="post">
				<div class="collumn">
					<label>Login: </label>
					<input type="text" name="login" id="login" required="required" autofocus /><br />
					<label>Password: </label>
					<input type="password" name="password" id="password" required="required" /><br />
					<label>Retapez password: </label>
					<input type="password" name="checkPassword" id="checkPassword" required="required" class="checkable" />
					<div id="checkDiv"></div><br />
				</div>
				<div class="collumn">
					<label>Nom: </label>
					<input type="text" name="nom" id="nom" required="required" /><br />
					<label>Prenom: </label>
					<input type="text" name="prenom" id="prenom" required="required" /><br />
				</div>
				<input type="submit" value="Je m'inscris" />
			</form>
		</div>
	</body>
</html>