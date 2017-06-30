<?php
  session_start();
  require_once('lib/api.php');
  if(isConnected()){
    header("Location: index.php");
    exit();
  }

?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="style/inscription.css">
  </head>

  <body>
    <div id="container">
      <div id="main" role="main">
        <form method="post" action="register_validation.php" >
          <fieldset>
            <label for="Login">Nom d'utilisateur</label>
            <input type="text" name="login" id="login" required autofocus>
            <label for="password">Mot de Passe</label>
            <input type="password" name="password" id="password" required>
            <label for="confirm">Confirmez le mot de passe</label>
            <input type="password" name="confirm" id="confirm" required>
          </fieldset>
          <fieldset>
            <button type=submit>S'inscrire</button>
          </fieldset>
        </form>
      </div>
    </div> 
  </body>
</html>
