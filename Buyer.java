public class Buyer extends User
{
   private static double bonus=0;
   private static String buyerCategory;
   private ShoppingCart mycart;
   
   
   
   public Buyer(String bonoma, String bemailaddress, ShoppingCart bcart)
   {
       name=bonoma;
       email=bemailaddress;
       mycart=bcart;
   }
   public static void awardBonus(double b)
   {
    bonus=+b;
   }
   public static void setBuyerCategory() //ta system out kalytera sth menu otan ginetai paraggelia
   {
       if (bonus<101.0){
         buyerCategory="BRONZE";
         //System.out.println("You are at bronze category.");
       }else if (bonus<201.0){
          buyerCategory="SILVER";
          //System.out.println("You are at silver category. You have 50% discount on shipping.");
       }else{
          buyerCategory="GOLD";
          //System.out.println("You are at gold category. You have free shipping.");
       }
       
    }
    public void placeOrder(Item antik, int howmany)
    {
      mycart.addItemOrdered(antik, howmany);
    }
    public double getBonus()
    {
        return bonus;
    }
    public static String getLevel()
    {
        return buyerCategory;
    }
    public ShoppingCart getMycart()
    {
        return mycart;
    }
    public String getUemail()
    {
        return email;
    }
}