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
    // An extra fee that might be added for passengers.
    private final boolean CHARGE_EXTRA_PASSENGER_FEE = false;

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

    private void chargeMoney(int amount)
    {
        if (amount > 0) {
            moneyEarned += amount;
        }
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

        // Charge for the vehicle itself.
        chargeMoney(v.payFeeForVehicle());

        // Option to charge an extra fee for the passengers in the vehicle.
        if (CHARGE_EXTRA_PASSENGER_FEE) {
            chargeMoney(v.payFeeForPassengers());
        }

        vehiclesAboard.add(v);
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
