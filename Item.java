import java.util.*;
abstract class Item
{
   protected String name;
   protected double price;
   protected String description;
   protected int stock;
   protected int id;
   public static ArrayList<String> catlist = new ArrayList<String>();
   public static ArrayList<Integer> numofitems = new ArrayList<Integer>();
   

   public String getBasicInfo(){
       return ("info of the item:\nname:"+name+"\nprice: "+ price +"euros\ndescriptiion: "
       +description+"\nstock: "+stock+"\nid: "+id);
   }
   
   abstract String getDetails();
   
   public String toString(){
       System.out.println(getBasicInfo());
       System.out.println(getDetails());
       return "0";
    }
    
    public void setStock(int st)
    {
        this.stock=st;
    }
    public int getStock()
    {
        return stock;
    }
    public double getPrice()
    {
        return price;
    }
    public int getID()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    
}
