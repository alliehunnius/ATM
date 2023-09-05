public class Account {
    private double amount;
    public Account (double amount)
    {
        amount = amount;
    }

    public double getBalance ()
    {
        return amount;
    }

    public void addBalance (double addedAmount)
    {
        amount += addedAmount;
    }

    public void subtractBalance (double withdrawn)
    {
        amount -= withdrawn;
    }
}
