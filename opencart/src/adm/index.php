<?php
// Version
define('VERSION', '4.0.2.2');

// Configuration
if (is_file('config.php')) {
	require_once('config.php');
}

// Install
if (!defined('DIR_APPLICATION')) {
	header('Location: ../install/index.php');
	exit();
}

//vQmod
//require_once('../vqmod/vqmod.php');
//VQMod::bootup();

// VQMODDED Startup
require_once(DIR_SYSTEM . 'startup.php');

// Framework
require_once(DIR_SYSTEM . 'framework.php');
