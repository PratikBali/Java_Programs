<pre>
<?php
echo "<body bgcolor=gold>";
echo "<font size=8 >";
$no=$_POST["n"];
$nem=$_POST["nm"];
$cl=$_POST["ad"];
$op=$_POST["p"];
$sl=$_POST["s"];

$db=mysql_connect("192.168.0.254","ty54018","") or die(mysql_error());
mysql_select_db("testty54018",$db) or die(mysql_error());

mysql_query("INSERT INTO emp VALUES($no,'$nem','$cl',$op,$sl)") or die(mysql_error());
echo"Values Inserted into table<br>";
echo"<font size=5>";
                  echo"
                      <a href=e1a1.html> BACK </a>";

?>
</pre>

