<?php
//echo date("Y-m-d");

//$date=date_create("2016-03-15");
//echo date_format($date,"Y-m-d");

// $date=date_create("2016-01-01");
// date_add($date,date_interval_create_from_date_string("1 minutes"));
// echo date_format($date,"Y-m-d H:i:s");

$filename = "2016-10-04.txt";

$dates = array();
$date = date_create(substr($filename,0,10));
// date_add($date,date_interval_create_from_date_string("1 minutes"));
// $finalDate =  date_format($date,"Y-m-d H:i:s");
$dates[0] = date_format($date,"Y-m-d H:i:s");
//$finalDate = date_add($date,date_interval_create_from_date_string("1 minutes"));
//$i=1;
//while ($i < 1440) {
  //$dat=$dates[$i-1];
  print_r($dat);
  date_add($dat,date_interval_create_from_date_string("1 minutes"));
  //print_r($dat);
  echo date_format($dat,"Y-m-d H:i:s");
  //$i = $i + 1;
//}

//print_r($dates);

 ?>
