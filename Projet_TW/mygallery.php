<?php
	//Importation du fichier de connexion à la base de donnée
	require_once('lib/api.php');
	session_start();
	try{
		if(isConnected())
			display($_SESSION['ident']);	
		else
			require('connexion.php');	
	}catch(Exception $e){
		if($e instanceof UnknownUserException){
			require('index.php');
		}else{
			echo $e->getMessage();
		}
	}
?>
