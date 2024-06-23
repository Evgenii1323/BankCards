public abstract class BankCard {
    protected int balance;

    public abstract boolean Refill(int amount);

    public abstract boolean Pay(int amount);

    public abstract String GetInformation();

    public int GetBalance() {
        return balance;
    }
}