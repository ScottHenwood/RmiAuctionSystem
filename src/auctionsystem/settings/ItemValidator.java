package auctionsystem.settings;

/**
 * Validates information in an item. At current only does categories.
 * This information should be in an XML file.
 * @author Scott Henwood
 */
public class ItemValidator {
    //*******************************************************
    private static ItemValidator validator;
    //*******************************************************
    static 
    {
        validator = new ItemValidator();
    }
    //*******************************************************
    public static ItemValidator getValidator() 
    {
        return validator;
    }
    //_______________________________________________________
    private ItemValidator() { }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public String[] getValidCategories()
    {
        String[] validCat = {"Car", "Hat"};
        return validCat;
    }
}
