<?php 
//没有返回但是可以添加
/*$json = file_get_contents('D:\AppServ\www\test.txt');//从这个文本本件中读取的jason格式的数据
$obj = json_decode($json);
$contentId=$obj->contentId;
$content=$obj->content;
$userId=$obj->userId;
$userful=$obj->userful;
$goodNum=$obj->goodNum;*/
$contentId = $_POST["contentId"];
$content = $_POST["content"];
$userId = $_POST["userId"];
$userful = $_POST["userful"];
$goodNum = $_POST["goodNum"];

$con = mysql_connect('localhost:3306','root','braveheart') or die('Cannot connect to the DB');
mysql_select_db('brain',$con);
mysql_query("INSERT INTO contentinfo (contentId,content,userId,userful,goodNum) 
VALUES ('$contentId','$content', '$userId','$userful','$goodNum')");
mysql_close($con);

?>
