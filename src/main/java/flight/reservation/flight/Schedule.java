package flight.reservation.flight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Schedule {
    private final List<ScheduledFlight> scheduledFlights;

    public Schedule() {
        this.scheduledFlights = new ArrayList<>();
    }

    /**
     * Returns an unmodifiable view of the scheduled flights list
     * @return List of scheduled flights
     */
    public List<ScheduledFlight> getScheduledFlights() {
        return Collections.unmodifiableList(scheduledFlights);
    }

    /**
     * Creates and adds a new scheduled flight based on a Flight object and departure time
     * @param flight The base flight information
     * @param departureTime The scheduled departure time
     * @return The created ScheduledFlight
     * @throws NullPointerException if flight or departureTime is null
     */
    public ScheduledFlight scheduleFlight(Flight flight, Date departureTime) {
        Objects.requireNonNull(flight, "Flight cannot be null");
        Objects.requireNonNull(departureTime, "Departure time cannot be null");

        ScheduledFlight scheduledFlight = new ScheduledFlight.Builder()
                .number(flight.getNumber())
                .departure(flight.getDeparture())
                .arrival(flight.getArrival())
                .aircraft(flight.getAircraft())
                .departureTime(departureTime)
                .build();

        scheduledFlights.add(scheduledFlight);
        return scheduledFlight;
    }

    /**
     * Removes all scheduled flights matching the given flight's core attributes
     * @param flight The flight to remove
     * @return true if any flights were removed, false otherwise
     * @throws NullPointerException if flight is null
     */
    public boolean removeFlight(Flight flight) {
        Objects.requireNonNull(flight, "Flight cannot be null");

        return scheduledFlights.removeIf(sf ->
                sf.getNumber() == flight.getNumber() &&
                        sf.getDeparture().equals(flight.getDeparture()) &&
                        sf.getArrival().equals(flight.getArrival()) &&
                        sf.getAircraft().equals(flight.getAircraft())
        );
    }

    /**
     * Removes a specific ScheduledFlight instance
     * @param scheduledFlight The specific scheduled flight to remove
     * @return true if the flight was removed, false if it wasn't in the schedule
     * @throws NullPointerException if scheduledFlight is null
     */
    public boolean removeScheduledFlight(ScheduledFlight scheduledFlight) {
        Objects.requireNonNull(scheduledFlight, "Scheduled flight cannot be null");
        return scheduledFlights.remove(scheduledFlight);
    }

    /**
     * Searches for a scheduled flight by flight number
     * @param flightNumber The flight number to search for
     * @return Optional containing the found ScheduledFlight, or empty if not found
     */
    public Optional<ScheduledFlight> searchScheduledFlight(int flightNumber) {
        return scheduledFlights.stream()
                .filter(f -> f.getNumber() == flightNumber)
                .findFirst();
    }

    /**
     * Clears all scheduled flights
     */
    public void clear() {
        scheduledFlights.clear();
    }

    /**
     * Returns the number of scheduled flights
     * @return size of the schedule
     */
    public int size() {
        return scheduledFlights.size();
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduledFlightsCount=" + scheduledFlights.size() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return scheduledFlights.equals(schedule.scheduledFlights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scheduledFlights);
    }
}