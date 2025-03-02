package flight.reservation.plane.products.plane;

import flight.reservation.plane.Aircraft;

public class A380 implements Aircraft {
    public String model;
    public int passengerCapacity;
    public int crewCapacity;

    public A380() {
        model = "A380";
        passengerCapacity = 500;
        crewCapacity = 42;
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
