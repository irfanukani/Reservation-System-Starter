package flight.reservation.flight;

import flight.reservation.Airport;
import flight.reservation.plane.Aircraft;

import java.util.Arrays;
import java.util.Objects;

public class Flight {
    private final int number;
    private final Airport departure;
    private final Airport arrival;
    private final Aircraft aircraft;

    // Private constructor used by builder
    Flight(Builder builder) {
        this.number = builder.number;
        this.departure = builder.departure;
        this.arrival = builder.arrival;
        this.aircraft = builder.aircraft;
        validateFlight();
    }

    // Builder class for constructing Flight objects
    public static class Builder {
        private int number;
        private Airport departure;
        private Airport arrival;
        private Aircraft aircraft;

        public Builder number(int number) {
            this.number = number;
            return this;
        }

        public Builder departure(Airport departure) {
            this.departure = departure;
            return this;
        }

        public Builder arrival(Airport arrival) {
            this.arrival = arrival;
            return this;
        }

        public Builder aircraft(Aircraft aircraft) {
            this.aircraft = aircraft;
            return this;
        }

        public Flight build() {
            return new Flight(this);
        }
    }

    private void validateFlight() {
        Objects.requireNonNull(departure, "Departure airport cannot be null");
        Objects.requireNonNull(arrival, "Arrival airport cannot be null");
        Objects.requireNonNull(aircraft, "Aircraft cannot be null");

        if (number <= 0) {
            throw new IllegalArgumentException("Flight number must be positive");
        }

        if (departure.equals(arrival)) {
            throw new IllegalArgumentException("Departure and arrival airports cannot be the same");
        }

        if (!isAircraftValidForAirport(departure) || !isAircraftValidForAirport(arrival)) {
            throw new IllegalArgumentException(
                    String.format("Aircraft %s is not valid for the route %s-%s",
                            aircraft.getModelName(),
                            departure.getCode(),
                            arrival.getCode())
            );
        }
    }

    private boolean isAircraftValidForAirport(Airport airport) {
        return Arrays.stream(airport.getAllowedAircrafts())
                .anyMatch(allowedModel -> allowedModel.equals(aircraft.getModelName()));
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public int getNumber() {
        return number;
    }

    public Airport getDeparture() {
        return departure;
    }

    public Airport getArrival() {
        return arrival;
    }

    @Override
    public String toString() {
        return String.format("%s-%d-%s/%s",
                aircraft.getModelName(),
                number,
                departure.getCode(),
                arrival.getCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return number == flight.number &&
                departure.equals(flight.departure) &&
                arrival.equals(flight.arrival) &&
                aircraft.equals(flight.aircraft);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, departure, arrival, aircraft);
    }
}