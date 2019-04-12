<?php
$file = argv[1];

//Get number of lines
$totalLines = intval(exec("wc -l '$file'"));
echo "$totalLines";
 ?>
