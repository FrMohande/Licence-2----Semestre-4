<?php
	session_start();
	if($_SESSION['mode'])
		$_SESSION['mode'] = 0;
	else
		$_SESSION['mode'] = 1;
?>