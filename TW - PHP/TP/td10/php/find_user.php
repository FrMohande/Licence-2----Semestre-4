<?php
	session_start();
	include('DB_connect.php');
	
	header("Content-Type: application/json");
	
	if (isset($_GET['interet']))
	{
		$sujet = '%' . $_GET['interet'] . '%';
		
		$req = $bdd->prepare('SELECT personne.login,personne.nom,personne.prenom FROM personne,interets WHERE personne.login = interets.login AND interets.sujet LIKE :sujet');
		$req->bindParam('sujet',$sujet);
		$req->execute();
		$data = $req->fetchAll();
		echo json_encode($data);
	}
	else
	{
		$req = $bdd->query('SELECT login,nom,prenom FROM personne');
		$data = $req->fetchAll();
		
		echo json_encode($data);
	}
?>