<?php
	class Commune
	{
		private $name;
		private $countyCode;
		private $townCode;
		private $boroughCode;
		private $tncc;
		private $population;
		private $latitude;
		private $longitude;
		private static $article = array("","","Le ","La ","Les ","L'","Aux ","Las ","Los ");
		private static $charniere = array("de ","d'","du ","de La ","des ","de L'","des ","de Las ","de Los ");
		
		function __construct($tab)
		{
			if (sizeof($tab) == 8)
			{
				$this->name = (string) $tab[0];
				$this->countyCode = $tab[1];
				$this->townCode = $tab[2];
				$this->boroughCode= $tab[3];
				$this->tncc = $tab[4];
				$this->population = (int) $tab[5];
				$this->latitude = (double) $tab[6];
				$this->longitude = (double) $tab[7]; 
			}
			else
			{
				trigger_error('Parametter length must be 8'); 
			}
		}
		
		
		//Gettings methods
		/*
		 * @return	The name of this Town
		 */
		public function getName()
		{
			return $this->name;
		}
		
		/*
		 * @return	The county code of this Town
		 */
		public function getCountyCode()
		{
			return $this->countyCode;
		}
		
		/*
		 * @return	The town code of this Town
		 */
		public function getTownCode()
		{
			return $this->townCode;
		}
		
		/*
		 * @return	The bough code of this Town
		 */
		public function getBoroughCode()
		{
			return $this->boroughCode;
		}
		
		/*
		 * @return	The population number of this Town
		 */
		public function getPopulation()
		{
			return $this->population;
		}
		
		/*
		 * @return	The INSEE code of this Town
		 */
		public function getINSEE()
		{
			return ((string) $this->countyCode) . ((string) $this->townCode);
		}
		
		/*
		 * @return	The latitude and longitude of this Town
		 */
		public function getCoordinates()
		{
			return array($this->latitude,$this->longitude);
		}
		
		/*
		 * @return	The full name code of this Town
		 */
		public function getFullName()
		{
			return Commune::$article[$this->tncc] . $this->name;
		}
		
		/*
		 * @return	The full name code of this Town
		 */
		public function getCharniereName()
		{
			return Commune::$charniere[$this->tncc] . $this->name;
		}
		
	}
?>