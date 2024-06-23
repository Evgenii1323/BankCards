public class CreditCard extends BankCard {
    protected int creditBalance;

    private final int creditLimit;

    public CreditCard(int creditLimit) {
        this.creditLimit = creditLimit;
        creditBalance = creditLimit;
    }

    @Override
    public boolean Refill(int amount) {
        if (creditBalance < creditLimit) {
            creditBalance = creditBalance + amount;
            if (creditBalance > creditLimit) {
                int variance = creditBalance - creditLimit;
                creditBalance = creditBalance - variance;
                balance = balance + variance;
            }
        } else {
            balance = balance + amount;
        }
        return true;
    }

    @Override
    public boolean Pay(int amount) {
        int temporaryBalance = balance - amount;
        if (temporaryBalance > -1) {
            balance = temporaryBalance;
            return true;
        } else {
            int temporaryCreditBalance = creditBalance + temporaryBalance;
            if (temporaryCreditBalance > -1) {
                balance = 0;
                creditBalance = temporaryCreditBalance;
                return true;
            }
        }
        return false;
    }

    @Override
    public String GetInformation() {
        return "ЛИМИТ " + creditBalance + " БАЛАНС " + balance;
    }
}