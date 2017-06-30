<?php
	require('php/lib/biblio.php');
	session_start();
	try
	{
		controleAuthentification();
	}
	catch(Exception $e)
	{ 
		require('formuLogin.php');
		exit();
	}
?>