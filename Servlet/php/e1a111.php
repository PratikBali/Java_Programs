<?php
$s=$_POST['t'];
$db=mysql_connect("192.168.0.254","ty54018","") or die(mysql_error());
mysql_select_db("testty54018,$db) or die(mysql_error());
echo "<table border=2> <td>Maximum Salary</td> <td>Minimun Salary</td> <td>Sum Salary</td>";
 $rs =mysql_query("SELECT max(salary),min(salary),sum(salary) FROM emp,dept WHERE d_name='$s'");// or die(mysql_error());

 while($ro=mysql_fetch_array($rs))
             {  echo "<tr><td>".$ro['max(salary)']."</td><td>".$ro['min(salary)']."</td><td>".$ro['sum(salary)']."</td></tr>";
               }

//echo $rs;
echo"<font size=5>";
                  echo"
                      <a href=e1a11.html> BACK </a>";

?>

</pre>
