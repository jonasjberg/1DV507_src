~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
1DV507 -- Programming and Data Structures, VT2017
Assignment 1: Inheritance, Recursion and Java 1.8
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Created by Jonas Sjöberg (js224eh) on 2017-01-26.

Exercise 2
==========
In the following exercise you should create a number of classes to solve a
problem. The exercise description is rather vague, more of a sketchy scenario
than a concrete problem specification. Your task is to create the necessary
classes to simulate this scenario. All classes should be properly documented
and encapsulated. Your task is to create a programming system for a ferry. The
ferry transports passengers and vehicles (cars, busses, lorries and bicycles).
The ferry has space for 200 passengers and 40 cars. A lorry needs as much space
as two busses or 8 cars. A car needs as much space as 5 bicycles. There are
different fees for different vehicles and an extra fee might be added for
passengers.

Use the following fees:

    1. Passenger without vehicle, 20 kr.
    2. Bicycle 40 kr                  (passenger included)
    3. Car 100 kr + 15 kr/passenger   (maximum 4 passengers)
    4. Bus 200 kr + 10 kr/passenger   (maximum 20 passengers)
    5. Lorry 300 kr + 15 kr/passenger (maximum 2 passengers)


Each type of vehicle (car, bus, lorry, bicycle) will inherit from the class
Vehicle.


The functionality of the ferry is given by the interface Ferry:

public interface Ferry  {
   int countPassengers();             // Number of passengers on board
   int countVehicleSpace();           // Used vehicle space. One car is 1.
   int countMoney();                  // Earned money
   Iterator<Vehicle> iterator();      // Vehicle iterator
   void embark(Vehicle v);            // Embark vehicle, warning if not enough space
   void embark(Passenger p);          // Embark passenger, warning if not enough room
   void disembark();                  // Clear (empty) ferry. The money earned remains,
                                      // i.e., is not reset to zero
   boolean hasSpaceFor(Vehicle v);    // true if we can embark vehicle v
   boolean hasRoomFor(Passenger p);   // true if we can embark passenger p
   String toString();                 // Nice looking ferry status print out

}


A vehicle cannot leave the ferry until the ferry has been disembarked and the
same vehicle cannot embark twice.

The ferry iterator should iterate over all vehicles embarked (not the
passengers).

Also write a program FerryMain.java, embarking a number of vehicles and
passengers, showing the functionality of the methods.
