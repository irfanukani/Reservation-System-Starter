package flight.reservation.plane.products.plane;

import flight.reservation.plane.Aircraft;

public class Embraer190 implements Aircraft {
    public String model;
    public int passengerCapacity;
    public int crewCapacity;

    public Embraer190() {
        model = "Embraer 190";
        passengerCapacity = 25;
        crewCapacity = 5;
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
