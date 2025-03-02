package flight.reservation.plane.products.plane;

import flight.reservation.plane.Aircraft;

public class A350 implements Aircraft {
    public String model;
    public int passengerCapacity;
    public int crewCapacity;

    public A350() {
        model = "A350";
        passengerCapacity = 320;
        crewCapacity = 40;
    }

    @Override
    public String getModelName() {
        return model;
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public int getCrewCapacity() {
        return crewCapacity;
    }
}
