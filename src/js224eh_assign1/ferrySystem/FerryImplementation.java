// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 1: Inheritance, Recursion and Java 1.8
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-01-26.

package js224eh_assign1.ferrySystem;


import java.util.Iterator;


public class FerryImplementation implements FerryInterface
{
    private int occupiedSpace;

    public FerryImplementation()
    {
        occupiedSpace = 0;
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
