package flight.reservation.plane.factories;

import flight.reservation.plane.factories.drone.DroneFactory;
import flight.reservation.plane.factories.helicopter.HelicopterFactory;
import flight.reservation.plane.factories.plane.PlaneFactory;

public class AircraftFactoryProvider {
    public static AircraftFactory getAircraftFactory(String aircraftFactoryType) {
        switch (aircraftFactoryType.toLowerCase()){
            case "plane":
                return new PlaneFactory();
            case "helicopter":
                return new HelicopterFactory();
            case "drone":
                return new DroneFactory();
            default:
                throw new IllegalArgumentException(String.format("Aircraft type '%s' is not recognized", aircraftFactoryType));
        }
    }
}
