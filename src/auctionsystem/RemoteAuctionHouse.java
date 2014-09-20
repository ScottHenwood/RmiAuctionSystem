package auctionsystem;

import auctionsystem.common.Item;
import auctionsystem.common.Person;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Interface for a remote auction system.
 * @author Scott Henwood
 */
public interface RemoteAuctionHouse extends Remote 
{
    Item view(String itemCode)                  throws RemoteException;
    void bid(String itemCode, float amount, Person bidder) 
                                                throws RemoteException;
    void listItem(Item item, Person lister)     throws RemoteException;
    
    public List<Item> search(String name)       throws RemoteException;
    public List<Item> searchByCat(String cat)   throws RemoteException;
    public boolean loginUser(Person user)       throws RemoteException;
}
