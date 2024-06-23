public class CreditCardWithBonus extends CreditCard {
    private Double bonus = 0.0;
    private final Double interestRate;

    public CreditCardWithBonus(int creditLimit, double interestRate) {
        super(creditLimit);
        this.interestRate = interestRate;
    }

    public boolean Pay(int amount) {
        int temporaryBalance = balance - amount;
        if (temporaryBalance > -1) {
            balance = temporaryBalance;
            bonus = bonus + amount * 0.01;
            return true;
        } else {
            int temporaryCreditBalance = creditBalance + temporaryBalance;
            if (temporaryCreditBalance > -1) {
                balance = 0;
                creditBalance = temporaryCreditBalance;
                bonus = bonus + amount * interestRate;
                return true;
            }
        }
        return false;
    }

    public String GetInformation() {
        return "ЛИМИТ " + creditBalance + " БАЛАНС " + balance + " БОНУС " + bonus;
    }
}