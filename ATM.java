import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class ATM {

    private HashMap <String,  Account> hm;

    public ATM ()
    {
        
        hm = new HashMap <String, Account> ();

    }



    public void createAccount (String userId, double amount) throws Exception
    {
        if (!hm.containsKey(userId))
        {
            hm.put (userId, new Account(amount));
        }
        else
        {
            throw new Exception ("This user already has an account. Idiot.");
        }
    }

    public double checkBalance (String userId) throws Exception
    {
        if (hm.containsKey (userId))
        {
            return hm.get (userId).getBalance();
        }
        else
        {
            throw new Exception ("No account can be found under this email. Create an account on try somewhere else, stupid.");
        }
        
    }

    public double depositMoney (String userId, double amount) throws Exception
    {
        if (hm.containsKey (userId))
        {
            hm.get (userId).addBalance (amount);
            return amount;
        }
        else
        {
            throw new Exception ("You can't deposit money because you don't have an account. This is likely because you are broke AF.");
        }
    }

    public double withdrawMoney (String userId, double amount) throws Exception
    {
        if (hm.containsKey (userId))
        {
            double currentBalance = hm.get (userId).getBalance();
            if (currentBalance >= amount)
            {
                hm.get(userId).subtractBalance(amount);
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

    public boolean transferMoney (String toAccount, String fromAccount, double amount) throws Exception
    {
        if (hm.containsKey (toAccount) && hm.containsKey (fromAccount))
        {
            if (hm.get (toAccount).getBalance () >= amount)
            {
                hm.get (toAccount).subtractBalance (amount);
                hm.get (fromAccount).addBalance(amount);
                return true;
            }
            else
            {
                throw new Exception ("You don't have enough money to do this. You're broke AF. Sorry, not sorry.");
            }
        }
        else
        {
            throw new Exception ("Either one, or both of these counts don't exist. Stop wasting my time");
        }
    }

    public void closeAccount (String userId) throws Exception
    {
        if (hm.get (userId).getBalance() > 0)
        {
            throw new Exception ("You need to withdraw your money before you can close your account.");
        }
        else
        {
            hm.remove(userId);
        }
    }

    public void audit () throws IOException
    {
        FileWriter fw = new FileWriter ("AccountAudit.txt");
        for (String userId: hm.keySet())
        {
            fw.write (userId + "\n");
            fw.write (Double.toString (hm.get (userId).getBalance()) + "\n");
        }
        fw.close();
    }
    
}

