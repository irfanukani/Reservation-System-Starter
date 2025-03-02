package flight.reservation.plane.products.drone;

import flight.reservation.plane.Aircraft;

public class HypaHype implements Aircraft {
    private final String model = "HypaHype";
    private final int passengerCapacity = 0;
    private final int crewCapacity = 0;

    @Override
    public String getModelName() { return model; }
    @Override
    public int getPassengerCapacity() { return passengerCapacity; }
    @Override
    public int getCrewCapacity() { return crewCapacity; }
}
