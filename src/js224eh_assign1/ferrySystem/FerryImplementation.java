// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 1: Inheritance, Recursion and Java 1.8
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-01-26.

package js224eh_assign1.ferrySystem;


import java.util.ArrayList;
import java.util.Iterator;


public class FerryImplementation implements FerryInterface
{
    private ArrayList<Vehicle> vehiclesAboard;
    private ArrayList<Passenger> passengersAboard;
    private int occupiedVehicleSpace;
    private int passengerCount;
    private int moneyEarned;

    public FerryImplementation()
    {
        vehiclesAboard = new ArrayList<>();
        passengersAboard = new ArrayList<>();
        occupiedVehicleSpace = 0;
    }

    @Override
    public int countPassengers()
    {
        return 0;
    }

    @Override
    public int countVehicleSpace()
    {
        return 0;
    }

    @Override
    public int countMoney()
    {
        return 0;
    }

    @Override
    public Iterator<Vehicle> iterator()
    {
        return null;
    }

    @Override
    public void embark(Vehicle v)
    {
        if (vehiclesAboard.contains(v)) {
            return;
        }

        vehiclesAboard.add(v);
        moneyEarned += v.ge
    }

    @Override
    public void embark(Passenger p)
    {

    }

    @Override
    public void disembark()
    {

    }

    @Override
    public boolean hasSpaceFor(Vehicle v)
    {
        return false;
    }

    @Override
    public boolean hasRoomFor(Passenger p)
    {
        return false;
    }
}
