package dev.lpa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Bird bird = new Bird();
        Animal animal = bird;
        FlightEnabled flier = bird;
        Trackable tracked = bird;

        //The type you use, meaning the variable's declared type, determines which methods you can use on your calling
        //code. When we assigned the bird object to FlightEnabled and Trackable variables, those types don't have a
        //.move method on them, so we get a compiler error. The compiler only cares about the declared type.
        animal.move();
//        flier.move();
//        tracked.move();

        //In the code below, we have a variable, flier, of type FlightEnabled, and when we call any FlightEnabled methods
        //on that variable, it executes bird's methods, because bird is our runtime object.

        //And the same is true of Trackable.
        flier.takeOff();
        flier.fly();
        tracked.track();
        flier.land();

        inFlight(flier);

        inFlight(new Jet());

        Trackable truck = new Truck();
        truck.track();

        //An interface lets us treat an instance of a single class as many different types.

        //The Bird class inherits behavior and attributes from Animal, because we used the extends keyword in the
        //declaration of Bird.

        //Because the move method wsa abstract on Animal, Bird was required to implement it.

        //The Bird class implements the FlightEnabled interface.

        //This required the Bird class to implement the takeOff, fly, and land methods: the abstract methods on
        //FlightEnabled.

        //The Bird class also implements the Trackable interface.

        //This required the Bird class to implement the track method, which was the abstract method declared on
        //Trackable.

        //Because of these declarations, any instance of the Bird class can be treated as a Bird.

        //This means it has access to all of bird's methods, including all those from Animal, FlightEnabled, and
        //Trackable.

        //An instance of Bird can be treated like, or declared as an Animal, with access to the Animal functionality,
        //described in that class, but customized to Bird.

        //It can be used as a FlightEnabled type, with just the methods a FlightEnabled type needs, but again
        //customized for the Bird.

        //Or it can take the form of a Trackable object, and be tracked, with specifics for the Bird class.

        //Interfaces let us take objects that may have almost nothing in common, and write reusable code so that we can
        //process them all in a like manner.

        //A Jet, Bird, and DragonFly are very different entities.

        //But because they implement FlightEnabled, we can treat them all as the same type, as something that flies, and
        //ignore the differences in the classes.

        //Interfaces allow us to type our objects differently, by behavior only.

        double kmsTraveled = 100;
        double milesTraveled = kmsTraveled * FlightEnabled.KM_TO_MILES;
        System.out.printf("The truck traveled %.2f km or %.2f miles%n", kmsTraveled, milesTraveled);

        //An interface never gets instantiated, and won't have a subclass that gets instantiated either.

        //Below, our declared type is the same as the instance type, an ArrayList, and we've made the elements in the
        //list FlightEnabled. But ArrayList implements the List interface, and it's recommended to use the interface
        //type for the declared variable.
        ArrayList<FlightEnabled> fliers = new ArrayList<>();
        fliers.add(bird);

        //This time, the declared variable is a List of FlightEnabled elements, and not an ArrayList. List is the
        //interface type. So why is this better?

        //In the two cases above and below, we can swap one type of list to another.

        //If you code to the interface, you know anything that implements the interface has the same set of methods, so
        //making changes can be much easier.

        //Method parameters, method return types, local variable references, and even class variables, should try to
        //use the interface type as the reference variable type whenever possible.

        List<FlightEnabled> betterFliers = new LinkedList<>();
        betterFliers.add(bird);

        triggerFliers(fliers);
        flyFliers(fliers);
        landFliers(fliers);

        triggerFliers(betterFliers);
        flyFliers(betterFliers);
        landFliers(betterFliers);
    }

    private static void inFlight (FlightEnabled flier){

        flier.takeOff();
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

    private static void triggerFliers(List<FlightEnabled> fliers) {

        for(var flier : fliers) {
            flier.takeOff();
        }

    }

    private static void flyFliers(List<FlightEnabled> fliers) {

        for(var flier : fliers) {
            flier.fly();
        }

    }

    private static void landFliers(List<FlightEnabled> fliers) {

        for(var flier : fliers) {
            flier.land();
        }

    }


}

//Interface vs. Abstract Class.

//We saw that abstract class requires its subclasses to implement its abstract methods.

//An interface is similar to an abstract class, although it isn't a class at all.

//It's a special type that's more like a contract between the class and client code that the compiler enforces.

//By declaring its using an interface, your class must implement all the abstract methods on the interface.

//A class agrees to this, because it wants to be known by that type, by the outside world, or the client code.

//An interface lets classes that might have little else in common be recognized as a special reference type.

//Declaring an interface is similar to declaring a class, using the keyword interface where you would use class.

//Below, we're declaring a public interface named FlightEnabled:

//public interface FlightEnabled {}

//An interface is usually named, according to the set of behaviors it describes.

//Many interfaces will end in 'able' like Comparable, and Iterable, again meaning something is capable, or can do, a
//give set of behaviors.

//A class is associated to an interface by using the "implements" clause in the class declaration.

//In the example below, the class Bird implements the FlightEnabled interface:

//public class Bird implements FlightEnabled {}

//Because of this declaration, we can ues FlightEnabled as the reference type, and assign it an instance of bird.

//In the code below, we create a new Bird object, but assign it to the FlightEnabled variable named flier:

//FlightEnabled flier = new Bird();

//********Start of new Video********

//Interfaces can be extended, similar to classes, using th extends keyword.

//Below, we see an interface called OrbitEarth that extends the FlightEnabled interface.

//This interface requires all classes to implement both the OrbitEarth and the FlightEnabled abstract methods.

//interface OrbitEarth extends FlightEnabled{}

//Unlike a class, an interface can use the extends expression with multiple interfaces:

//interface OrbitEarth extends FlightEnabled, Trackable{}

//An interface doesn't implement another interface, so the code below won't compile.

//In other words, implements is an invalid clause in an interface declaration:

//interface OrbitEarth implements FlightEnabled {}

//See Animal class for examples.

//Both interfaces and abstract classes are abstracted reference types.

//Reference types can be used in code as variable types, method parameters, and return types, list types, etc.

//When you use an abstracted reference type, this is referred to as coding to an interface.

//This means your code doesn't use specific types, but more generalized ones, usually an interface type.

//This technique is preferred, because it allows many runtime instances of various classes to be processed uniformly
//by the same code.

//It also allows for substitutions of some other class or object, that still implements the same interface, without
//forcing a major refactor of your code.

//Using interface types as the reference type is considered a best practice.

//CODING TO AN INTERFACE

//Coding to an interface scales well, to support new subtypes, and it helps when refactoring code.

//The downside though is that alterations to the interface may wreak havoc on the client code.

//Imagine you have 50 classes using your interface, and you want ot add an extra abstract method to support new
//functionality.

//As soon as you add a new abstract method, all 50 classes won't compile.

//Your code isn't backwards compatible with this kind of change to an interface.

//Interfaces haven't been easily extensible in the past.

//But Java has made several changes to the Interface type over time to try and address this problem.