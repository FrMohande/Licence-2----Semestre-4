<?php
	session_start();
	unset($_SESSION['ident']);
	session_destroy();
	header("Location: td10_index.php");
?>
