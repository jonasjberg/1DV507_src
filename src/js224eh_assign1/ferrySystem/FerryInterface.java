// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 1: Inheritance, Recursion and Java 1.8
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-01-26.

package js224eh_assign1.ferrySystem;


import java.util.Iterator;

public interface FerryInterface
{
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
