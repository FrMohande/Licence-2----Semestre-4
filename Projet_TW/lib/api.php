<?php

	function authentifier($login, $password){
		require_once('DB_connect.php');
		$stmt = $bdd->prepare("select login from users where users.login = :login and users.password = :password ;");
		$stmt->bindParam(':login',$login);
		$stmt->bindParam(':password',hash(md5, $password));
		$stmt->execute();
		if($data = $stmt->fetch())
			return $login;
		return null ;
	}



	function controleAuthentification(){
		if(isset($_POST['login'])){	
			$res = authentifier($_POST['login'], $_POST['password']);		
			if($res == null){
				throw new Exception("Identifiants incorrects, veuillez réessayer.");
			}else{
				$_SESSION['ident'] = $res;
			}			
		}else{
			throw new Exception("Veuillez enter un nom d'utilisateur");			
		}
	}

	function addToFav($img, $user){
		require_once('DB_connect.php');
		$stmt = $bdd->prepare("select login from collections where collections.login = :login and collections.id = :img ;");
		$stmt->bindParam(':login', $user);
		$stmt->bindParam(':img', $img);
		$stmt->execute();
		$stmt->closeCursor();
		if($stmt->fetch()){
			throw new Exception("Error Processing Request", 1);
		}else{
			$stmt = $bdd->prepare("insert into collections values (:login, :img)");
			$stmt->bindParam(':login', $user);
			$stmt->bindParam(':img', $img);
			$stmt->execute();
			$stmt->closeCursor();
		}
	}

	function removeFromFav($img, $user){
		require_once('DB_connect.php');
		$stmt = $bdd->prepare("select login from collections where collections.login = :login and collections.id = :img ;");
		$stmt->bindParam(':login', $user);
		$stmt->bindParam(':img', $img);
		$stmt->execute();
		if($stmt->fetch()){
			$stmt->closeCursor();
			$stmt = $bdd->prepare("delete from collections where login = :login and id= :img");
			$stmt->bindParam(':login', $user);
			$stmt->bindParam(':img', $img);
			$stmt->execute();
			$stmt->closeCursor();
		}else{
			throw new Exception("Error Processing Request", 1);
		}
	}

	function inscription($login, $password, $confirm){
		require('DB_connect.php');
		if(strlen($login)>=5) {
			if(strlen($password)>=5){
				$stmt = $bdd->prepare("select login from users where users.login = :login ;");
				$stmt->bindParam(':login', $login);
				$stmt->execute();
				if(!($stmt->fetch())){
					$stmt->closeCursor();
					if($password == $confirm){
						$stmt = $bdd->prepare("insert into users (login, password) VALUES (:login , :password);");
						$stmt->bindParam(':login', $login);
						$stmt->bindParam(':password', hash(md5, $password));
						$stmt->execute();
						$stmt->closeCursor();
					}else{
						throw new Exception("Les deux mots de passe sont différents");
					}
				}else{
					throw new Exception("Ce pseudo est déjà utilisé.");
				}
			}else{
				throw new Exception("Votre mot de passe doit contenir 5 lettres minimum");
			}
		}else{
			throw new Exception("Votre login doit contenir 5 lettres minimum");
		}
	}

	function controleInscription(){
		inscription($_POST['login'], $_POST['password'], $_POST['confirm']);
	}

	class UnknownUserException extends Exception { }

	function display($user){
		include('DB_connect.php');
		if($user){
			$stmt = $bdd->prepare("select login from users where login = :login");
			$stmt->bindParam(":login", $user);
			$stmt->execute();
			if($stmt->fetch()){
				$stmt->closeCursor();
				$stmt = $bdd->prepare("select distinct images.id, url, size, thumbnail, author, url_author, title, category, keywords from images, collections where images.id = collections.id and collections.login = :login order by images.id");
				$stmt->bindParam(":login", $user);
				$stmt->execute();
				$data = $stmt->fetchAll();
				$stmt->closeCursor();
				for($i=0;$i<count($data);$i++) {
					$data[$i]['favornot'] = favornot($data[$i]['id']);
				}				
				if($data)
					echo json_encode($data);
				else
					throw new Exception("La phototèque personnelle de cet utilisateur est vide");
			}else{
				throw new UnknownUserException();
			}

		}else{
			$stmt = $bdd->prepare("select * from images order by images.id");
			$stmt->execute();
			$data = $stmt->fetchAll();
			$stmt->closeCursor();
			for($i=0;$i<count($data);$i++) {
					$data[$i]['favornot'] = favornot($data[$i]['id']);
			}
			echo json_encode($data);
		}
	}

	function favornot($id){
		if(!isConnected()) return "";
		include('DB_connect.php');
		$stmt = $bdd->prepare("select id from collections where id = :id and login = :login ;");
		$stmt->bindParam(":id", $id);
		$stmt->bindParam(":login", $_SESSION['ident']);
		$stmt->execute();
		if($stmt->fetch()){
			$stmt->closeCursor();
			return "fav.png";
		}else{
			$stmt->closeCursor();
			return "notfav.png";
		}
	}

	function memberList($user){
		include('DB_connect.php');
		$stmt;
		if($user == null){
			$stmt = $bdd->prepare("select login from users order by login;");
		}else{
			$stmt = $bdd->prepare("select login from users where login <> :login order by login;");
			$stmt->bindParam(":login", $user);
		}
		$stmt->execute();
		$data = $stmt->fetchAll();
		$stmt->closeCursor();
		echo json_encode($data);
	}

	function listAuthors(){
		include('DB_connect.php');
		$stmt = $bdd->prepare("select distinct author from images order by author;");
		$stmt->execute();
		$data = $stmt->fetchAll();
		$stmt->closeCursor();
		echo json_encode($data);
	}

	function listCategories(){
		include('DB_connect.php');
		$stmt = $bdd->prepare("select distinct images.category from images order by images.category;");
		$stmt->execute();
		$data = $stmt->fetchAll();
		$stmt->closeCursor();
		echo json_encode($data);
	}

	function displayFiltered($word, $author, $category){
		include('DB_connect.php');
		$nbCond = 0;
		$tabWords ;
		$count;
		/*appliquer des conditions pour savoir si author et category sont bien là */
		$query = "select distinct images.id, images.url, images.size, images.thumbnail, images.author, images.url_author, images.title, images.category, images.keywords from images where";
		if($word){
			$tabWords = explode(" ", $word);
			$count = count($tabWords);
			$query .= " (images.title like '%' || :word0 || '%' OR images.keywords like '%' || :word0 || '%')";
			for($i = 1; $i<$count;$i++)
				$query .= " and (images.title like '%' || :word".$i." || '%' OR images.keywords like '%' || :word".$i." || '%')";
			$nbCond++;
		}
		if($author){
			if($nbCond>0)
				$query .= " and ";
			$query .= " images.author = :author ";
			$nbCond++;
		}

		if($category){
			if($nbCond >0)
				$query .= " and ";
			$query .= " images.category = :category ";
		}
		$query .= ";";
		$stmt = $bdd->prepare($query);
		if($word){
			for($i =0; $i<$count;$i++)
				$stmt->bindParam(":word".$i, $tabWords[$i]);
		}
		if($author)
			$stmt->bindParam(":author", $author);
		if($category)
			$stmt->bindParam(":category", $category);

		$stmt->execute();
		$data = $stmt->fetchAll();
		$stmt->closeCursor();
		for($i=0;$i<count($data);$i++) {
			$data[$i]['favornot'] = favornot($data[$i]['id']);
		}	
		if($data)
			echo json_encode($data);
		else
			echo "Aucun résultat trouvé pour votre recherche.";
	}

	function isConnected(){
		return isset($_SESSION['ident']);
	}

	function connectionDisplay(){
		if(isConnected())
			echo "<li class=\"class-nav-item\" id=\"mygallery\">Ma galerie</li>\n
					<li class=\"class-nav-item\" id=\"logout\"><a href=\"logout.php\">Déconnexion</a></li>\n";
					
		else
			echo "<li class=\"class-nav-item\" id=\"signup\"><a href=\"inscription.php\">Inscription</a></li>\n
					<li class=\"class-nav-item\" id=\"connexion\" ><a href=\"connexion.php\">Connexion</a></li>\n";
	}

	function modeDisplay(){
		if($_SESSION['mode'])
			echo "<li class=\"class-nav-item\" id=\"switch\"><div>Mode diaporama</div><img id=\"on\" alt=\"on\" src=\"images/switchon.png\"/></li>";
		else
			echo "<li class=\"class-nav-item\" id=\"switch\"><div>Mode vignettes</div><img id=\"off\" alt=\"off\" src=\"images/switchoff.png\"/></li>";
	}

?>
