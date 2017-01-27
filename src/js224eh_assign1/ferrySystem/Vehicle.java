// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 1: Inheritance, Recursion and Java 1.8
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-01-26.

package js224eh_assign1.ferrySystem;


import java.util.ArrayList;


public abstract class Vehicle
{
    protected boolean aboardFerry;
    protected int fee;
    protected ArrayList<Passenger> passengers;

    public Vehicle()
    {
        passengers = new ArrayList<>();
    }

    public int payFeeForVehicle()
    {
        return fee > 0 ? fee : 0;
    }

    public int payFeeForPassengers()
    {
        if (passengers.isEmpty()) {
            return 0;
        }

        int sum = 0;
        for (Passenger p : passengers) {
            sum += p.payFee();
        }
        return sum;
    }
}
