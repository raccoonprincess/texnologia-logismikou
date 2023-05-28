import java.io.*; 
import java.util.*;

public class ShoppingCart               //extends Buyer??????????
{   
    
    private static ArrayList<ArtworkOrdered> OrderList = new ArrayList<ArtworkOrdered>();
    private static int i, posa;
    private static double total;
    private static boolean orderFinished;

    public ShoppingCart()
    {
        //ShoppingCart.posa=plithos;
        //ShoppingCart.total=sinolo;
        orderFinished=false;
    }  
    public void addArtworkOrdered(Artwork ant, int posa)
    {
      int akyro;
      try
      {
          if(posa > ant.getStock()) akyro=5/0;
          ant.setStock(ant.getStock()+posa);
          if(OrderList.contains(ant))
          {
              for(i=0; i<OrderList.size(); i++)
              {
                  if(ant==OrderList.get(i).getItem())
                  break;
              }
                  OrderList.get(i).setQuantity(OrderList.get(i).getQuantity()+posa);
          }else{
              ArtworkOrdered itemObj = new ArtworkOrdered(ant, posa);
              OrderList.add(itemObj);
          }
        
          Menu.nonstock=false;
          //System.out.println("\nThe item is added to the cart.\n");
      }
      catch(ArithmeticException e)
      {
          System.out.println("There are not enough items in stock. Try again.");
      }
      
      //OrderList.get(OrderList.indexOf(ant)).setQuantity(itemObj.getQuantity()+posa);
    
    }
    public void updateArtworkStock(int stokk, Artwork itemaki)
    {
        itemaki.setStock(itemaki.getStock()+stokk);
    }
    public void showCart()
    {
        System.out.println("Artwork\tQuantity\tPrice\tTotal\tCourier Cost");
        for(i=0; i<OrderList.size(); i++){
           System.out.println(i+1 +". " +OrderList.get(i).getArtwork().getName()+"\t"+OrderList.get(i).getQuantity()+"\t\t"+OrderList.get(i).getArtwork().getPrice());
        }
    }
    public void checkout()
    {
        showCart();
        System.out.println("Proceed to payment?");
        Scanner inp = new Scanner(System.in);
        char ans = inp.next().charAt(0);
        
        if(ans=='y')
        {
            OrderList.clear();
        }else Menu.nonstock=true;
    }
    public ArrayList<ArtworkOrdered> getOrderList()
    {
        return OrderList;
    }
    
    
}
