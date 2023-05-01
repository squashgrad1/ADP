package environment;

import java.nio.file.Path;

public class Environment {

    private Environment() {}

    // ".;C:\Users\Birgit Wendholt\Documents\HAW\vorlesungen\ad\algs4.jar"
    public static String pathToDataFile(String filename){
        String dataDir = System.getenv("algs4data");
        return Path.of(dataDir,filename).toString();
    }
}
