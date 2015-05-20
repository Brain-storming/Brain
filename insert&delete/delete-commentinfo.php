<?php 
//没有返回但是可以添加
$commentId = $_POST["commentId"];
$con = mysql_connect('localhost:3306','root','braveheart') or die('Cannot connect to the DB');
mysql_select_db('brain',$con);
mysql_query("delete from commentinfo where commentId='$commentId'");
mysql_close($con);

?>
