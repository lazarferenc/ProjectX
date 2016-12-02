<?php 
$db_name = "id284668_beadando";
$mysql_username = "projectX";
$mysql_password = "projectX";
$server_name = "localhost:3306";
$con = mysqli_connect($server_name, $mysql_username, $mysql_password ,$db_name);
 if($con){
	 
	 echo"Sikeres csatlakozás";
	 
 }
 else{
	 
	 echo"Sikertelen csatlakozás";
 }
?>