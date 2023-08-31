import java.util.HashMap;

public class ATM {

    private HashMap <String,  Account> hm;

    public ATM ()
    {
        
        hm = new HashMap <String, Account> ();

    }



    public void createAccount (String email, double amount)
    {
        if (!hm.containsKey(email))
        {
            hm.put (email, new Account(amount));
        }
        else{
            throw new Exception ("This user already has an account.");
        }


    }

