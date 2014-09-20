package auctionsystem;

import auctionsystem.common.*;
import auctionsystem.settings.ItemValidator;
import java.io.*;
import java.util.*;
import java.util.logging.*;

/**
 * Room where the items are indexed and stored, and where bids are placed.
 * @author Scott Henwood
 */
public class AuctionRoom  implements Serializable 
{ 
    /*********************************************************************
     * tries to read the auction object from the file supplied. 
     * If is fails, will create a new auction room.
     */
    static AuctionRoom getStoredAuction(String currentFileLocation) 
    {
        FileInputStream fIn;
        ObjectInputStream oIn;
        AuctionRoom auction = null;
        try 
        {
            System.out.println("Task Started reading at dir: " + currentFileLocation);
            File inFile = new File(currentFileLocation);
            if(inFile.exists())
            {
                fIn = new FileInputStream(currentFileLocation);
                oIn = new ObjectInputStream(fIn);
                System.out.println("Streams created");
                auction = (AuctionRoom) oIn.readObject();
                fIn.close();
                System.out.println("File Read");
            }
            else
            {
                auction = new AuctionRoom();
            }
        } catch (InvalidClassException ex) {
            auction = new AuctionRoom();
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(AuctionRoom.class.getName()).log(
                    Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AuctionTimer.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        return auction;
    }
    //*********************************************************************
    // ------------- Indexed storage -------------
    private final HashMap<String, Item> itemMap;
    private final HashMap<String, Person> userMap;
    private final HashMap<String, List<Item>> catMap;
    // -------------------------------------------
    //_____________________________________________________________________
    public AuctionRoom()
    {
        itemMap = new HashMap();
        catMap = new HashMap();
        userMap = new HashMap();
        setupCatMap();
        setTestUser();
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public Item view(String itemCode) { return itemMap.get(itemCode); }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public List<Item> search(String c) {
        List<Item> items = new ArrayList<Item>();
        for(String key : itemMap.keySet())
        {
            if(itemMap.get(key).getName().contains(c))
            {
                items.add(itemMap.get(key));
            }
        }
        return items;
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public List<Item> searchByCat(String cat) 
    {
        List<Item> items = new ArrayList<Item>();
        for(String key : itemMap.keySet())
        {
            if(itemMap.get(key).getCategory().equals(cat))
            {
                items.add(itemMap.get(key));
            }
        }
        return catMap.get(cat);
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void createUser(Person user) { 
        userMap.put(user.getHash(), user);
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public boolean loginUser(Person user) {
        return userMap.containsKey(user.getHash());
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void bid(String itemCode, float amount, Person bidder) 
    {
        Item item = itemMap.get(itemCode);
        Bid bid = new Bid(bidder.getHash(), amount);
        item.placeBid(bid);
        bidder.addToBidRecord(itemCode);
    } 
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void listItem(Item item, Person lister) 
    {
        Person p = userMap.get(lister.getHash());
        item.setItemId(p.getNextItemId());
        p.addListItemRecord(item.getId()); // also set ID
        
        itemMap.put(item.getId(), item);
        catMap.get(item.getCategory()).add(item);
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void stateChange()
    {
        for(Item item : itemMap.values())
        {
            item.tick();
        }
    }
    //----------------------- Object setup methods -----------------------
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    private void setupCatMap()
    {
        for(String cat : ItemValidator.getValidator().getValidCategories())
        {
            catMap.put(cat, new ArrayList<Item>());
        }
    }
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    private void setTestUser() {
        Person p = new Person("TestUser", "pass");
        createUser(p);
        Item item = new Item("AA11", "Red Car", "Car", p.getHash(), 5);
        listItem(item, p);
        item = new Item("AA12", "Blue Car", "Car", p.getHash(), 10);
        listItem(item, p);
    }
    //____________________________________________________________________
}