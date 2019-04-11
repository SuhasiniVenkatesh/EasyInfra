package easy.infra;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * Created by abhi on 21/2/16.
 */

/**
 * This class applies various filters to a captured snapshot and returns the filtered images
 * @author Abhilash.S
 * @version 1.0
 */
public class FilterSnap {
    private String folderPath = null;
    File currentFolder = null;
    String ext = ".png";

    /**
     * this constructs and initializes a new file (folder) with the given folderPath
     * @param folderPath the absolute path of the junction being operated on
     */
    public FilterSnap(String folderPath) {
        this.folderPath = folderPath;
        currentFolder = new File(folderPath);
    }

    /**
     * this method starts the process of applying filters on the captured snapshot
     */
    public void startFilter() {
        File[] listOfFiles = currentFolder.listFiles(new MyFileNameFilter(ext));
        //System.out.println(listOfFiles.length);
        if (listOfFiles.length == 0)
            System.out.println("No images to filter!");
        else {

            for (File x : listOfFiles) {
                Process p;
                //System.out.println("cd "+files+"; Filter " + x.getName());
                String cmd = "filter " + x.getParent() + "/ " + x.getName();
                //System.out.println(cmd);

                String[] command = {"/bin/sh", "-c", cmd};
                try {
                    p = Runtime.getRuntime().exec(command);
                    p.waitFor();
                } catch (IOException | InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }
    }

    /**
     * This class implements FilenameFilter interface
     */
    public static class MyFileNameFilter implements FilenameFilter {

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
