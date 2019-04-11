package easy.infra;
import java.io.File;

/**
 * Created by abhi on 7/4/16.
 */
public class Junction implements Constants
{
    String junctionName;
    String junctionPath;
    String[] junctionCommand = new String[3];
    String threadName;

    private String getWorkSpaceFolder()
    {
    	String userHome = System.getProperty( "user.home" );
    	String workSpaceFolder = userHome+File.separator+workspaceFolderName;
    	return workSpaceFolder;
    }

    public Junction(String junctionName)
    {
        junctionName = junctionName.toLowerCase();
        this.junctionName = junctionName;
        this.junctionPath = this.getWorkSpaceFolder() + File.separator + junctionName;
        this.junctionCommand[0] = "/bin/sh";
        this.junctionCommand[1] = "-c";
        this.junctionCommand[2] = "cd "+junctionPath+"; "+"phantomjs snapShot.js";
        this.threadName = junctionName + " - thread";
    }

    public String getJunctionName() {
        return junctionName;
    }

    public void setJunctionName(String junctionName) {
        this.junctionName = junctionName;
    }

    public String getJunctionPath() {
        return junctionPath;
    }

    public void setJunctionPath(String junctionPath) {
        this.junctionPath = junctionPath;
    }

    public String[] getJunctionCommand() {
        return junctionCommand;
    }

    public void setJunctionCommand(String[] junctionCommand) {
        this.junctionCommand = junctionCommand;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }
}
