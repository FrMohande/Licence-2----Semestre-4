<?php
	require_once('class/Identite.class.php');
	session_start();
	include('DB_connect.php');
?>
<!DOCTYPE html>                                        
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">                              
	<head>                                                                                         
		<meta charset="UTF-8"/>                         
		<title>Modification du compte</title>
	</head>
	<body>
		<?php
			$login = $_SESSION['ident']->login;
			
			function passIsCorrect($bdd,$login,$pass)
			{
				$passHash = sha1($pass);
				$req = $bdd->prepare('SELECT * FROM personne WHERE login= :login AND password= :password');
				$req->bindParam('login',$login);
				$req->bindParam('password',$passHash);
				$req->execute();
				
				$data = $req->fetch();
				
				return $data!=false?true:false;
			}
			
			//Partie changement du mot de passe
			if (isset($_POST['myPassword']) && isset($_POST['newPassword']) && isset($_POST['checkPassword']) && $_POST['newPassword'] == $_POST['checkPassword'] && passIsCorrect($bdd,$login,$_POST['myPassword']))
			{
				$password = sha1($_POST['checkPassword']);
				$req = $bdd->prepare('UPDATE personne SET password= :password WHERE login= :login');
				$req->bindParam('password',$password);
				$req->bindParam('login',$login);
				$req->execute();
				echo 'Votre mot de passe à été modifié avec succès ! <br />';
			}
			else
			{
				echo 'Votre mot de passe n\'a pas été modifié ! <br />';
			}
			
			//Partie mise a jour des centres d'interets
			if  (isset($_POST['interets']) && $_POST['interets'] != "")
			{
				//Convertie les caractères accentués
				$sujet = $_POST['interets'];
				$req = $bdd->prepare('UPDATE interets SET sujet= :sujet WHERE login= :login');
				$req->bindParam('sujet',$sujet);
				$req->bindParam('login',$login);
				$req->execute();
				echo 'Vos centres d\'interêts ont été mis à jour ! <br />';
			}
			else
			{
				echo 'Vos centres d\'intérêts n\'ont pas été mis à jour ! <br />';
			}
			
			//Partie modification de l'avatar
			$extension_valides = array('jpg','jpeg','gif','png');
			$max_size = 1000;
			
			if (isset($_FILE['avatar']))
			{
				if ($_FILE['avatar']['error'] == 0)
				{
					if ($_FILE['avatar']['size'] <= 1000)
					{
						//Redimentionné
					}
					else
					{
						//Autre verif
					}
				}
				else
				{
					echo 'Une erreur est survenue, votre avatar n\'a pas été changé !';
				}
			}
			else
			{
				echo 'Votre avatar n\'a pas été changé !';
			}
			echo 'Redirection vers la page d\'accueil dans 3 secondes ...';
			header('Refresh: 3;URL= ../td10_index.php');
		?>
	</body>
</html>