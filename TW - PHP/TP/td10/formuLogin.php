<?php
	if (isset($_SESSION['welcome']) && $_SESSION['welcome'] != "")
	{
		session_start();
	}
?>
<!DOCTYPE html>                                        
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">                              
	<head>                                                                                         
		<meta charset="UTF-8"/>                         
		<title>Authentifiez-vous</title>
	</head>
	
	<body>
		<?php
			if (isset($_SESSION['echec']))
				echo "<p>Les login et mot de passe précédemment fournis étaient incorrects</p>";
			if (isset($_SESSION['welcome']) && $_SESSION['welcome'] != "")
			{
				echo '<div class="welcome">';
				echo '<span class="green">' . $_SESSION['welcome'] . '</span>';
				echo '</div>';
				unset($_SESSION['welcome']);
			}
		?> 
		<form method="POST" action="">
			<input type="text" name="login" id="login" required="required" autofocus placeholder="Login" />
			<input type="password" name="password" id="password" required="required" placeholder="Password" />
			<button type="submit" name="valid">Connexion</button>
			<a href="td10_register.php" title="S'inscrire">Inscription</a>
		</form>
	</body>
</html>