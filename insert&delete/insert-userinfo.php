<?php 
//没有返回但是可以添加
/*$json = file_get_contents('D:\AppServ\www\test.txt');//从这个文本本件中读取的jason格式的数据
$obj = json_decode($json);
$userId=$obj->userId;
$userName=$obj->userName;
$pass=$obj->pass;
$userEmail=$obj->userEmail;
$userSex=$obj->userSex;
$userTel=$obj->userTel;
$level=$obj->level;
$exp=$obj->exp;*/
$userId = $_POST["userId"];
$userName = $_POST["userName"];
$pass = $_POST["pass"];
$userEmail = $_POST["userEmail"];
$userSex = $_POST["userSex"];
$userTel = $_POST["userTel"];
$level = $_POST["level"];
$exp = $_POST["exp"];
$con = mysql_connect('localhost:3306','root','braveheart') or die('Cannot connect to the DB');
mysql_select_db('brain',$con);
mysql_query("INSERT INTO userinfo (userId,userName, pass,userEmail,userSex,userTel,level,exp) 
VALUES ('$userId','$userName', '$pass','$userEmail','$userSex','$userTel','$level','$exp')");
mysql_close($con);

?>
