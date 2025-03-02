package flight.reservation.flight;

import flight.reservation.Airport;
import flight.reservation.Passenger;
import flight.reservation.plane.Aircraft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ScheduledFlight extends Flight {
    private final Date departureTime;
    private final List<Passenger> passengers;
    private double currentPrice;

    // Private constructor used by builder
    private ScheduledFlight(Builder builder) {
        super(builder);
        this.departureTime = builder.departureTime;
        this.passengers = new ArrayList<>();
        this.currentPrice = builder.currentPrice;
        validateScheduledFlight();
    }

    // Builder class
    public static class Builder extends Flight.Builder {
        private Date departureTime;
        private double currentPrice = 100.0;

        public Builder departureTime(Date departureTime) {
            this.departureTime = departureTime;
            return this;
        }

        public Builder currentPrice(double currentPrice) {
            this.currentPrice = currentPrice;
            return this;
        }

        @Override
        public Builder number(int number) {
            super.number(number);
            return this;
        }

        @Override
        public Builder departure(Airport departure) {
            super.departure(departure);
            return this;
        }

        @Override
        public Builder arrival(Airport arrival) {
            super.arrival(arrival);
            return this;
        }

        @Override
        public Builder aircraft(Aircraft aircraft) {
            super.aircraft(aircraft);
            return this;
        }

        public ScheduledFlight build() {
            return new ScheduledFlight(this);
        }
    }

    private void validateScheduledFlight() {
        Objects.requireNonNull(departureTime, "Departure time cannot be null");
        if (currentPrice < 0) {
            throw new IllegalArgumentException("Current price cannot be negative");
        }
    }

    public void addPassengers(List<Passenger> passengersToAdd) {
        Objects.requireNonNull(passengersToAdd, "Passengers list cannot be null");
        int availableCapacity = getAircraft().getPassengerCapacity() - passengers.size();
        if (passengersToAdd.size() > availableCapacity) {
            throw new IllegalStateException(
                    String.format("Cannot add %d passengers. Only %d seats available",
                            passengersToAdd.size(), availableCapacity)
            );
        }
        this.passengers.addAll(passengersToAdd);
    }

    public void removePassengers(List<Passenger> passengersToRemove) {
        Objects.requireNonNull(passengersToRemove, "Passengers list cannot be null");
        this.passengers.removeAll(passengersToRemove);
    }

    public int getPassengerCapacity() {
        return getAircraft().getPassengerCapacity();
    }

    public int getCrewCapacity() {
        return getAircraft().getCrewCapacity();
    }

    public int getAvailableCapacity() {
        return getPassengerCapacity() - passengers.size();
    }

    public Date getDepartureTime() {
        return new Date(departureTime.getTime()); // Return defensive copy
    }

    public List<Passenger> getPassengers() {
        return Collections.unmodifiableList(passengers); // Return unmodifiable view
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        if (currentPrice < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.currentPrice = currentPrice;
    }

    @Override
    public String toString() {
        return String.format("%s [Time: %s, Price: $%.2f, Passengers: %d/%d]",
                super.toString(),
                departureTime,
                currentPrice,
                passengers.size(),
                getPassengerCapacity());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScheduledFlight)) return false;
        if (!super.equals(o)) return false;
        ScheduledFlight that = (ScheduledFlight) o;
        return Double.compare(that.currentPrice, currentPrice) == 0 &&
                departureTime.equals(that.departureTime) &&
                passengers.equals(that.passengers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), departureTime, passengers, currentPrice);
    }
}