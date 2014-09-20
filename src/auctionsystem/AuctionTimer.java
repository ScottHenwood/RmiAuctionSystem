package auctionsystem;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.logging.*;

/**
 * Timer task which saves changes the auction's state (Makes each item 
 * get closer to closing), and saves the auctionRoom to a file.
 * @author Scott Henwood
 */
public class AuctionTimer extends TimerTask // only need to implement runnable
{
    //*******************Static file location******************************
    public static final String location = System.getProperty("user.dir") + 
                                          "\\Auction_Storage\\";
    private static final String FILE_NAME = "currentAuction.auctionObj";
    //*********************************************************************
    public static String getCurrentFileLocation()
    {
        return location + FILE_NAME;
    }
    //*********************************************************************
    private final AuctionRoom auction;
    //_____________________________________________________________________
    public AuctionTimer(AuctionRoom pAuction)
    {
        auction = pAuction;
        File f = new File(location);
        f.mkdir();
    }
    //+++++++++++++++++++ thread entry point +++++++++++++++++++++++++++++++
    @Override
    public void run() 
    {
        auction.stateChange();
        try 
        {
            storeAuctionRoom();
            createBackupCopy();
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(AuctionTimer.class.getName()).log(
                    Level.SEVERE, null, ex);
        } 
        catch (IOException ex) {
            Logger.getLogger(AuctionTimer.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }
    //------------------------- File storage ------------------------------
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    private void storeAuctionRoom() throws FileNotFoundException, 
                                           IOException
    {
        System.out.println("Task Started, created at dir: " + location);
        FileOutputStream fOut = new FileOutputStream(location + FILE_NAME);
        ObjectOutputStream oOut = new ObjectOutputStream(fOut);
        
        oOut.writeObject(auction);

        oOut.flush();
        fOut.close();
        System.out.println("File closed");
    }
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    private void createBackupCopy() throws IOException
    {
        File state = new File( location + "State_" + Calendar.getInstance(
                TimeZone.getDefault()).getTime().getTime() + ".auctionObj");
        state.createNewFile();

        Files.copy(new File(location + FILE_NAME).toPath(), 
                   state.toPath(), 
                   StandardCopyOption.REPLACE_EXISTING);
        System.out.println("File copied");
    }
    //______________________________________________________________________
}
