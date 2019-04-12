<?php

  $filename1 = $_GET["name1"];
  $filename2 = $_GET["name2"];
  $junctionName = $_GET["JuncName"];
  $absFilename1 = "/var/www/html/Project-EasyInfra/server-side/charts/".$junctionName."/".$filename1;
  $absFilename2 = "/var/www/html/Project-EasyInfra/server-side/charts/".$junctionName."/".$filename2;
  $file = fopen($absFilename1, "r");
  $file2 = fopen($absFilename2, "r");
  // $file = fopen($filename1, "r");
  // $file2 = fopen($filename2, "r");
  // console.log($file);
  // echo $file;
  // echo "\n";
  // echo $file2;
  //no. of lines in the file
  $totalLines = intval(exec("wc -l '$absFilename1'"));

  //cols
  $col1=array();
  $col1["label"]="Date";
  $col1["type"]="datetime";

  $col2=array();
  $col2["label"]="Traffic Density";
  $col2["type"]="number";

  $cols = array($col1,$col2);
  //cols end

  $rows = array();


  $i = 0;
  while(!feof($file) && !feof($file2)){
      $line = fgets($file);
      $line2 = fgets($file2);
      //echo "$line"."\t"."$line2"."\n";

      $year = substr($line,0,4);
      $month = substr($line,5,2);
      $day = substr($line,8,2);
      $hour = substr($line,11,2);
      $min = substr($line,14,2);
      $sec = substr($line,17,2);
      $temp = (int)$month - 1;
      $adjustedMonth = (string)$temp;

      $formedDate = "Date(".$year.",".$adjustedMonth.",".$day.",".$hour.",".$min.",".$sec.",00)";
      //echo "$formedDate"."\n";
      $cell0["v"]="$formedDate";
      //print_r($cell0);
      $cell1["v"]=(float)$line2;
      //print_r($cell1);
      //$row = "row".$i;
      //print_r($row);
      $row["c"]=array($cell0,$cell1);
      //print_r($row);
      if($i!=$totalLines)
        array_push($rows,$row);

      $i = $i + 1;

  }

  fclose($file);
  fclose($file2);

  $data=array("cols"=>$cols,"rows"=>$rows);
  //print_r($data);
  // $myfile = fopen("solution.txt", "w") or die("Unable to open file!");
  // fwrite($myfile,json_encode($data));
  // fclose($myfile);
  echo json_encode($data);

?>
