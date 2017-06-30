<?php
	$loginD = "login";
	$passD = "";
	
	//Connection à la base de donnée
	try
	{
		$bdd = new PDO('pgsql:host=localhost;dbname=' . $loginD, $loginD, $passD);
		$bdd->exec('SET NAMES UTF-8');
	}
	catch (Exception $e)
	{
		die('An error occured : ' . $e->getMessage());
	}
?>