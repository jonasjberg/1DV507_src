// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 1: Inheritance, Recursion and Java 1.8
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-01-26.

package js224eh_assign1.ferrySystem;


import java.util.ArrayList;


public abstract class Vehicle
{
    // The passengers riding is this vehicle.
    protected ArrayList<Passenger> passengers;

    // Is the vehicle aboard the ferry or not?
    protected boolean aboardFerry;

    // Cost for the vehicle alone, differs for each type of vehicle.
    protected int vehicleFee;

    // Cost per passenger riding the vehicle, differs for each type of vehicle.
    protected int perPassengerFee;

    // Space required expressed as a multiple of the space occupied by a car.
    protected int spaceRequired;

    // Maximum number of passengers.
    protected int passengerCapacity;

    public Vehicle()
    {
        passengers = new ArrayList<>();
    }

    public int payFeeForVehicle()
    {
        return vehicleFee > 0 ? vehicleFee : 0;
    }

    public int payFeeForPassengers()
    {
        if (passengers.isEmpty() || perPassengerFee <= 0) {
            return 0;
        }

        return passengers.size() * perPassengerFee;
    }

    public int getSpaceRequired()
    {
        return spaceRequired > 0 ? spaceRequired : 0;
    }

    public int getPassengerCapacity()
    {
        return passengerCapacity > 0 ? passengerCapacity : 0;
    }
}
