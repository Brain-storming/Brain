<?php 
//没有返回但是可以添加
$contentId = $_POST["contentId"];
$con = mysql_connect('localhost:3306','root','braveheart') or die('Cannot connect to the DB');
mysql_select_db('brain',$con);
mysql_query("delete from contentinfo where contentId='$contentId'");
mysql_close($con);

?>
