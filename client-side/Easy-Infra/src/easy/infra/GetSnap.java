package easy.infra;

/**
 * @author Abhilash.S
 * @version 1.0
 */
public class GetSnap implements Runnable {

    private Thread t;
    private String threadName;
    private String[] command;
    String folderPath = null;

    String junctionName;
    String year;
    String month;
    String date;
    String hour;
    String minute;
    String second;
    String millisecond = "00";
    String tableName;
    Float pRed,pYellow,pGreen;

    /**
     * This initializes a thread with the given name, cmd and folderPath
     * @param name the name of the thread to be created
     * @param cmd a string array of command's to be executed by this thread
     * @param folderPath the absolute path of the junction for which the thread is being created
     */
    public GetSnap(String name, String[] cmd,String folderPath){
        threadName = name;
        command = cmd;
        this.folderPath = folderPath;
    }

    /**
     * this method is overridden and it consists of all the tasks that this thread must execute
     */
    @Override
    public void run() {
        //System.out.println("Running " + threadName);



        try{

            while(true){
                Process p = Runtime.getRuntime().exec(command);
                p.waitFor();

                Thread.sleep(6000);
                //count++;
                //System.out.println(threadName +" : "+count);
                FilterSnap filterSnap = new FilterSnap(folderPath);
                filterSnap.startFilter();

                Thread.sleep(4000);

                FetchPercent fetchPercent = new FetchPercent(folderPath);
                fetchPercent.getPercent();
                junctionName = fetchPercent.getJunctionName();
                year = fetchPercent.getYear();
                month = fetchPercent.getMonth();
                date = fetchPercent.getDate();
                hour = fetchPercent.getHour();
                minute = fetchPercent.getMinute();
                second = fetchPercent.getSecond();
                pRed = fetchPercent.getpRed();
                pYellow = fetchPercent.getpYellow();
                pGreen = fetchPercent.getpGreen();
                //System.out.println(junctionName +" "+ year +" "+ month +" "+ date +" "+ hour +" "+ minute +" "+ second +" "+ pRed +" "+ pYellow +" "+ pGreen);
                Thread.sleep(4000);

                CreateDBObject dbObject = new CreateDBObject(junctionName,year,month,date,hour,minute,second,pRed,pYellow,pGreen);

                Thread.sleep(2000);

                AddToDB row = new AddToDB();
                row.insert(dbObject);

                Thread.sleep(8000);

                MoveFiles ob = new MoveFiles(folderPath);
                ob.move();

                Thread.sleep(3000);

                PrintData data = new PrintData();
                //System.out.println("axatech");
                data.print("axatech");
                //System.out.println("hosur-road");
                data.print("hosur-road");
                //System.out.println("hosur-road-2");
                data.print("hosur-road-2");
                //System.out.println("ring-road");
                data.print("ring-road");
                //System.out.println("silkboard");
                data.print("silkboard");

                Thread.sleep(13000);


            }

        }catch(Exception e){
            System.out.println(e);
        }

        //System.out.println("Exiting " + threadName);

    }

    /**
     * This method is used to create and start a new thread with the given name
     */
    public void start(){
        //System.out.println("Creating " + threadName);

        if(t==null){
            t = new Thread(this,threadName);
            t.start();
        }
    }

}
