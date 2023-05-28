public class Buyer extends User
{
   private ShoppingCart mycart;
   
   
   
   public Buyer(String bonoma, String bemailaddress, ShoppingCart bcart)
   {
       name=bonoma;
       email=bemailaddress;
       mycart=bcart;       
    }
    public void placeOrder(Artwork antik, int howmany)
    {
      mycart.addItemOrdered(antik, howmany);
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
