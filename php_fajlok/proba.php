<?php
$host='127.0.0.1';
$username='beadando';
$pwd='F3cuska96';
$db="beadando";
$con=mysqli_connect($host,$username,$pwd,$db) or die('Unable to connect');
if(mysqli_connect_error($con))
{
  echo "Sikertelen csatlakozas ".mysqli_connect_error();
}
$name=$_POST['Query'];
$sql="Select * From gyerekek; ";
$query=mysqli_query($con,$sql);
if($query)
{
    while($row=mysqli_fetch_array($query))
  {
    $data[]=$row;
  }
    print(json_encode($data));
}else
{
  echo('Not Found ');
}
mysqli_close($con);
?>