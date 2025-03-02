package flight.reservation.plane.products.plane;

import flight.reservation.plane.Aircraft;

public class AntonovAN2 implements Aircraft {
    public String model;
    public int passengerCapacity;
    public int crewCapacity;

    public AntonovAN2() {
        model = "Antonov AN2";
        passengerCapacity = 15;
        crewCapacity = 3;
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
