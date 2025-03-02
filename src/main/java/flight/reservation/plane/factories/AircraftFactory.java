package flight.reservation.plane.factories;

import flight.reservation.plane.Aircraft;

public interface AircraftFactory {
    Aircraft createAircraft(String model);
}
