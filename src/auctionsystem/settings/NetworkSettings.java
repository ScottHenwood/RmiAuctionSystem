/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package auctionsystem.settings;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The class should read form an XML file, and store the data for later use.
 * @author Scott Henwood
 */
public class NetworkSettings {
    private static final NetworkSettings nSettings;
    //*******************************************************************
    static 
    {
        nSettings = new NetworkSettings();
    }
    //*******************************************************************
    public static NetworkSettings getSettingsClass()
    {
        return nSettings;
    }
    //____________________________________________________________________
    private NetworkSettings() { }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public String getAddress() //throws UnknownHostException
    {
        return "127.0.0.1";
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public int getPortNumber()
    {
        return 1234;
    }
    //____________________________________________________________________
}
