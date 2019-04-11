<html>
  <head>
    <?php
      $file = $_POST["fname"];
      $redFile = $_POST["Rfname"];
      // $greenFile = $_POST["Gfname"];
      // $yellowFile = $_POST["Yfname"];
      $junction = $_POST["JuncName"];
      $predictedFileName = $_POST["predictedFileName"];

    ?>
    <!--Load the AJAX API-->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.0/jquery.js"></script>
    <script type="text/javascript">
    var filename = '<?php echo $file ?>';
    var redFilename = '<?php echo $redFile ?>';
    // var greenFilename = '<?php echo $greenFile ?>';
    // var yellowFilename = '<?php echo $yellowFile ?>';
    var junctionName = '<?php echo $junction ?>';
    var predictedFileName = '<?php echo $predictedFileName ?>'

    // Load the Visualization API and the piechart package.
    google.charts.load('current', {'packages':['corechart']});

    // Set a callback to run when the Google Visualization API is loaded.
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {

      //options common for all charts
      var options = {
        'title': junctionName,
        'width':1200,
        'height':640,
        hAxis: {
          title: 'Time'
        },
        vAxis: {
          title: 'Traffic Density'
        },
        //colors: ['#AB0D06', '#007329'],
        //trendlines: {
          //0: {type: 'exponential', color: '#333', opacity: 1},
          //1: {type: 'linear', color: '#111', opacity: .3}
          //0: {type: 'polynomial', degree: 16, showR2: true,color: '#333', visibleInLegend:true}
        //}
      };

      // draw red chart
      var JsonData = $.ajax({
          url: "combine.php",
          dataType: "json",
          data:{name1:filename,name2:redFilename,name3:predictedFileName,JuncName:junctionName},
          async: false
          }).responseText;

      // Create our data table out of JSON data loaded from server.
      var Data = new google.visualization.DataTable(JsonData);

      // Instantiate and draw our chart, passing in some options.
      //var redChart = new google.visualization.ScatterChart(document.getElementById('red_chart'));
      var chart = new google.visualization.LineChart(document.getElementById('chart'));
      chart.draw(Data, options);

      //start predicted data chart
      //var predictedFileName = "2016-03-02-axatech-red-predicted.txt";
      // var predictedJsonData = $.ajax({
      //     url: "test.php",
      //     dataType: "json",
      //     data:{name1:filename,name2:predictedFileName,JuncName:junctionName},
      //     async: false
      //     }).responseText;
      //
      //     var predictedData = new google.visualization.DataTable(predictedJsonData);
      //
      //     //var predictedChart = new google.visualization.ScatterChart(document.getElementById('predicted_chart'));
      //     var predictedChart = new google.visualization.LineChart(document.getElementById('predicted_chart'));
      //     predictedChart.draw(predictedData, options);

      //end predicted data chart

      // //draw green chart
      // var greenJsonData = $.ajax({
      //     url: "test.php",
      //     dataType: "json",
      //     data:{name1:filename,name2:greenFilename},
      //     async: false
      //     }).responseText;
      //
      // // Create our data table out of JSON data loaded from server.
      // var greenData = new google.visualization.DataTable(greenJsonData);
      //
      // // Instantiate and draw our chart, passing in some options.
      // var greenChart = new google.visualization.ScatterChart(document.getElementById('green_chart'));
      // greenChart.draw(greenData, options);
      //
      // //draw yellow chart
      // var yellowJsonData = $.ajax({
      //     url: "test.php",
      //     dataType: "json",
      //     data:{name1:filename,name2:yellowFilename},
      //     async: false
      //     }).responseText;
      //
      // // Create our data table out of JSON data loaded from server.
      // var yellowData = new google.visualization.DataTable(yellowJsonData);
      //
      // // Instantiate and draw our chart, passing in some options.
      // var yellowChart = new google.visualization.ScatterChart(document.getElementById('yellow_chart'));
      // yellowChart.draw(yellowData, options);
    }

    </script>
  </head>

  <body>


    <!--Div that will hold the chart-->
    <div id="chart"></div>
    <!-- <div id="predicted_chart"></div> -->
    <!-- <div id="green_chart"></div>
    <div id="yellow_chart"></div> -->

  </body>
</html>
