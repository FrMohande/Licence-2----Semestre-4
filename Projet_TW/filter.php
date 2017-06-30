<?php
	require_once('lib/api.php');
	session_start();
	try{
		displayFiltered($_GET['word'], $_GET['author'], $_GET['category']);
	}catch(Exception $e){
		echo "Aucun résultat ne correspond à votre recherche.";
	}
?>