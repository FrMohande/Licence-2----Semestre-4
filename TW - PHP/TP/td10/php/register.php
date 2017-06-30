<?php
	session_start();
	include("DB_connect.php");
	include("lib/hashUtil.php");
	$errlog = array();
	$location = "Location: ../register.php";
	
	function isUsed($bdd,$login)
	{
		$req = $bdd->prepare('SELECT * FROM personne WHERE login= :login');
		$req->execute(array('login' => $login));
		$data = $req->fetch();
		
		return $data==false?false:true;
	}
	
	if (isset($_POST['login']) && !isUsed($bdd,$_POST['login']))
	{
		if (isset($_POST['password']) && isset($_POST['checkPassword']) && $_POST['password'] == $_POST['checkPassword'])
		{
			if (isset($_POST['nom']) && isset($_POST['prenom']))
			{
				//Insertion dans la base de donnée
				$req = $bdd->prepare('INSERT INTO personne(login,password,nom,prenom) VALUES(:login,:password,:nom,:prenom)');
				$req->bindParam('login',$_POST['login']);
				$req->bindParam('password',sha1($_POST['password']));
				$req->bindParam('nom',$_POST['nom']);
				$req->bindParam('prenom',$_POST['prenom']);
				$req->execute();
				
				//Creation des centres d'interets
				$req = $bdd->prepare('INSERT INTO interets(login) VALUES(:login)');
				$req->bindParam('login',$_POST['login']);
				$req->execute();
				
				//Insertion réussie, on previent l'utilisateur
				$_SESSION['welcome'] = "Bienvenue " . $_POST['login'] . " !";
				$location = "Location: ../td10_index.php";
				session_destroy();
			}
			else
			{
				$errlog['Nom|Prenom'] = "Le nom ou le prenom n'est pas saisie !";
			}
		}
		else
		{
			$errlog['Mot de passe'] = "Les mots de passe saisient sont différents !";
		}
	}
	else
	{
		$errlog['login'] = "Aucun login saisie ou ce login est deja utilisé par quelqu'un d'autre !";
	}
	
	$_SESSION['errlog'] = $errlog;
	header($location);
?>