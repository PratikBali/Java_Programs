<pre>
<?php
echo "<body bgcolor=gold>";
echo "<font size=8 >";
$no=$_POST["n"];
$nem=$_POST["nm"];
$cl=$_POST["ad"];
$op=$_POST["s"];


$db=mysql_connect("192.168.0.254","ty54018","") or die(mysql_error());
mysql_select_db("testty54018",$db) or die(mysql_error());
/*echo "<table border=2> <td>Maximum Salary</td> <td>Minimun Salary</td> <td>Sum Salary</td>";*/

mysql_query("INSERT INTO dept VALUES($no,'$nem','$cl',$op)") or die(mysql_error());
echo"Values Inserted into table<br>";
echo"<font size=5>";
                  echo"
                      <a href=e1a11.html> BACK </a>";

?>

</pre>

