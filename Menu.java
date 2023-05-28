import java.util.*;
import java.io.*;
public class Menu
{
    public static boolean nonstock;
    public static void menu(Owner bossaki, ArrayList<Buyer> blist, ArrayList<Item> iList, EShop chop, ArrayList<Integer> itemnum)
    { //ArrayList<ItemOrdered> olista
      char allos='y';
      int correct=0;
      
      String isemail;
      while(allos=='y')
      {
        //var declarations should be outside the loop
        //prosoxi! Ta new scanner (mporei na thelei ki ayta outside the loop)
        //h mporei na arkei ena mono scanner object to opoio tha xrhsimopoioyme kathe fora
        //mind=blown;
        
        int i=0;
        boolean found=false;
        nonstock = true;
        
        Scanner emailip = new Scanner(System.in);
        System.out.println("Enter email: ");
        
        isemail = emailip.nextLine();
        String s1 = new String(isemail);
        String s2 = new String(bossaki.getUemail());

        if(s1.equals(s2))
        {
            System.out.println("Hi, "+ bossaki.getUName());
            System.out.println("Name: "+bossaki.getUName()+"Email: "+bossaki.getUemail());
            System.out.println("You are the owner of the eshop Ta Papakia.");
          while(true)
          {
            System.out.println("Press 1 to browse Store\nPress 2 to check status\nPress 3 to log out\nPress 4 to exit");
            Scanner ochoice = new Scanner(System.in);
            int och = ochoice.nextInt();
            if(och==1)
            {
              while(true)
              {
                for(i=0; i<Item.catlist.size(); i++)
                {
                    System.out.print(i+1 +". ");
                    chop.showCategories(i);
                    System.out.println(" ("+Item.numofitems.get(i)+" kinds)");
                }
                System.out.println("5. Go back");
                Scanner choice9 = new Scanner(System.in);
                int ch9 = choice9.nextInt();
                
                if(ch9==5) break;
                
                chop.showProductsInCategory(ch9);
                System.out.println();
                Scanner choice10 = new Scanner(System.in);
                int ch10 = choice10.nextInt();
                chop.showProduct(chop.getItemsList().get(ch10-1));
                
                while(true)
                {
                System.out.println("Do you want to update that item? (y/n)");
                Scanner choice11 = new Scanner(System.in);
                char ch11 = choice11.next().charAt(0);
                
                switch(ch11)
                {
                    case 'y':
                        System.out.println("What is the new quantity?");
                        Scanner choice12 = new Scanner(System.in);
                        int ch12 = choice12.nextInt();
                        chop.updateItemStock(chop.getItemsList().get(ch10-1), ch12);
                        chop.showProduct(chop.getItemsList().get(ch10-1));
                        correct=0;
                        break;
                    case 'n':
                        correct=0;
                        break;
                    default:
                        System.out.println("Invalid selection. Try again.\n");
                        correct=-1;  
                }
                if(correct==0)break;
            }
              
            }
          
            }else if(och==2)
            {
                while(true)
                {
                for(int j=0; j<blist.size(); j++)
                {
                    System.out.println(j+1 + ". ");
                    chop.checkStatus(blist.get(j));
                    System.out.println("\n");
                }
                System.out.println("Choose a buyer\nor press 0 to go back.");
                Scanner ochoice2 = new Scanner(System.in);
                int och2 = ochoice2.nextInt();
                if(och2==0) break;
                blist.get(och2-1).getMycart().showCart(); // den deixnei swsta items!!!!!
                
                while(true)
                {
                System.out.println("Delete buyer? (y/n)");
                Scanner delbuyer = new Scanner(System.in);
                char delb = delbuyer.next().charAt(0);
                switch(delb)
                {
                    case 'y':
                        chop.removeBuyer(blist.get(och2-1));
                        for(int kp=0; kp<blist.get(och2-1).getMycart().getOrderList().size(); kp++)
                        chop.updateItemStock(blist.get(och2-1).getMycart().getOrderList().get(kp).getItem(), blist.get(och2-1).getMycart().getOrderList().get(kp).getQuantity());
                        correct=0;
                        break;
                    case 'n':
                        correct=0;
                        break;
                    default:
                        System.out.println("Invalid selection. Try again.");
                        correct=-1;
                    }
                   if(correct==0)break;
                }
            }
                
            }else if(och==3)
            {
                System.out.println("Are you sure you want to log out? (y/n)");
                Scanner logout = new Scanner(System.in);
                char lout = logout.next().charAt(0);
                if(lout=='y')
                {
                    System.out.println("Syndesh allou xrhsth? (y/n)");
                    Scanner sindesi = new Scanner(System.in);
                    allos = logout.next().charAt(0);
                    if(allos !='y') System.out.println("Goodbye Boss!");
                }
            }else if(och==4)
            {
                System.out.println("Are you sure you want to exit? (y/n)");
                Scanner exitshop = new Scanner(System.in);
                char exits= exitshop.next().charAt(0);
                if(exits=='y')
                System.out.println("Goodbye Boss!");
                System.exit(0);
                //an pei no?
            }
        }
        
        }else{
        
        for(int k=0; k<blist.size(); k++){
            String s3 = new String(blist.get(k).getUemail());
            if(s1.equals(s3))
                {
                    found=true;
                    i=k;
                }
            }
            
        if(true)
        {
            System.out.println("Hi, "+ blist.get(i).getUName());
            System.out.println("Name: "+blist.get(i).getUName()+"Email: "+blist.get(i).getUemail()+"\nBonus: "+blist.get(i).getBonus()+"\nLevel: "+blist.get(i).getLevel());
            while(true)
            {
            //print "ta papakia"???
            System.out.println("Press 1 to browse Store\nPress 2 to view Cart\nPress 3 to Checkout\nPress 4 to log out\nPress 5 to exit");
            Scanner choice1 = new Scanner(System.in);
            int ch1 = choice1.nextInt();
            
            if(ch1==1)
            {
                int rev;
                while(true)
                {
                System.out.println(chop.getEshopName());
                for(rev=0; rev<Item.catlist.size(); rev++)
                {
                    System.out.print(rev+1 +". ");
                    chop.showCategories(rev);
                    System.out.println(" ("+Item.numofitems.get(rev)+" kinds)");
                }
                System.out.println("Press 0 to go back");
                Scanner choice7 = new Scanner(System.in);
                int ch7 = choice7.nextInt();
                if(ch7==0) break;
                chop.showProductsInCategory(ch7);
                
                System.out.println();
                Scanner choice2 = new Scanner(System.in);
                int ch2 = choice2.nextInt();
                chop.showProduct(chop.getItemsList().get(ch2-1));
                while(true)
                {
                System.out.println("Add to cart? (y/n)");
                Scanner choice5 = new Scanner(System.in);
                char ch5 = choice5.next().charAt(0);
                
                switch(ch5)
                {
                     case 'y':
                         correct=0;
                         System.out.println("How many of this would you like to add to the cart?");
                         Scanner choice8 = new Scanner(System.in);
                         while(nonstock)
                         {
                         int ch8 = choice8.nextInt();
                         blist.get(0).placeOrder(chop.getItemsList().get(1), ch8);
                         }
                         // blist.get(iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii)
                         
                         break;
                     case 'n':
                        correct=0;
                        break;
                     default:
                        System.out.println("Invalid selection. Try again.");
                        correct=-1;
                }
                 if(correct==0) break;
                }
                
            }
                
                
            }else if(ch1==2)
            {
                while(true)
                {
                if(blist.get(i).getMycart().getOrderList().size()>0) blist.get(i).getMycart().showCart(); //arithmisi
                else System.out.println("Your cart is empty.");
                
                System.out.println("Press A to select an order.\nPress B to clear your cart.\nPress C to proceed to checkout.\nPress D to go back."); 
                //einai swsth h ekfrash?
                Scanner choice3 = new Scanner(System.in);
                char ch3 = choice3.next().charAt(0);
                if(ch3=='A')
                {
                    System.out.println("Choose an item or press 0 to go back:");
                    Scanner choice15 = new Scanner(System.in);
                    int ch15 = choice15.nextInt();
                    if(ch15==0) break;
                    System.out.println("Press 1 to delete this order\nPress 2 to update this order");
                   
                    while(true)
                    {
                    Scanner choice16 = new Scanner(System.in);
                    int ch16 = choice16.nextInt();
                    switch(ch16)
                    {
                        case 1:
                            blist.get(i).getMycart().getOrderList().remove(blist.get(i).getMycart().getOrderList().get(ch16-1));
                            break;
                        case 2:
                            System.out.println("How many do you want to add (give a positive number) or remove (give a negative number)");
                            Scanner choice17 = new Scanner(System.in);
                            int ch17 = choice17.nextInt();
                            blist.get(i).getMycart().getOrderList().get(ch15-1).setQuantity(ch17);
                            //try-catch gia stock kai enhmerwsh stock!!!!!!!!
                            break;
                        default:
                            System.out.println("Invalid selection. Try again.");
                            correct=-1;
                    }
                   if(correct==0)break;
                }
                }else if(ch3=='B')
                {
                    blist.get(i).getMycart().clearCart();
                }else if(ch3=='C')
                {
                    blist.get(i).getMycart().checkout();
                }else if(ch3=='D')
                { 
                    break;
                }
            }
                
                
                
            }else if(ch1==3)
            {
                nonstock=false;
                blist.get(i).getMycart().checkout();
                if(nonstock) break; 
                
                //(gia to go back, xoris na leei press kati to go back)
                
            }else if(ch1==4)
            {
                System.out.println("Are you sure you want to log out? (y/n)");
                Scanner logout = new Scanner(System.in);
                char lout = logout.next().charAt(0);
                if(lout=='y')
                {
                    System.out.println("Syndesh allou xrhsth? (y/n)");
                    Scanner sindesi = new Scanner(System.in);
                    allos = logout.next().charAt(0);
                    if(allos !='y') System.out.println("Goodbye!");
                }
            }else if(ch1==5)
            {
                System.out.println("Are you sure you want to exit? (y/n)");
                Scanner exitshop = new Scanner(System.in);
                char exits= exitshop.next().charAt(0);
                if(exits=='y'){
                    System.out.println("Goodbye!");
                    System.exit(0); //an pathsei no??? me domi epanalipsis?
                }
            }
        }
        }else 
        {
            boolean register = false;
            Scanner reg = new Scanner(System.in);
            System.out.println("Do you want to register as a new buyer? (y/n)\n");
            char regis= reg.next().charAt(0);
            if(regis=='y') register=true;
            System.out.println();
            if(register)
            {
                Scanner newname = new Scanner(System.in);
                System.out.println("Enter your name: ");
                String thename = emailip.nextLine();
                ShoppingCart newcart = new ShoppingCart();
                //prepei na onomazoume kathe cart diaforetika. PWS????????
                Buyer newbie = new Buyer (thename, isemail, newcart);
                chop.addBuyer(newbie);
                Buyer.setBuyerCategory();
               // ShoppingCart newcart= new ShoppingCart()
               // chop.addCart(newcart);
               //prosoxiiiiiiii
                
            }else 
            {
                System.out.println("Thanks for visiting! Goodbye!");
                System.exit(0);
            }
        }
     }
     
    }
}
}


