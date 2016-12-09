<?php 

if($_SERVER["REQUEST_METHOD"]=="POST"){
	include 'connect.php';
	selectEtkezes();
}
function selectEtkezes()
{
	global $con;
	$query = "Select * From etkezes; ";
	$result = mysqli_query($con,$query);
	$number_of_rows = mysqli_num_rows($result);
	$temp_array = array();
	
	if($number_of_rows > 0) {
		while($row = mysqli_fetch_assoc($result)){
			$temp_array[] = $row;
			
		}
	}
	header('Content-Type: application/json;');
	echo json_encode(array("etkezes"=>$temp_array));
	mysqli_close($con);
	
}


?>