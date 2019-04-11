package easy.infra;
import java.io.*;

/**
 * Created by abhi on 21/2/16.
 */

/**
 * This class returns the amount of color value in percent for a given filtered image
 * @author Abhilash.S
 * @version 1.0
 */
public class FetchPercent {
    private String folderPath = null;
    File currentFolder = null;
    String ext = ".png";
    static int redFileLength = 27,yellowFileLength = 29, greenFileLength = 30;
    String junctionName;
    String year;
    String month;
    String date;
    String hour;
    String minute;
    String second;

    Float pRed=null,pYellow=null,pGreen=null;

    /**
     * this method returns the name of the junction
     * @return the name of the junction as a string
     */
    public String getJunctionName() {
        return junctionName;
    }

    /**
     * this method returns the year of the snapshot
     * @return the year as a string
     */
    public String getYear() {
        return year;
    }

    /**
     * this method returns the month of the snapshot
     * @return the month as a string
     */
    public String getMonth() {
        return month;
    }

    /**
     * this method returns the date/day in a month of the snapshot
     * @return the date as a string
     */
    public String getDate() {
        return date;
    }

    /**
     * this method returns the hour in a day of the snapshot
     * @return the hour as a string
     */
    public String getHour() {
        return hour;
    }

    /**
     * this method returns the minute in an hour of the snapshot
     * @return the minute as a string
     */
    public String getMinute() {
        return minute;
    }

    /**
     * this method returns the second in a minute of the snapshot
     * @return the minute as a string
     */
    public String getSecond() {
        return second;
    }

    /**
     * this method returns the amount of red value in percent of the snapshot
     * @return the red value in percent as a float
     */
    public Float getpRed() {
        return pRed;
    }

    /**
     * this method returns the amount of yellow value in percent of the snapshot
     * @return the yellow value in percent as a float
     */
    public Float getpYellow() {
        return pYellow;
    }

    /**
     * this method returns the amount of green value in percent of the snapshot
     * @return the green value in percent as a float
     */
    public Float getpGreen() {
        return pGreen;
    }

    /**
     * this constructs and initializes a new file (folder) with the given folderPath
     * @param folderPath the absolute path of the junction being operated on
     */
    public FetchPercent(String folderPath) {
        this.folderPath = folderPath;
        currentFolder = new File(folderPath);
    }

    /**
     * This method computes the percent value of a color from a snapshot
     */
    public void getPercent() {

       // to calculate red percent
        File[] listOfRedFiles = currentFolder.listFiles(new MyFileNameFilter(ext,redFileLength));
        //System.out.println(listOfFiles.length);

        // to calculate/extract year,month,date,hour,minute,second
        for (File f:listOfRedFiles) {
            junctionName = f.getParentFile().getName();
            year = f.getName().substring(0,4);
            month = f.getName().substring(5,7);
            date = f.getName().substring(8,10);
            hour = f.getName().substring(11,13);
            minute = f.getName().substring(14,16);
            second = f.getName().substring(17,19);
        }

        if (listOfRedFiles.length == 0)
            System.out.println("No images to fetch percent from!");
        else {

            for (File x : listOfRedFiles) {
                Process red;
                //System.out.println("cd "+files+"; Filter " + x.getName());
                String cmd = "percent " + x;
                //System.out.println(cmd);

                String[] command = {"/bin/sh", "-c", cmd};
                try {
                    red = Runtime.getRuntime().exec(command);
                    red.waitFor();

                    // Grab output and print to display
		        BufferedReader reader = new BufferedReader(new InputStreamReader(red.getInputStream()));

		        String line = "";
		        while ((line = reader.readLine()) != null) {
                    pRed = Float.parseFloat(line);
		        }
                } catch (IOException | InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                //System.out.println(x);

            }
        }

        //to calculate yellow percent
        File[] listOfYellowFiles = currentFolder.listFiles(new MyFileNameFilter(ext,yellowFileLength));
        //System.out.println(listOfFiles.length);
        if (listOfYellowFiles.length == 0)
            System.out.println("No images to fetch percent from!");
        else {

            for (File x : listOfYellowFiles) {
                Process yellow;
                //System.out.println("cd "+files+"; Filter " + x.getName());
                String cmd = "percent " + x;
                //System.out.println(cmd);

                String[] command = {"/bin/sh", "-c", cmd};
                try {
                    yellow = Runtime.getRuntime().exec(command);
                    yellow.waitFor();

                    // Grab output and print to display
                    BufferedReader reader = new BufferedReader(new InputStreamReader(yellow.getInputStream()));

                    String line = "";
                    while ((line = reader.readLine()) != null) {
                        pYellow = Float.parseFloat(line);
                    }
                } catch (IOException | InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                //System.out.println(x);

            }
        }


        // to calculate green percent
        File[] listOfGreenFiles = currentFolder.listFiles(new MyFileNameFilter(ext,greenFileLength));
        //System.out.println(listOfFiles.length);
        if (listOfGreenFiles.length == 0)
            System.out.println("No images to fetch percent from!");
        else {

            for (File x : listOfGreenFiles) {
                Process green;
                //System.out.println("cd "+files+"; Filter " + x.getName());
                String cmd = "percent " + x;
                //System.out.println(cmd);

                String[] command = {"/bin/sh", "-c", cmd};
                try {
                    green = Runtime.getRuntime().exec(command);
                    green.waitFor();

                    // Grab output and print to display
                    BufferedReader reader = new BufferedReader(new InputStreamReader(green.getInputStream()));

                    String line = "";
                    while ((line = reader.readLine()) != null) {
                        pGreen = Float.parseFloat(line);
                    }
                } catch (IOException | InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                //System.out.println(x);

            }
        }

    }

    /**
     * This class implements FilenameFilter interface
     */
    public static class MyFileNameFilter implements FilenameFilter {

        private String ext;
        private int fileNameLength;

        /**
         * This constructs and initializes the extension and filename length to the filter
         * @param ext the extension upon which the files are filtered
         * @param fileNameLength the length of the filename upon which the files are filtered
         */
        public MyFileNameFilter(String ext,int fileNameLength){
            this.ext = ext.toLowerCase();
            this.fileNameLength = fileNameLength;
        }

        /**
         * This method is overridden from the FilenameFilter interface
         * @param dir the directory that contains files to which the filter has to be applied
         * @param name the name of the file
         * @return true if the length of filename is matched else false
         */
        @Override
        public boolean accept(File dir, String name) {
            //return name.toLowerCase().endsWith(ext);
            if (name.length() == fileNameLength)
                return true;
            else
                return false;
        }

    }
}
