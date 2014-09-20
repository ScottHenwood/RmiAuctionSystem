package auctionsystem.common;

import java.io.Serializable;
import java.util.*;

/**
 * A bid that is made on an item. It has a value, who placed it and when it 
 * was placed.
 * @author Scott Henwood
 */
public class Bid implements Serializable 
{
    private final float value;
    private final Date datePlaced;
    private final String bidderID;
    //___________________________________________________________________
    public Bid(String bidderId, float amount)
    {
        bidderID = bidderId;
        value = amount;
        datePlaced = Calendar.getInstance(TimeZone.getDefault()).getTime();
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public String getBidderId() { return bidderID;  }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public float getValue()            { return value;     }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public boolean greaterThan(Bid winningBid) 
    {
        if (winningBid == null)
            return true;
        else if (this.value > winningBid.value)
            return true;
        else return false;
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @Override
    public String toString()
    {
        return "Bid Value: " + value + " placed by " + bidderID;
    }
    //___________________________________________________________________
}
