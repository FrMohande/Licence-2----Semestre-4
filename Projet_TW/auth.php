<?php
	session_start();
	require('lib/api.php');
	try{
		controleAuthentification();
		header("Location: index.php");
	}catch(Exception $e){
		header("Location: connexion.php");
		echo $e->getMessage();
	}
?>
