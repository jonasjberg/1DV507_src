// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 1: Inheritance, Recursion and Java 1.8
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-01-27.

package js224eh_assign1.ferrySystem;


public class Car extends Vehicle
{
    public Car()
    {
        System.out.println("Created a new CAR ..");
    }

    @Override
    public int getVehicleFee()
    {
        return 100;
    }

    @Override
    public int getPerPassengerFee()
    {
        return 15;
    }

    @Override
    public int getSpaceRequired()
    {
        return 5;
    }

    @Override
    public int getPassengerCapacity()
    {
        return 4;
    }
}
