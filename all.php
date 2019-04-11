<?php


  $junctionName = $_GET["JuncName"];
  $absFilename1 = "/var/www/html/Project-EasyInfra/server-side/charts/".$junctionName."/standardDateTime.txt";
  $absFilename2 = "/var/www/html/Project-EasyInfra/server-side/charts/".$junctionName."/standardTraffic.txt";
  $file = fopen($absFilename1, "r");
  $file2 = fopen($absFilename2, "r");

  //no. of lines in the file
  $totalLines = intval(exec("wc -l '$absFilename1'"));

  //cols
  $col1=array();
  $col1["label"]="Date in seconds (00 - 86400)";
  $col1["type"]="number";

  $col2=array();
  $col2["label"]="Traffic Density (predicted)";
  $col2["type"]="number";

  $cols = array($col1,$col2);
  //cols end

  $rows = array();


  $i = 0;
  while(!feof($file) && !feof($file2)){
      $line = fgets($file);
      $line2 = fgets($file2);

      $cell0["v"]=(int)$line;
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
