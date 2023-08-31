import java.util.HashMap;

public class ATM {

    private HashMap <String,  Account> hm;

    public ATM ()
    {
        
        hm = new HashMap <String, Account> ();

    }



    public void createAccount (String email, double amount) throws Exception
    {
        if (!hm.containsKey(email))
        {
            hm.put (email, new Account(amount));
        }
        else
        {
            throw new Exception ("This user already has an account. Idiot.");
        }
    }

    public double checkBalance (String email) throws Exception
    {
        if (hm.containsKey (email))
        {
            return hm.get (email).getBalance();
        }
        else
        {
            throw new Exception ("No account can be found under this email. Create an account on try somewhere else, stupid.");
        }
        
    }

    public double depositMoney (String email, double amount) throws Exception
    {
        if (hm.containsKey (email))
        {
            hm.get (email).addBalance (amount);
            return amount;
        }
        else
        {
            throw new Exception ("You can't deposit money because you don't have an account. This is likely because you are broke AF.");
        }
    }

    public double withdrawMoney (String email, double amount) throws Exception
    {
        if (hm.containsKey (email))
        {
            double currentBalance = hm.get (email).getBalance();
            if (currentBalance >= amount)
            {
                hm.get(email).subtractBalance(currentBalance - amount);
                return amount;
            }
            else
            {
                throw new Exception ("You don't have enough money to do this. You're broke AF. Sorry, not sorry.");
            }
        }
        else
        {
            throw new Exception ("You don't have an account with us. Nice try, loser.");
        }
    }
    
}

