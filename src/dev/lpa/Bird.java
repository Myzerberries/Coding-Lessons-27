package dev.lpa;

public class Bird extends Animal implements FlightEnabled, Trackable{


    @Override
    public void move() {
        System.out.println("Flaps wings");
    }

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
}

//A class can only extend a single class, which is why Java is called single inheritance.

//But a class can implement many interfaces. This gives us plug and play functionality, which is what makes them so
//powerful.

//A class can both extend another class, and implement one or more interfaces.

//In the example above, the Bird class extends, or inherits from Animal, but it's implementing both a FlightEnabled and
//a Trackable interface.

//We can describe Bird by what it is, and what it does.

//Similar to the way an abstract class forces its subclasses to implement the abstract methods it declares, the interface
//requires any classes that implement it to do the same.
