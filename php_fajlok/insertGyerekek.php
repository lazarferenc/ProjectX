<?php 

if($_SERVER["REQUEST_METHOD"]=="POST"){
	require 'connect.php';
	createStudent();
}
function createStudent()
{
	global $con;
	$teljesNev = $_POST["TeljesNev"];
	$magatartas = $_POST["Magatartas"];
	$hangulat = $_POST["Hangulat"];
	$jelenlet = $_POST["Jelenlet"];
	
	$query = " Insert into gyerekek (TeljesNev,Magatartas,Hangulat,Jelenlet) values ('$teljesNev','$magatartas','$hangulat','$jelenlet');";
	mysqli_query($con, $query) or die (mysqli_error($con));
	mysqli_close($con);
	
}


?>