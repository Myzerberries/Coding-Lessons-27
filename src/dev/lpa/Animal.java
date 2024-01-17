package dev.lpa;

enum FlightStages implements Trackable {
    GROUNDED, LAUNCH, CRUISE, DATA_COLLECTION;

    @Override
    public void track() {

        if(this != GROUNDED){
            System.out.println("Monitoring " + this);
        }

    }
}
record DragonFly(String name, String type) implements FlightEnabled {
    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }
    //Normally records don't have class bodies, but because we're implementing Flight enabled, this record needs to
    //implement FlightEnableds abstract methods.

}
class Satellite implements OrbitEarth {

    public void achieveOrbit() {
        System.out.println("Orbit achieved!");
    }

    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }
}

interface OrbitEarth extends FlightEnabled {

    void achieveOrbit();

}
interface FlightEnabled {

    //We don't have to declare the interface type abstract, because this modifier is implicitly declared for all
    //interfaces.

    //In fact, any method declared without a body is really implicitly declared both public and abstract.

    //If we omit an access modifier on a class member, it's implicitly package private.

    //If we omit an access modifier on an interface member, it's implicitly public.

    //Changing the access modifier of a method to protected on an interface is a compiler error, whether the method is
    //concrete or abstract. Only a concrete method can have private access.
    public abstract void takeOff();
    abstract void land();
    void fly();

    //Any fields declared on an interface are not really instance fields. They're implicitly public, static, and final,
    //which means they're really constants.
    double MILES_TO_KM = 1.60934;
    double KM_TO_MILES = 0.621371;

}

interface Trackable {

    void track();

}
public abstract class Animal {

    public abstract void move();
}

//The final modifier in java:

//When we use the final modifier, we prevent any further modifications to that component.

//A final method means it can't be overridden by a subclass.

//A final field means an object's field can't be reassigned or given a different value after its initialization.

//A final static field is a class field that can't be reassigned, or given a different value, after the class's
//initialization process.

//A final class can't be overridden, meaning no class can use it in the extends clause.

//A final variable in a block of code, means that once it's assigned a value, any remaining code in the block can't
//change it.

//A final method parameter means we can't assign a different value to that parameter in the method code block.

//The final static field is what you're really creating when declaring a field on an interface.

//Constants in Java:

//A constant in Java is a variable that can't be changed.

//A constant variable is a final variable of primitive type, or type String, that is initialized with a constant
//expression.

//Constants in Java are usually named with all uppercase letters, and with underscores between words.

//A static constant means we access it via the type name.

//We saw this with the INTEGER.MAX_VALUE and the INTEGER.MIN_VALUE fields.

//Java lets us specify these like an ordinary field on an interface, which might be confusing and misleading to a new
//Java programmer.

//But we can declare them with any combination of those modifiers, or none at all, with the same result.

//These all mean the same thing on an interface.

//(Within an interface) double MILES_TO_KM = 1.60934; final double MILES_TO_KM = 1.60934; public final double MILES_TO_
//KM= 1.60934; public static final double MILES_TO_KM = 1.60934;
