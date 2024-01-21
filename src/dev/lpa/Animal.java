package dev.lpa;

enum FlightStages implements Trackable {
    GROUNDED, LAUNCH, CRUISE, DATA_COLLECTION;

    @Override
    public void track() {

        if(this != GROUNDED){
            System.out.println("Monitoring " + this);
        }

    }

    public FlightStages getNextStage(){

        FlightStages[] allStages = values();
        return allStages[(ordinal() + 1) % allStages.length];

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

    FlightStages stage = FlightStages.GROUNDED;
    public void achieveOrbit() {
        transition("Orbit achieved!");
    }

    @Override
    public void takeOff() {

        transition("Taking Off");
    }

    @Override
    public void land() {

        transition("Landing");
    }

    @Override
    public void fly() {

        achieveOrbit();
        transition("Data Collection while Orbiting");
    }

    public void transition(String description){

        System.out.println(description);
        stage = transition(stage);
        stage.track();
    }
}

interface OrbitEarth extends FlightEnabled {

    void achieveOrbit();
    //We are utilizing the static method on the interface feature below:
    //If we were to set it to private, it would only be usable by the interface's concrete methods.
    static void log(String description) {

        var today = new java.util.Date();
        System.out.println(today + ": " + description);

    }

    private void logStage(FlightStages stage, String description){

        description = stage + ": " + description;
        log(description);
    }

    @Override
    default FlightStages transition(FlightStages stage) {
        FlightStages nextStage = FlightEnabled.super.transition(stage);
        logStage(stage, "Beginning Transition to " + nextStage);
        return nextStage;
    }
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

    //Below we are adding another method to the interface- this has created a problem with the other classes that are
    //currently implementing FlightEnabled, since they do not contain this method.

    //FlightStages transition (FlightStages stage);

    //An extension method is identified by the modifier default, so it's more commonly known as the default method (This
    //feature is new as of JDK 8).

    //This method is a concrete method, meaning it has a code block, and we can add statements to it.

    //In fact, it has to have a method body, even just an empty set of curly braces.

    //It's a lot like a method on a superclass because we can override it.

    //Adding a default method doesn't break any classes currently implementing the interface.

    //Below, we are going to add a method using the default operator.

    default FlightStages transition(FlightStages stage) {
//        System.out.println("transition not implemented on " + getClass().getName());
//        return null;

        FlightStages nextStage = stage.getNextStage();
        System.out.println("Transitioning from " + stage + " to " + nextStage);
        return nextStage;

        //Like overriding a method on a class, you have three choices when you override a default method on an
        //interface.

        //You can choose not to override it at all.

        //You can override the method and write code for it, so that the interface method isn't executed.

        //Or you can write your own code and invoke the method on the interface as part of your implementation.
    }

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

//*********** Public Static Methods on an interface as of JDK8

//Another enhancement Java included in JDK 8 was support for public static methods on the interface.

//Static methods don't need to specify a public access modifier, because it's implied.

//When you call a public static method on an interface, you must use the interface name as a qualifier.

//During the ArrayList lectures, we used two static helper methods on teh Comparator interface, which were added in JDK8.

//These were Comparator.naturalOrder() and Comparator.reverseOrder().

//JDK 9 gave us private methods, both static and non static.

//This enhancement primarily addresses the problem of re-use of code, within concrete methods on an interface.

//A private static method can be accessed either by a public static method, a default method, or a private non static
//method.

//A private non-static method is used to support default methods and other methods.
