<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
	<head>
		<meta charset="UTF-8" />
		<title>Facture</title>
		<link rel="stylesheet" href="../style/starWars.css" />
	</head>
	<body>
		<?php
			include('functions.php');
			
			$civiliteTab = array('Mr' => true, 'Mme' => true);
			$figurinesTab = array(
							'Maître Yoda',
							'Luke Skywalker',
							'Anakin Skywalker',
							'Dark Vador',
							'Obi-Wan Kenobi',
							'Han Solo',
							'Princesse Leia',
							'Padmée Amidala',
							'Empereur Palpatine',
							'R2D2',
							'C3PO',
							'Chewbacca'
							);

			$prixTotal = 0;		//Double
			$reduction = 1.0;	//Pourcentage
			$tva = 1.20;		//Pourcentage
			$livraison = 7.5;	//Double
	
			$figTab = $_POST['fig'];
			$adhesion = $_POST['adhesion'];
			$civilite = $_POST['civilite'];
			$prenom = $_POST['prenom'];
			$nom = $_POST['nom'];
			$voie = $_POST['voie'];
			$compl = $_POST['compl'];
			$codePostal = $_POST['cp'];
			$commune = $_POST['commune'];
			$consignes = $_POST['consignes'];
			
			//L'utilisateur à choisi au moins une figurine
			if (isset($figTab))
			{
				//Vérification des noms de figurines
				for ($i = 0; $i < sizeof($figTab); $i++)
				{
					if (!in_array($figTab[$i],$figurinesTab))
					{
						echo createErrorPage("Le nom des figurines est érroné !");
						die();
					}
				}
				
				//Calcule du prix des figurines
				if (sizeof($figTab) >= 5 && sizeof($figTab) < 12)
				{
					$prixTotal += sizeof($figTab) * 15;
					$reduction -= 0.2;
				}
				elseif (sizeof($figTab) == 12)
				{
					$prixTotal += 135;
				}
				else
				{
					$prixTotal += sizeof($figTab) * 15;
				}
				
				//Verification de l'adhesion
				if (isset($adhesion) && preg_match("#dejaMembre|oui|non#",$adhesion))
				{
					//traitement de l'adhesion
					if ($adhesion == "dejaMembre")
					{
					$reduction -= 0.1;
					}
					elseif ($adhesion == "oui")
					{
						$prixTotal += 5;
					}
					elseif ($adhesion != "non")
					{
						echo createErrorPage("Valeur incorrect : Adhesion");
						die();
					}
				}
				
				//Verification de la validité de la civilité
				if (isset($civilite) && preg_match("#Mr|Mme#",$civilite))
				{
					//Verification de la validité du prenom
					if (isset($prenom) && preg_match("#[A-Z][a-z]+#",$prenom))
					{
						$prenom = htmlentities($prenom);
						//Verification de la validité du nom
						if (isset($nom) && preg_match("#[A-Z][a-z]+#",$nom))
						{
							$nom = htmlentities($nom);
							//Verification de la validité de l'adresse
							if (isset($voie) && preg_match("#[A-Za-z0-9]+#",$voie))
							{
								$voie = htmlentities($voie);
								//Verification de la validité du complément d'adresse
								if (isset($compl))
								{
									$compl = htmlentities($compl);
									//Verification de la validité du code postal
									if (isset($codePostal) && is_numeric($codePostal) && preg_match("#[0-9]{5}#",$codePostal))
									{
										$codePostal = htmlentities($codePostal);
										//Verification de la validité de la ville
										if (isset($commune))
										{
											$commune = htmlentities($commune);
											$consigne = htmlentities($consigne);
											//Calcule du prix Hors Taxes
											$prixHT = ($prixTotal * $reduction) + $livraison;
											//Calcule du prix Toute Taxes Comprises
											$prixTTC = (($prixTotal * $reduction) + $livraison) * $tva;
											
											//Affichage
											echo '<table>
													<caption>Récapitulatif de votre commande</caption>
												<thead>
													<tr>
														<th class="fig">Nom de la figurine</th>
														<th>Quantité</th>
														<th>Prix HT</th>
													</tr>
												</thead>
											<tbody>';
											for ($i = 0; $i < sizeof($figTab); $i++)
											{
												echo '<tr>
														<td class="fig">' . $figTab[$i] . '</td>
														<td>1</td>
														<td>15 €</td>
													</tr>';
											}
												echo '<tr>
													<td class="fig"></td>
													<th class="infos">Frais de port : </th>
													<td>7.5€</td>
												</tr>
												<tr>
													<td class="fig"></td>
													<th class="infos">Total réduc. :</th>
													<td>' . (100 - ($reduction * 100)) . '%</td>
												</tr>
												<tr>
													<td class="fig"></td>
													<th class="infos">Total H.T. : </th>
													<td>' . $prixHT . '€</td>
												</tr>
												<tr>
													<td class="fig"></td>
													<th class="infos">Total T.V.A. : </th>
													<td>' . ($prixTTC - $prixHT) . '€</td>
												</tr>
												<tr>
													<td class="fig"></td>
													<th class="infos">Total T.T.C. : </th>
													<td>' . $prixTTC . '€</td>
												</tr>
												</tbody>
											</table>
											<div class="dest">
												Destiné à : ' . $civilite . ' ' . $prenom . ' ' . $nom . '<br />
												&Agrave; l\'adresse : ' . $voie . ', ' . $compl . ' à ' . $codePostal . ' ' . $commune . '
											</div>';
										}
//Affichage d'une page d'erreur en cas de non-validité des données saisies
										else
										{
											echo createErrorPage("Le champ 'ville' est mal rempli !");
										}
									}
									else
									{
										echo createErrorPage("Le champ 'code postal' est mal rempli !");
									}
								}
								else
								{
									echo createErrorPage("Le champ 'complement d'adresse' est incorrect !");
								}
							}
							else
							{
								echo createErrorPage("Le champ 'adresse' est mal rempli");
							}
						}
						else
						{
							echo createErrorPage("Le champ 'nom' est mal rempli");
						}
					}
					else
					{
						echo createErrorPage("Le champ 'prenom' est mal rempli");
					}
				}
				else
				{
					echo createErrorPage("La civilité est incorrecte");
				}
			}
			else
			{
				echo createErrorPage("Vous n'avez choisi aucune figurine !");
			}
		?>
	</body>
</html>