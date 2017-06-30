<?php
	$login = "login";
	
	$file = fopen("php/password.txt","r");
	$pass = fgets($file);
	fclose($file);
	
	//Connection à la base de donnée
	try
	{
		$bdd = new PDO('pgsql:host=localhost;dbname=' . $login, $login, $pass);
		$bdd->exec('SET NAMES UTF-8');
	}
	catch (Exception $e)
	{
		die('An error occured : ' . $e->getMessage());
	}
?>