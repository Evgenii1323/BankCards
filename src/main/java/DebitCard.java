public class DebitCard extends BankCard {

    @Override
    public boolean Refill(int amount) {
        balance = balance + amount;
        return true;
    }

    @Override
    public boolean Pay(int amount) {
        int temporaryBalance = balance - amount;
        if (temporaryBalance > -1) {
            balance = temporaryBalance;
            return true;
        }
        return false;
    }

    @Override
    public String GetInformation() {
        return " БАЛАНС " + balance;
    }
}