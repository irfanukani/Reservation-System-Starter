package flight.reservation.order;

import flight.reservation.Customer;
import flight.reservation.flight.ScheduledFlight;
import flight.reservation.payment.PaymentStrategy;

import java.util.Arrays;
import java.util.List;

public class FlightOrder extends Order {
    private final List<ScheduledFlight> flights;
    private PaymentStrategy paymentStrategy;
    private Customer customer;
    static List<String> noFlyList = Arrays.asList("Peter", "Johannes");

    public FlightOrder(List<ScheduledFlight> flights, Customer customer) {
        this.flights = flights;
        this.customer = customer;
    }

    public static List<String> getNoFlyList() {
        return noFlyList;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public boolean processOrder() {
        if (isClosed()) {
            return true;
        }
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy not set.");
        }
        boolean isPaid = paymentStrategy.pay(this.getPrice());
        if (isPaid) {
            this.setClosed();
        }
        return isPaid;
    }

    public Customer getCustomer() {
        return customer;
    }
}
