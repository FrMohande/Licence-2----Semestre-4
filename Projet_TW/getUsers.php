<?php
	require_once('lib/api.php');
	session_start();
	try{
		if(isConnected()){
			memberList($_SESSION['ident']);
		}else{
			memberList(null);
		}
	}catch(Exception $e){
		echo "Une erreur s'est produite.";
	}
?>