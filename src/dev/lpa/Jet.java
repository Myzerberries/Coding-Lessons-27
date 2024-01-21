package dev.lpa;

//We can treat a bird and a jet similarly, from the client code's perspective. But what they actually do is dependent
//they implement the FlightEnabled methods, but the client can treat them as if they were the same.
public class Jet implements FlightEnabled, Trackable{

    @Override
    public void takeOff() {

        System.out.println(getClass().getSimpleName() + " is taking off");

    }

    @Override
    public void land() {

        System.out.println(getClass().getSimpleName() + " is landing");

    }

    @Override
    public void fly() {

        System.out.println(getClass().getSimpleName() + " is flying");

    }

    @Override
    public void track() {

        System.out.println(getClass().getSimpleName() + "'s coordinates recorded");

    }

    @Override
    public FlightStages transition(FlightStages stage) {
        System.out.println(getClass().getSimpleName() + " transitioning");
        return FlightEnabled.super.transition(stage);
    }
}
