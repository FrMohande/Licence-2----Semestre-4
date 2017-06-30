<?php
	session_start();
	require_once('lib/api.php');
	try{
		controleInscription();
		require('index.php');
	}catch(Exception $e){
		if($e instanceof AlreadyLoggedException){
			require('index.php');
			exit();
		}else{
			require('inscription.php');
			echo $e->getMessage();
		}
	}
?>
