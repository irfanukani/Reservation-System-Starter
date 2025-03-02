package flight.reservation.plane.products.helicopter;

import flight.reservation.plane.Aircraft;

public class H1 implements Aircraft {
    private final String model = "H1";
    private final int passengerCapacity = 4;
    private final int crewCapacity = 0;

    @Override
    public String getModelName() { return model; }
    @Override
    public int getPassengerCapacity() { return passengerCapacity; }
    @Override
    public int getCrewCapacity() { return crewCapacity; }
}
