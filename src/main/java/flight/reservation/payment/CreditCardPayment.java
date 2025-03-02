package flight.reservation.payment;

import java.util.Date;

/**
 * Dummy credit card class.
 */
public class CreditCardPayment implements PaymentStrategy {
    private final String number;
    private final Date expirationDate;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private final String cvv;
    private double balance;
    private boolean valid;

    public CreditCardPayment(String number, Date expirationDate, String cvv, double balance) {
        this.number = number;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.balance = 100000;
        this.setValid();
    }

    @Override
    public boolean pay(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Paid " + amount + " using Credit Card.");
            return true;
        }
        System.out.println("Insufficient credit card balance.");
        return false;
    }
    public boolean isValid() {
        return valid;
    }
    public void setValid() {
        // Dummy validation
        this.valid = number.length() > 0 && expirationDate.getTime() > System.currentTimeMillis() && !cvv.equals("000");
    }
}