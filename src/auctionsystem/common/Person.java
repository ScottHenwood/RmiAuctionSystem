package auctionsystem.common;

import java.io.Serializable;
import java.util.*;

/**
 * Warning, the use of this class includes moving it using RMI
 * Get hash is used for integrity constraints.
 * Person identifies a user, and is used for the purposes of account access 
 * control. Also stores a record of items listed and bided on.
 * @author Scott Henwood
 */
public class Person implements Serializable 
{
    private final String name;
    private final String accessCode;
    private final Set<String> bidRecord;
    private final Set<String> listRecord;
    //___________________________________________________________________      
    public Person(String personName, String password) {
        name = personName;
        accessCode = password;
        bidRecord = new HashSet();
        listRecord = new HashSet();
    }
    // ---------------------- Getters -----------------------------------
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++    
    public String getName()
    {
        return name;
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public String getPassword()
    {
        return accessCode;
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public String getHash() 
    {
        return name + accessCode;
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public String getNextItemId() 
    {
        return getHash() + listRecord.size();
    }
    // -------------------------- Actions -------------------------------
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void addToBidRecord(String itemId)
    {
        bidRecord.add(itemId);
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void addListItemRecord(String itemId)
    {
        listRecord.add(itemId);
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @Override
    public String toString()
    {
        return getName() + " " + getPassword();
    }
    //___________________________________________________________________ 
}