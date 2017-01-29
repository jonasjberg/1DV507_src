// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 1: Inheritance, Recursion and Java 1.8
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-01-28.

package js224eh_assign1.ferrySystem;


public class Lorry extends Vehicle
{
    public Lorry()
    {
        System.out.println("Created a new Lorry ..");
    }

    @Override
    public int getVehicleFee()
    {
        return 300;
    }

    @Override
    public int getPerPassengerFee()
    {
        return 15;
    }

    @Override
    public int getSpaceRequired()
    {
        return 40;
    }

    @Override
    public int getPassengerCapacity()
    {
        return 2;
    }
}
