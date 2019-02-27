package Model;

public class User
{
    private String FullName, Username, Password;

    public User(String FullName, String Username, String Password)
    {
        this.FullName = FullName;
        this.Username = Username;
        this.Password = Password;
    }

    public String GetFullName()
    {
        return this.FullName;
    }
    public  String GetUserName()
    {
        return this.Username;
    }
    public String GetPassword()
    {
        return this.Password;
    }



}
