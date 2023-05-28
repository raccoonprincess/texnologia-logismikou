import java.util.*;
import java.lang.*;
public class EShop{
    private String name;
    private Owner owner;
    private ArrayList<Item> itemsList = new ArrayList<Item>();
    private ArrayList<Buyer> buyersList = new ArrayList<Buyer>();
    private ArrayList<ShoppingCart> cartList = new ArrayList<ShoppingCart>();
    
    
    public EShop(String brand, Owner theowner)
    {
        name = brand;
        owner = theowner;
    }
    
    public void addItem(Item proion)
    {
        if(itemsList.contains(proion))
        {
             throw new IllegalArgumentException();
        }
        itemsList.add(proion);
    }
    public String getItemById(int idCode, Item pen1, Item pen2, Item pen3, 
    Item paper1, Item paper2, Item paper3, Item pencil1, Item pencil2, Item pencil3,
    Item notebook1, Item notebook2, Item notebook3)
    {
     
     Scanner idcode = new Scanner(System.in);
     System.out.println("Enter an item's ID:");
     int idcodes = idcode.nextInt();
     
     if(idcodes==11)
     {
       System.out.println(pen1.getBasicInfo());
     }
     else if(idcodes==12)
     {
       System.out.println(pen2.getBasicInfo());
     }
     else if(idcodes==13)
     {
       System.out.println(pen3.getBasicInfo());
     }
     else if(idcodes==21)
     {
       System.out.println(pencil1.getBasicInfo());
     }
     else if(idcodes==22)
     { 
       System.out.println(pencil2.getBasicInfo());
     }
     else if(idcodes==23)
     {
       System.out.println(pencil3.getBasicInfo());
     }
     else if(idcodes==31)
     {
       System.out.println(paper1.getBasicInfo());
     }
     else if(idcodes==32)
     { 
       System.out.println(paper2.getBasicInfo());
     }
     else if(idcodes==33)
     {
       System.out.println(paper3.getBasicInfo());
     }
     else if(idcodes==41)
     { 
       System.out.println(notebook1.getBasicInfo());
     }
     else if(idcodes==42)
     { 
       System.out.println(notebook2.getBasicInfo());
     }
     else if(idcodes==43)
     { 
       System.out.println(notebook3.getBasicInfo());
     }
     return "pls end my life";
     
        
      //int pos;
     // pos=itemsList.indexOf(idCode);
     //return itemsList.get(pos).getName();
    }
    public void removeItem(Item trash)
    {
      itemsList.remove(trash);
    }
    public void addBuyer(Buyer hibuyer)
    {
        buyersList.add(hibuyer);        
    }
    public void addCart(ShoppingCart hicart)
    {
        if (cartList.contains(hicart))
        {
            throw new IllegalArgumentException();
        }
        cartList.add(hicart);        
    }
    
    public void removeBuyer(Buyer byebuyer)
    {
        buyersList.remove(byebuyer);
    }
    public void removeCart(ShoppingCart byecart)
    {
        cartList.remove(byecart);
    }
    
    public void updateItemStock(Item moreItem, int newStock)
    {
        moreItem.setStock(newStock);
    }
    public void showCategories(int i)
    {
        System.out.print(Item.catlist.get(i));
    }
    public void showProductsInCategory(int vs)
    {
        int arlista=1;
        for(int kk=0; kk<itemsList.size(); kk++)
        {
            if(itemsList.get(kk).getID() /10 == vs)
            {
                System.out.println(arlista + ". "+itemsList.get(kk).getName());
                arlista++;
            }
        }
    }
    public void showProduct(Item prod)
    {
        System.out.println(prod.getBasicInfo()+"\n"+prod.getDetails());
    }
    public void checkStatus(Buyer theBuyer){
        System.out.println("Name: "+theBuyer.getUName()+"\nemail: "+theBuyer.getUemail()
        +"\nBonus: "+theBuyer.getBonus()+"\nCategory"+theBuyer.getLevel());
    }
    public String getEshopName()
    {
        return name;
    }
    public ArrayList<Buyer> getBuyersList(){
        return buyersList;
    }
    public ArrayList<Item> getItemsList(){
        return itemsList;
    }
}
