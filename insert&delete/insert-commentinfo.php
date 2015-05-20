<?php 
//没有返回但是可以添加
/*$json = file_get_contents('D:\AppServ\www\test.txt');//从这个文本本件中读取的jason格式的数据
$obj = json_decode($json);
$commentId=$obj->commentId;
$commentUserId=$obj->commentUserId;
$contentId=$obj->contentId;
$comment=$obj->comment;*/
$commentId = $_POST["commentId"];
$commentUserId = $_POST["commentUserId"];
$contentId = $_POST["contentId"];
$comment = $_POST["comment"];

$con = mysql_connect('localhost:3306','root','braveheart') or die('Cannot connect to the DB');
mysql_select_db('brain',$con);
mysql_query("INSERT INTO commentinfo (commentId,commentUserId, contentId,comment) 
VALUES ('$commentId','$commentUserId', '$contentId','$comment')");
mysql_close($con);

?>
