<?php
 require_once("php/class/Commune.class.php");

 $table = array (
  0 => 
  array (
    0 => 'Villeneuve-d\'Ascq',
    1 => '59',
    2 => '009',
    3 => '5',
    4 => '0',
    5 => '64328',
    6 => '50.622779999999999',
    7 => '3.1441699999999999',
  ),
  1 => 
  array (
    0 => 'Halluin',
    1 => '59',
    2 => '279',
    3 => '5',
    4 => '1',
    5 => '20370',
    6 => '50.782780000000002',
    7 => '3.1247199999999999',
  ),
  2 => 
  array (
    0 => 'Madeleine',
    1 => '59',
    2 => '368',
    3 => '5',
    4 => '3',
    5 => '22758',
    6 => '50.655279999999998',
    7 => '3.0702799999999999',
  ),
  3 => 
  array (
    0 => 'Attaques',
    1 => '62',
    2 => '043',
    3 => '6',
    4 => '4',
    5 => '2003',
    6 => '50.907600000000002',
    7 => '1.9349000000000001',
  ),
);
 
?>
<!DOCTYPE HTML>
 <html>
    <head>
      <meta charset="utf-8" />
      <title>Bonjour</title>
      <style>
         table { border-collapse: collapse;}
         td  { border : solid 2px; padding : 4px;}
      </style>
    </head>
  <body>
    <h1>Test classe Commune</h1>
    <table>
      <thead>
         <tr><td>Code Insee</td><td>nom complet</td><td>avec charnière</td><td>population</td><td>latitude</td><td>longitude</td><td></td></td></tr>
      </thead>
      <?php
         foreach ($table as $info) {
            $commune = new Commune($info);
            $coord = $commune->getCoordinates();
            echo "<tr>";
            echo "<td>".$commune->getINSEE()."</td><td>".$commune->getFullName()."</td>";
            echo "<td>".$commune->getCharniereName()."</td><td>".$commune->getPopulation()."</td>";
            echo "<td>".$coord[0]."</td><td>".$coord[1]."</td>";
            echo "<td><a href=\"http://www.openstreetmap.org/?mlat={$coord[0]}&mlon={$coord[1]}\">carte</a></td>";
            echo "</tr>";
         }
      ?>
    </table>
  </body>
</html>
 