package de.stl.saar.internetentw1.uebungen;


import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.codehaus.plexus.util.FileUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * Goal generates backup of src
 */
@Mojo( name = "backup" )
public class MyMojo
    extends AbstractMojo
{

    @Parameter( property = "user", defaultValue = "none")
    private String user;

    @Parameter( property = "dir", defaultValue = "none" )
    private String dir;

    public void execute() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        if ( user.matches("none") ) {
            user = System.getProperty("user.name");
        }
        String name = "backup_" + user + "_" + formatter.format(date);

        if ( dir.matches( "none" ) ) {
            dir = System.getProperty("user.dir");
        }

        File target = new File (dir + "/backup/" + name);
        File source = new File (dir + "/src");

        try {
            FileUtils.copyDirectory(source,target);
        } catch (java.io.IOException e) {
            System.out.println("Could not create backup");
        }
    }
}
