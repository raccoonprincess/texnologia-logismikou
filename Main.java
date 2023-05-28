import java.util.*;

public class Main{
    public static void main(String[] args){ 
        for(int i=0; i<4; i++) Item.numofitems.add(0);
        
        //to notebook kanei lathos stoixisi sthn showcart()(view cart)
        
        Pen pen1 = new Pen("Pen1", 1, "fine black pen", 30, 11, "black", 0.5);
        Pen pen2 = new Pen("Pen2", 1, "fine blue pen", 30, 12, "blue", 0.5);
        Pen pen3 = new Pen("Pen3", 2, "thick blue pen ", 30, 13, "blue", 1.0);
        //ta grammaria pwn xartiwn mporei na einai gia kathe fyllo -> 4-5 gr;
        Paper pap1 = new Paper("Paper1", 4, "Pack of 500 blank pages", 50, 31, 2500);
        Paper pap2 = new Paper("Paper2", 5, "Pack of 500 lined pages",50, 32, 2600);
        Paper pap3 = new Paper("Paper3", 5, "Pack of 500 blank pages of recycled paper", 50, 33, 2000);
        Pencil pec1 = new Pencil ("Pencil1", 1.5, "Pink mechanical pencil", 25, 21, 0.5, "H"); 
        Pencil pec2 = new Pencil ("Pencil2", 1.5, "Black mechanical pencil", 30, 22, 0.7, "HB");
        Pencil pec3 = new Pencil ("Pencil3", 2, "Green mechanical pencil", 20, 23, 0.9, "B");
        Notebook noteb1 =new Notebook ("Notebook1", 2, "pink notebook",50, 41, 2);
        Notebook noteb2 =new Notebook ("Notebook2", 2, "blue notebook", 50, 42, 2);
        Notebook noteb3 =new Notebook ("Notebook3", 3, "yellow notebook", 60, 43, 3);
        
        Owner boss = new Owner("Eugene", "mrcrabs@gmail.com");
        EShop theshop = new EShop("Krusty Krub", boss);
        theshop.addItem(pen1);
        theshop.addItem(pen2);
        theshop.addItem(pen3);
      
        theshop.addItem(pec1);
        theshop.addItem(pec2);
        theshop.addItem(pec3);
     
        theshop.addItem(pap1);
        theshop.addItem(pap2);
        theshop.addItem(pap3);
        //System.out.println(theshop.getItemsList().get(2));
        
        theshop.addItem(noteb1);
        theshop.addItem(noteb2);
        theshop.addItem(noteb3);
        //buyer sto shopping cart!!!!!!!!!!!!!!!!!!!!!
        ShoppingCart cart1 = new ShoppingCart();
        ShoppingCart cart2 = new ShoppingCart();
        Buyer buyer1 = new Buyer("Sandy", "fountouki@gmail.com", cart1);
        buyer1.setBuyerCategory();
        Buyer buyer2 = new Buyer("Patrick", "pstar@gmail.com", cart2);
        buyer2.setBuyerCategory();
        theshop.addBuyer(buyer1);
        theshop.addBuyer(buyer2);
        
        buyer1.getMycart().addItemOrdered(pen1, 2);
        buyer1.getMycart().addItemOrdered(pen2, 2);
        buyer1.getMycart().addItemOrdered(pap3, 1);
        buyer1.getMycart().addItemOrdered(pap2, 2);
        
        cart2.addItemOrdered(noteb1, 2);
        cart2.addItemOrdered(noteb2, 1);
        cart2.addItemOrdered(pen3, 2);
        
        Item.catlist.add("Pen");
        Item.catlist.add("Pencil");
        Item.catlist.add("Paper");
        Item.catlist.add("Notebook");
        
        //h numofitems mallon prepei na ginei protected

        Menu.menu(boss, theshop.getBuyersList(), theshop.getItemsList(), theshop, Item.numofitems);
      
    }  
}
