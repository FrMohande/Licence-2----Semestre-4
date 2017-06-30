<?php
	function colorSQL($s)
	{
		$s = preg_replace("/(\-\-.+)/",'<span class="green">$1</span>',$s);
		$s = preg_replace("/(ALTER|FOREIGN|REFERENCES|SELECT|AND|CREATE|TABLE|int|time|PRIMARY|KEY|FROM|CAST|ORDER|BY|ASC|DESC|WHERE|AS|LIKE|VARCHAR|INSERT|INTO|VALUES|IS|NULL|NOT|UPDATE|SET)/",'<span class="blue">$1</span>',$s);
		$s = preg_replace("/([0-9]+)/",'<span class="aqua">$1</span>',$s);
		$s = preg_replace("/('.+')/",'<span class="purple">$1</span>',$s);
		$s = preg_replace("/(\()/","<strong>$1</strong>",$s);
		$s = preg_replace("/(\))/","<strong>$1</strong>",$s);
		$s = preg_replace("/(;)/","<strong>$1</strong>",$s);
		
		return $s;
	}
	
	function formVoies($cc,$url)
	{
		include('php/DB_connect.php');
		$req = $bdd->prepare('SELECT nom_voie,code_voie FROM adresses WHERE code_commune= :code GROUP BY nom_voie,code_voie ORDER BY nom_voie ASC');
		$req->execute(array('code' => $cc));
		
		$options = '';
		while($data = $req->fetch())
		{
			$options .= '<option value="' . $data['code_voie'] . '">' . $data['nom_voie'] . '</option>';
		}
		
		return '<form action="' . $url . '" method="get">
			<select name="cVoie">
				' . $options . '
			</select>
			<input type="hidden" name="cCommune" value="' . $cc . '" />
			<input type="submit" value="Confirmer" />
		</form>';
	}
	
	function listeAdresses($cc,$cv)
	{
		include('php/DB_connect.php');
		$req = $bdd->prepare('SELECT numero FROM adresses WHERE code_commune= :cCommune AND code_voie= :cVoie ORDER BY numero ASC');
		$req->bindParam("cCommune",$cc);
		$req->bindParam("cVoie",$cv);
		$req->execute();
		$options = "";
		while ($data = $req->fetch())
		{
			$options .= '<li>' . $data['numero'] . '</li>';
		}
		
		return '<ul>' . $options . '</ul>';
	}
?>