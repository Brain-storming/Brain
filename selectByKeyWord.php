<?php 
$selectinfo = $_POST["selectinfo"];
//$json = file_get_contents('D:\AppServ\www\test.txt'); 
//$obj = json_decode($json);
//$selectinfo = $obj->selectinfo;



$con = mysql_connect('localhost:3306','root','braveheart') or die('Cannot connect to the DB');
mysql_select_db('brain',$con);
$result=mysql_query("select * from contentinfo where content like '%$selectinfo%'");
//$result=mysql_query("select * from contentinfo where content = '$selectinfo'");
//$row = mysql_fetch_array($result);

//echo $row['count(*)'];
//if($row['count(*)'] == 1){
//$json = json_encode(array('code' => $row['count(*)'],'contentId' => $row['contentId'],'content' => $row['content'],'userId' => $row['userId'],'useful' => $row['useful'],'goodNum' => $row['goodNum']));
//}else{
//  $json = json_encode(array('code' => 0));
//}
$results = array();
while($row = mysql_fetch_assoc($result)){
$results[]=$row;
}
echo json_encode($results);
mysql_free_result($result);


//返回json
//echo $json;
mysql_close($con);

?>