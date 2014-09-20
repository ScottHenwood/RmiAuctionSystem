package auctionsystem;

import auctionsystem.common.*;
import auctionsystem.settings.NetworkSettings;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.*;

/**
 * Auction server, for RMI. Implements the remoteAuctionHouse.
 * @author Scott Henwood
 */
class AuctionHouseImpl extends java.rmi.server.UnicastRemoteObject 
                       implements RemoteAuctionHouse 
{
    //*********************************************************************
    public static void main(String[] args) 
    { 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                startup();
            }
        }); 
    }
    //*********************************************************************
    public static void startup()
    {
        try 
        {
            AuctionHouseImpl auctionHouse = new AuctionHouseImpl(
                    NetworkSettings.getSettingsClass().getPortNumber());  
        } 
        catch (RemoteException ex) {
            Logger.getLogger(AuctionHouseImpl.class.getName()).log(
                    Level.SEVERE, null, ex);
        } 
    }
    //*********************************************************************
    private final AuctionRoom auction;
    private Registry registry;   // registry used to lookup class remotely.    
    private final String address;	 // address of local machine. 
    private final ScheduledThreadPoolExecutor scheduler;
    //_____________________________________________________________________
    public AuctionHouseImpl(int port) throws RemoteException
    {
        auction = AuctionRoom.getStoredAuction(
                  AuctionTimer.getCurrentFileLocation());
        
        scheduler = new ScheduledThreadPoolExecutor(10);
        scheduler.scheduleAtFixedRate(new AuctionTimer(auction), 
                                      5, 30, TimeUnit.SECONDS);
        
        address = NetworkSettings.getSettingsClass().getAddress();
        System.out.println("Address:"+address+", Port:"+port);	
        
        try{
            registry = LocateRegistry.createRegistry(port);
            registry.rebind("AuctionHouse", this);   //add CalcServer   
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                stopServer();
            }
        });
        } catch(RemoteException e){
            throw e;
        }
    }
    
    private void stopServer()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("press q and then enter to stop server.");
        String exit = s.next();
        while(!exit.contains("q")) 
        {
            exit = s.next();
        }
        try {
            registry.unbind("AuctionHouse");
            System.out.println("server has stopped.");
            System.exit(0);
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(AuctionHouseImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @Override
    public Item view(String itemCode) throws RemoteException {
        System.out.println("Auction house has given the item for viewing: " 
                        +  itemCode);
        return auction.view(itemCode);
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @Override
    public List<Item> search(String c) throws RemoteException {
        return auction.search(c);
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @Override
    public List<Item> searchByCat(String cat) throws RemoteException {
        return auction.searchByCat(cat);
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @Override
    public boolean loginUser(Person user) throws RemoteException 
    {
        if(!auction.loginUser(user)) {
            auction.createUser(user); // could ask the user.
        }
        return true;
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @Override
    public void bid(String itemCode, float amount, Person bidder) 
                    throws RemoteException 
    {
        if(bidder == null)
        {
            System.out.println("User not logged in.");
            return;
        }
        auction.bid(itemCode, amount, bidder);
        System.out.println("Auction house Bid has been placed on item: " + 
                           itemCode + " with a value of: " + amount );
    } 
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @Override
    public void listItem(Item item, Person lister) throws RemoteException {
        if(lister == null)
        {
            System.out.println("User not logged in.");
            return;
        }
        auction.listItem(item, lister);
    }
    //_____________________________________________________________________
}