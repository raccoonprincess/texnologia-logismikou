public class Owner extends User 
{
    private  boolean isAdmin = true;
    
    public Owner(String onoma, String emailaddress)
    {
        name=onoma;
        email=emailaddress;
    }

    public String getUemail()
    {
        return email;
    }
}