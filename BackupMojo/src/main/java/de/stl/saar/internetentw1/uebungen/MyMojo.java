package de.stl.saar.internetentw1.uebungen;


import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * Goal generates backup of src
 */
@Mojo( name = "backup" )
public class MyMojo
    extends AbstractMojo
{
    public void execute() {
        System.out.println("Das MOJO hat ausgelöst und dieser Output wurde generiert");
    }
}
