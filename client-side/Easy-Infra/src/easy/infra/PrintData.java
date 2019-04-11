package easy.infra;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhi on 25/2/16.
 */

/**
 * This class is used to print the DB objects to the console
 * @author Abhilash.S
 * @version 1.0
 */
public class PrintData {
    String junctionName;
    String serverFolderAddress = "/var/www/html/Project-EasyInfra/server-side/charts/";
    //File serverFolder = new File("/var/www/html/charts"+File.separator+junctionName);
    /**
     * This method is used to print the DB objects that matched the query for the given junction name
     * @param junctionName  the name of the junction as a string
     */
    public void print(String junctionName) {
        this.junctionName = junctionName;
        List<CreateDBObject> objects = new ArrayList<CreateDBObject>();

        GetData data = new GetData(junctionName);
        objects = data.fetchData();
        LocalDate currentDate = LocalDate.now();
        //System.out.println(currentDate);
        //String textFile = currentDate.toString()+junctionName;
        //System.out.println(textFile);

        File X = new File(serverFolderAddress+File.separator+junctionName+File.separator+currentDate.toString()+".txt");
        //System.out.println(nameFile);
        File Y = new File(serverFolderAddress+File.separator+junctionName+File.separator+currentDate.toString()+"-"+junctionName+"-"+"red.txt");
        //System.out.println(Y);
        if(!X.exists()){
            try {
                X.createNewFile();
                clearFile(X);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else
            clearFile(X);

        if(!Y.exists()){
            try {
                Y.createNewFile();
                clearFile(Y);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else
            clearFile(Y);

        for (CreateDBObject object : objects) {
            //System.out.println(object.getYear()+", "+object.getMonth()+", "+object.getDate()+", "+object.getHour()+", "+object.getMinute()+", "+object.getSecond()+", "+object.getMillisecond()+", "+object.getpRed()+", "+object.getpYellow()+", "+object.getpGreen());
            //LocalDate date = LocalDate.of(Integer.parseInt(object.getYear()),Integer.parseInt(object.getMonth()),Integer.parseInt(object.getDate()));
            //System.out.println(date);
            BufferedWriter Xout = null,Yout=null;

            if ((currentDate.getDayOfMonth()==Integer.parseInt(object.getDate())) && (currentDate.getMonthValue()==Integer.parseInt(object.getMonth())) && (currentDate.getYear()==Integer.parseInt(object.getYear())) ){
                try {
                    Xout = new BufferedWriter(new FileWriter(X,true));
                    Xout.write(object.getYear()+"-"+object.getMonth()+"-"+object.getDate()+"_"+object.getHour()+":"+object.getMinute()+":"+object.getSecond());
                    Xout.newLine();

                    Yout = new BufferedWriter(new FileWriter(Y,true));
                    Yout.write(object.getpRed().toString());
                    Yout.newLine();

                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if (Xout != null) {
                        try {
                            Xout.flush();
                            Xout.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    if (Yout != null) {
                        try {
                            Yout.flush();
                            Yout.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }

    public void clearFile(File file){
        PrintWriter clear = null;
        try {
            clear = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        clear.print("");
        clear.close();
    }


}
