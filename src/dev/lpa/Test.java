package dev.lpa;

public class Test {

    public static void main(String[] args) {

        inFlight(new Jet());

        OrbitEarth.log("Testing " + new Satellite());

        orbit(new Satellite());

    }

    private static void inFlight (FlightEnabled flier){

        flier.takeOff();
        flier.transition(FlightStages.LAUNCH);
        flier.fly();

        //The instanceof operator is testing an interface type, Trackable, and still works the same as it would if it
        //were testing an instance of a class.

        //If the object is a class that implements Trackable, then a local variable is set up, named tracked, with
        //the type Trackable. Because of that, we can call the track method on that variable, tracked, that the
        //instanceof operator set up for us.

        if(flier instanceof Trackable tracked) {
            tracked.track();
        }

        flier.land();

    }

    private static void orbit(OrbitEarth flier){

        flier.takeOff();
        flier.fly();
        flier.land();

    }


}
