package auctionsystem.common;

import java.io.Serializable;
import java.util.*;

/**
 * An auction item, it has an ID to get around versioning issues with a 
 * distributed system. It keeps a record of all the bids made, 
 * and the winning bid. 
 * @author Scott Henwood
 */
public class Item implements Serializable 
{
    private String itemId;
    private final String itemName;
    private String category;
    private final float reserve;
    private Bid winningBid;
    private final List<Bid> bids;
    private final String sellerID;
    private int timeLeft;
    
    //____________________________________________________________________
    public Item(String pItemId, String pItemName, String pCategory, 
                                 String pSellerID, float pReserve)
    {
        itemId = pItemId;
        itemName = pItemName;
        category = pCategory; // if this is invalid throw.
        sellerID = pSellerID;
        reserve = pReserve;
        winningBid = null;
        bids = new ArrayList<Bid>();
        timeLeft = 10;
    }
    // ------------------ Setters ---------------------------------------
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void setCategory(String cat) { category = cat;   }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    boolean idSet = false;
    public void setItemId(String pItemId)
    {
        if(!idSet )
        {
            itemId = pItemId;
        }
    }
    // ------------------ Getters ---------------------------------------
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public String getId()               { return itemId;    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public String getName()             { return itemName;  }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public String getCategory()         { return category;  }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public String getResult()
    {
        return "Item: " + itemName + 
               "\n sold for: " + winningBid.toString();
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public float getCurrentBidValue() 
    {
        if(bids.isEmpty())
            return 0;
        else
            return bids.get(bids.size() - 1).getValue();
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public String getTimeLeft() 
    {
        if(timeLeft > 0) // say
            return timeLeft + " states";
        else
        {
            if(winningBid != null)
                return "Item sold for: $" + winningBid.getValue() + 
                       " to: " + winningBid.getBidderId();
            else
                return "Item closed without selling.";
        }
    }
    // ------------------ Aution controls -------------------------------
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public boolean placeBid(Bid bid)
    {
        if(bid.greaterThan(winningBid) && timeLeft > 0)
        {
            winningBid = bid; // add to bid array
            bids.add(bid);
            return true;
        }
        else
        {
            return false;
        }
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public boolean tick() 
    {
        if(timeLeft > 0)
        {
            timeLeft -= 1;
            return true;
        }
        else {
            return false;
        }   
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @Override
    public String toString()
    {
        return "Item: " + itemName + " top bid: " + getCurrentBidValue();
    } 
    //____________________________________________________________________
}
