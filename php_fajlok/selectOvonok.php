<?php 

if($_SERVER["REQUEST_METHOD"]=="POST"){
	include 'connect.php';
	selectOvonok();
}
function selectOvonok()
{
	global $con;
	$query = "Select * From ovonok; ";
	$result = mysqli_query($con,$query);
	$number_of_rows = mysqli_num_rows($result);
	$temp_array = array();
	
	if($number_of_rows > 0) {
		while($row = mysqli_fetch_assoc($result)){
			$temp_array[] = $row;
			
		}
	}
	header('Content-Type: application/json;');
	echo json_encode(array("ovonok"=>$temp_array));
	mysqli_close($con);
	
}


?>