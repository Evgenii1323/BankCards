public class DebitCardWithCashBack extends DebitCard {
    private Double cashBack = 0.0;

    private final Double interestRate;
    private final Integer limit;

    public DebitCardWithCashBack(double interestRate, int limit) {
        this.interestRate = interestRate;
        this.limit = limit;
    }

    public boolean Pay(int amount) {
        int temporaryBalance = balance - amount;
        if (temporaryBalance > -1) {
            balance = temporaryBalance;
            if (amount > limit) {
                cashBack = cashBack + amount * interestRate;
            }
            return true;
        }
        return false;
    }

    public String GetInformation() {
        return " БАЛАНС " + balance + " КЭШБЕК " + cashBack;
    }
}