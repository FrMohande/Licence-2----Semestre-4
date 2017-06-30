<?php
	require_once('lib/api.php');
	session_start();
	try{
		listCategories();
	}catch(Exception $e){
		echo "Une erreur s'est produite.";
	}
?>