public class ArtworkOrdered
{
    private Artwork artwork;
    private int quantity;
    
    public ArtworkOrdered(Artwork artwrk,int quan)
    {
      artwork=artwrk;
      quantity=quan;
    }

    public int getQuantity()
    {
        return quantity;
    }
    
    public void setQuantity(int a)
    {
        this.quantity+=a;
    }
    public Artwork getArtwork()
    {
        return artwork;
    }
}
