<?php
	function __autoload($className) 
	{
		include 'php/class/'.$className . '.class.php';
	}

	/*
	  Si login et password sont corrects, alors 
	  le résultat est une instance d'Identite décrivant cet utilisateur
	  Sinon le résultat vaut null
	*/
	function authentifie($login,$password)
	{
		include('php/DB_connect.php');
		$pass = sha1($password);
		$req = $bdd->prepare('SELECT * FROM personne WHERE login= :login AND password= :password');
		$req->bindParam('login',$login);
		$req->bindParam('password',$pass);
		$req->execute();
		
		$user = $req->fetch();
		if ($user)
		{
			return new Identite($user['login'],$user['nom'],$user['prenom']);
		}
		return null;
	}

	/*
		Verifie l'authentification 
		La fonction se termine normalement
		- Si l'état de la session indique que l'authentification a déjà eu lieu
		- Si des paramètres login/password corrects ont été fournis
		Après exécution correcte,  $_SESSION['ident'] contient l'identité de l'utilisateur
		Dans tous les autres cas, une exception est déclenchée
	*/
	function controleAuthentification()
	{
		if (isset($_SESSION['ident']))
		{
			return true;
		}
		$login = inputFilterString('login');
		$password = inputFilterString('password');
		$personne = authentifie($login,$password);
		if (!$personne)
		{ 
			$_SESSION['echec']=TRUE;
			throw new Exception('login/password incorrects');
		}
		$_SESSION['ident'] = $personne;  //ou serialize($ident);
		restaureContexteUtilisateur($personne);
		unset($_SESSION['echec']); // au cas où c'était positionné
		return true;
	}


	/*
	 fonction qui restaure toutes les informations relatives à l'utilisateur
	 qui vient de se connecter et nécessaires à la bonne marche du site.
	 
	 Cette fonction est appelée par controleAuthentification()
	 */
	function restaureContexteUtilisateur($personne){
		$_SESSION['personne'] = $personne;
	}

	function inputFilterString($name, $requis=TRUE){
		$v = filter_input(INPUT_POST, $name, FILTER_SANITIZE_STRING);
		if ( $requis && $v == NULL )
		{
			throw new Exception("argument $name est requis");
		}
		return $v;
	}

?>
