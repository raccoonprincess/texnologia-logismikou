abstract class User
{ 
   protected  String name;
   protected  String email;
   protected String password;
   
   public String getUName()
    {
        return name;
    }
    
   public abstract String getUemail();
   public abstract String getUpassword();
}
