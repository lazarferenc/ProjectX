<?php 
$db_name = "beadando";
$mysql_username = "beadando";
$mysql_password = "F3cuska96";
$server_name = "127.0.0.1";
$con = mysqli_connect($server_name, $mysql_username, $mysql_password ,$db_name);
 if($con){
	 
	 echo"Sikeres csatlakozás";
	 
 }
 else{
	 
	 echo"Sikertelen csatlakozás";
 }
?>