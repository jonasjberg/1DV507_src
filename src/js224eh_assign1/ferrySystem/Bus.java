// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 1: Inheritance, Recursion and Java 1.8
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-01-28.

package js224eh_assign1.ferrySystem;


public class Bus extends Vehicle
{
    public Bus()
    {
        System.out.println("Created a new BUS ..");
    }

    @Override
    public int getVehicleFee()
    {
        return 200;
    }

    @Override
    public int getPerPassengerFee()
    {
        return 10;
    }

    @Override
    public int getSpaceRequired()
    {
        return 20;
    }

    @Override
    public int getPassengerCapacity()
    {
        return 20;
    }
}
