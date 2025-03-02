package flight.reservation.payment;

import java.util.HashMap;
import java.util.Map;

public class PayPalPayment implements PaymentStrategy {
    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private final String email;
    private final String password;

    static {
        DATA_BASE.put("password123", "user@example.com");
    }

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean pay(double amount) {
        if (DATA_BASE.containsKey(password) && DATA_BASE.get(password).equals(email)) {
            System.out.println("Paid " + amount + " using PayPal.");
            return true;
        }
        System.out.println("Invalid PayPal credentials.");
        return false;
    }
}
