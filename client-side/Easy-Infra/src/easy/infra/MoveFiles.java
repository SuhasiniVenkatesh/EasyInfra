package easy.infra;
import java.io.*;
import java.io.FilenameFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * This class is used to move the snapshots to their destination based on the custom hierarchy designed
 * @author Abhilash.S
 * @version 1.0
 */
public class MoveFiles{

    private String folderPath = null;
    File currentFolder = null;

    /**
     * this constructs and initializes a new file (folder) with the given folderPath
     * @param folderPath the absolute path of the junction being operated on
     */
    public MoveFiles(String folderPath){
        this.folderPath = folderPath;
        currentFolder = new File(folderPath);
    }

    /**
     * this method is used to move the files to destination
     */
    public void move() {

        String ext = ".png";

            File[] listofFiles = currentFolder.listFiles(new MyFileNameFilter(ext));
            if(listofFiles.length == 0)
                System.out.println(currentFolder + " doesn't have any images to be moved!");
            else{

                for(File name:listofFiles){
                    String filename = name.getName();
                    String year = filename.substring(0,4);
                    String month = filename.substring(5,7);

                    String fullMonth = "";
                    String fullDate = filename.substring(8,10) + "-" + month + "-" + name.getParentFile().getName();
                    switch(month){
                        case "01":
                            fullMonth = "01-Jan";
                            break;
                        case "02":
                            fullMonth = "02-Feb";
                            break;
                        case "03":
                            fullMonth = "03-Mar";
                            break;
                        case "04":
                            fullMonth = "04-Apr";
                            break;
                        case "05":
                            fullMonth = "05-May";
                            break;
                        case "06":
                            fullMonth = "06-Jun";
                            break;
                        case "07":
                            fullMonth = "07-Jul";
                            break;
                        case "08":
                            fullMonth = "08-Aug";
                            break;
                        case "09":
                            fullMonth = "09-Sep";
                            break;
                        case "10":
                            fullMonth = "10-Oct";
                            break;
                        case "11":
                            fullMonth = "11-Nov";
                            break;
                        case "12":
                            fullMonth = "12-Dec";
                            break;
                    }

                    InputStream in = null;
                    OutputStream out = null;
                    try {

                        File newFile = new File(currentFolder + File.separator + year + File.separator + fullMonth + File.separator + fullDate + File.separator + name.getName());
                        in = new FileInputStream(name);

                        if(!newFile.getParentFile().exists()){
                            newFile.getParentFile().mkdirs();
                        }
                        if(!newFile.exists()){
                            newFile.createNewFile();
                        }
                        out = new FileOutputStream(newFile,false);
                        byte[] moveBuff = new byte[1024];
                        int bytesRead;
                        while ((bytesRead = in.read(moveBuff)) > 0) {
                            out.write(moveBuff, 0, bytesRead);
                        }
                        in.close();
                        out.close();
                        name.delete();


                    } catch (IOException e) {
                        e.printStackTrace();
                    }



                }
            }

        }


    /**
     * This class implements FilenameFilter interface
     * @implNote it implements FilenameFilter
     */
    class MyFileNameFilter implements FilenameFilter{

        private String ext;

        /**
         * This constructs and initializes a filter with the provided extension
         * @param ext the extension upon which the files are filtered
         */
        public MyFileNameFilter(String ext){
            this.ext = ext.toLowerCase();
        }

        /**
         * This method is overridden from the FilenameFilter interface
         * @param dir the directory that contains files to which the filter has to be applied
         * @param name the name of the file
         * @return true if the extension is matched else false
         */
        @Override
        public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(ext);
        }

    }
}