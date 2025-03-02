package flight.reservation.plane.factories.helicopter;

import flight.reservation.plane.Aircraft;
import flight.reservation.plane.products.helicopter.H1;
import flight.reservation.plane.products.helicopter.H2;
import flight.reservation.plane.factories.AircraftFactory;

public class HelicopterFactory implements AircraftFactory {
    @Override
    public Aircraft createAircraft(String model) {
        switch (model) {
            case "H1":
                return new H1();
            case "H2":
                return new H2();
            default:
                throw new IllegalArgumentException(String.format("Helicopter model '%s' is not recognized", model));
        }
    }
}
