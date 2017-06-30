<?php
  session_start();
  require_once('lib/api.php');
  if(isConnected()){
    header("Location: index.php");
  }

?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
<head>
  <meta charset="utf-8">
  <link rel="stylesheet" href="style/connexion.css">
</head>
<body>
  <div id="container">
    <header>
    </header>
    <div id="main" role="main">
      <form method="post" action="auth.php" >
          <fieldset>  
            <label for="login">Nom d'utilisateur<span class="ico"><img src="images/user.png" alt="Username Icon" border="0" /></span></label>
            <input type="text" name="login" id="login" required autofocus>
            <label for="password">Mot de passe<span class="ico"><img src="images/pass.png" alt="Password Icon" border="0" /></span></label>
        	  <input type="password" name="password" id="password" required>
          </fieldset>
          <fieldset>
            <button type=submit>Connexion</button>
          </fieldset>
        </form>
      </div>
    </div>
  </body>
</html>
