<?php
	//Importation du fichier de connexion à la base de donnée
	require_once('lib/api.php');
	session_start();
	try{
		if(isset($_GET['member'])){
			display($_GET['member']);		
		}else{
			display(null);
		}
	}catch(Exception $e){
		if($e instanceof UnknownUserException){
			header("Location: index.php");
		}else{
			echo $e->getMessage();
		}
	}
?>
