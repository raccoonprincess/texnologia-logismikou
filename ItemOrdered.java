public class ItemOrdered
{
    private Item item;
    private int quantity;
    
    public ItemOrdered(Item ite,int quan)
    {
      item=ite;
      quantity=quan;
    }

    //public String ItemOrdered()
    //{
    //    return ("You have " + item + "in your cart " + "quantity: " + quantity);
    //}
    public int getQuantity()
    {
        return quantity;
    }
    
    public void setQuantity(int a)
    {
        this.quantity+=a;
    }
    public Item getItem()
    {
        return item;
    }
}