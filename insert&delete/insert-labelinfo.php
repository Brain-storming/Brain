<?php 
//没有返回但是可以添加
/*$json = file_get_contents('D:\AppServ\www\test.txt');//从这个文本本件中读取的jason格式的数据
$obj = json_decode($json);
$contentId=$obj->contentId;
$label=$obj->label;*/
$contentId = $_POST["contentId"];
$label = $_POST["label"];

$con = mysql_connect('localhost:3306','root','braveheart') or die('Cannot connect to the DB');
mysql_select_db('brain',$con);
mysql_query("INSERT INTO labelinfo (contentId,label) 
VALUES ('$contentId','$label')");
mysql_close($con);

?>
