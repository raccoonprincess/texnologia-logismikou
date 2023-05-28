public class ValidityControler extends User 
{
    private  boolean isAdmin = true;
    
    public ValidityControler(String onoma, String emailaddress, String password)
    {
        name=onoma;
        email=emailaddress;
        password=passwrd;
    }

    public String getUemail()
    {
        return email;
    }
}
