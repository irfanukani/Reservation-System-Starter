package flight.reservation.plane.factories.drone;

import flight.reservation.plane.Aircraft;
import flight.reservation.plane.products.drone.HypaHype;
import flight.reservation.plane.factories.AircraftFactory;

public class DroneFactory implements AircraftFactory {
    @Override
    public Aircraft createAircraft(String model) {
        switch (model) {
            case "HypaHype":
                return new HypaHype();
            default:
                throw new IllegalArgumentException(String.format("Drone model '%s' is not recognized", model));
        }
    }
}
