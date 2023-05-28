import java.io.*; 
import java.util.*;

public class ShoppingCart               //extends Buyer??????????
{   
    // με μικρό το orderList!!
    
    private static ArrayList<ItemOrdered> OrderList = new ArrayList<ItemOrdered>();
    private static int i, posa;
    private static double total;
    private static boolean orderFinished;

    public ShoppingCart()
    {
        // na valoume kai orderlist????
        // mallon ta total kai posa orizontai alliws pio meta...
        //ShoppingCart.posa=plithos;
        //ShoppingCart.total=sinolo;
        orderFinished=false;
        //to false na mpei sthn arxi, sto decraration ths variable!
        //ShoppingCart.buyer=who;
    }  
    public void addItemOrdered(Item ant, int posa)
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
              ItemOrdered itemObj = new ItemOrdered(ant, posa);
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
    
    public void removeItemOrdered(int thesi)
    {
        OrderList.remove(thesi);
        //xrhsh push?
        //παει αρνητικα?
        OrderList.get(thesi).getQuantity();
        OrderList.get(thesi).getItem().setStock(OrderList.get(thesi).getItem().getStock()+ OrderList.get(thesi).getQuantity());
    }
    public void changeItemOrderedQuantity(int w, int q)
    {
        OrderList.get(w).setQuantity(q);
        OrderList.get(w).getItem().setStock(OrderList.get(w).getItem().getStock()+ OrderList.get(w).getQuantity());
        //updateitemstock!!!
    }
    public void updateItemStock(int stokk, Item itemaki)
    {
        itemaki.setStock(itemaki.getStock()+stokk);
    }
    public void showCart()
    {
        System.out.println("Item\tQuantity\tPrice\tTotal\tCourier Cost");
        for(i=0; i<OrderList.size(); i++){
           System.out.println(i+1 +". " +OrderList.get(i).getItem().getName()+"\t"+OrderList.get(i).getQuantity()+"\t\t"+OrderList.get(i).getItem().getPrice()+"\t"+calculateNet()+"\t"+calculateCourierCost());
           //poianou periexomena emfanizei????
           
        }
    }
    public void clearCart()
    {
        while(OrderList.size()>0){
            removeItemOrdered(OrderList.size());
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
            Buyer.awardBonus(calculateNet() * 0.1);
            OrderList.clear();
            Buyer.setBuyerCategory();
        }else Menu.nonstock=true;
    }
    public static double calculateNet()
    {
        double sum=0;
        for (int i=0; i<OrderList.size(); i++) {
               sum+=OrderList.get(i).getQuantity()* OrderList.get(i).getItem().getPrice();    
        }
        return sum;
    }
    public static double calculateCourierCost()
    {
         double cost;
         if(calculateNet()*0.02<3.0) cost= 3.0;
         else cost=calculateNet()*0.02;
         if(Buyer.getLevel()=="GOLD") return 0.0;
         else if(Buyer.getLevel()=="SILVER") return cost/2;
         else return cost;
    }
    public ArrayList<ItemOrdered> getOrderList()
    {
        return OrderList;
    }
    
    
}