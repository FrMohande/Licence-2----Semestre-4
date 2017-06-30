<?php
	//Importation du fichier de connexion à la base de donnée
	require_once('lib/api.php');
	session_start();
	try{
		if(isConnected()){
			if(isset($_GET['img']))
				removeFromFav($_GET['img'], $_SESSION['ident']);
			else
				throw new Exception("Error Processing Request", 1);
		}else
			require('connexion.php');	
	}catch(Exception $e){
		echo "Une erreur s'est produite.";
	}
?>
