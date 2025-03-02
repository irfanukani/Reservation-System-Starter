package flight.reservation.plane.factories.plane;

import flight.reservation.plane.*;
import flight.reservation.plane.factories.AircraftFactory;
import flight.reservation.plane.products.plane.A350;
import flight.reservation.plane.products.plane.A380;
import flight.reservation.plane.products.plane.AntonovAN2;
import flight.reservation.plane.products.plane.Embraer190;

public class PlaneFactory implements AircraftFactory {
    @Override
    public Aircraft createAircraft(String model) {
        switch (model) {
            case "A380":
                return new A380();
            case "A350":
                return new A350();
            case "Embraer 190":
                return new Embraer190();
            case "Antonov AN2":
                return new AntonovAN2();
            default:
                throw new IllegalArgumentException(String.format("Plane model '%s' is not recognized", model));
        }
    }
}
