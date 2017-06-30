<html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="fr" xml:lang="fr">

<head>

  <meta charset="UTF-8" />
  <title>Test PHP</title>

</head>

<body>
<?php
	function comparaison($a,$b) {
		$c ;
		if ( $a == $b) {
			$c = 0 ;
 		} else {
			if ( $a > $b ) {
				$c = 1 ; 
			} else {	
				$c = -1 ;
			}
		
		}
		return $c ;
	}
	function compareAbs($i,$j) {
		return abs($î)-abs($j) ;
	} 
	function comparerChainesParLongueur()  {
		
	}


	 $tabSort = $tab = array(5,-5,-6,7,10,1) ; 
	 $tabString = array("z","a", "e","b","s") ;
	print_r($tab); 
	echo "</br>" ; 
	sort($tabSort) ;
	print_r($tabTri); 
	echo "</br>" ; 
	usort($tabString,strcmp) ; 
	printf($tabString) ; 



?>
</body>



</html>
