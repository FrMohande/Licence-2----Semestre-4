<?php
	$loginCon = "elkhatib";
	$pass = ""; //censuré
	$host = "localhost";
	$bdd = null;
	//Connection à la base de donnée
	try
	{
		$bdd = new PDO('pgsql:host=' . $host . ';dbname=' . $loginCon, $loginCon, $pass);
		$bdd->exec('SET NAMES UTF-8');
	}
	catch (Exception $e)
	{
		echo('An error occured : ' . $e->GetMessage());
		exit();
	}
?>
