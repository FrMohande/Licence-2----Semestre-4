<?php
	require_once('lib/api.php');
	session_start();
	try{
		listAuthors();
	}catch(Exception $e){
		echo "Une erreur s'est produite.";
	}
?>