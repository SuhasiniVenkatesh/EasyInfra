<html>
  <head>
    <?php
      $Xfile = $_POST["xname"];
      $Yfile = $_POST["yname"];
      $junction = $_POST["JuncName"];
      $date = $_POST["date"];

    ?>
    <!--Load the AJAX API-->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.0/jquery.js"></script>
    <script type="text/javascript">
    var Xfilename = '<?php echo $Xfile ?>';
    var Yfilename = '<?php echo $Yfile ?>';
    var junctionName = '<?php echo $junction ?>';
    var chosenDate = '<?php echo $date ?>';

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
          title: 'Time in seconds (0 - 86399) for ' + chosenDate
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


      //start predicted data chart
      var predictedJsonData = $.ajax({
          url: "test.php",
          dataType: "json",
          data:{name1:Xfilename,name2:Yfilename,JuncName:junctionName},
          async: false
          }).responseText;

          var predictedData = new google.visualization.DataTable(predictedJsonData);

          //var predictedChart = new google.visualization.ScatterChart(document.getElementById('predicted_chart'));
          var predictedChart = new google.visualization.LineChart(document.getElementById('predicted_chart'));
          predictedChart.draw(predictedData, options);

      //end predicted data chart


    }

    </script>
  </head>

  <body>


    <!--Div that will hold the chart-->
    <div id="predicted_chart"></div>


  </body>
</html>
