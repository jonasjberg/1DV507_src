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

    // Is the vehicle aboard the ferry or not? Assume not at instantiation.
    protected boolean aboardFerry;

    /**
     * Constructor common to all vehicles.
     */
    public Vehicle()
    {
        passengers = new ArrayList<>();
        aboardFerry = false;
    }

    // Cost for the vehicle alone, differs for each type of vehicle.
    public abstract int getVehicleFee();

    // Cost per passenger riding the vehicle, differs for each type of vehicle.
    public abstract int getPerPassengerFee();

    // Space required expressed as a multiple of the space occupied by a car.
    public abstract int getSpaceRequired();

    // Maximum number of passengers.
    public abstract int getPassengerCapacity();

    /**
     * Asks this vehicle to pay its vehicle-specific fee.
     *
     * @return The fee as a positive integer.
     */
    public int payVehicleFee()
    {
        return getVehicleFee() > 0 ? getVehicleFee() : 0;
    }

    /**
     * Asks this vehicle to pay its vehicle-specific fee for the passengers
     * in this vehicle. Calculated as: (numberPassengers * perPassengerFee)
     *
     * @return The fee as a positive integer.
     */
    public int payPassengerFee()
    {
        if (passengers.isEmpty() || getPerPassengerFee() <= 0) {
            return 0;
        }

        return passengers.size() * getPerPassengerFee();
    }

    public boolean isAboardFerry()
    {
        return aboardFerry;
    }

    @Override
    public String toString()
    {
        final String FORMAT = "    %-20.20s : %s%n";
        StringBuilder str = new StringBuilder("\n    ");
        str.append(this.getClass().getName()).append("\n");

        // Inspired by the ToStringBuilder in "Apache Commons Lang".
        // https://git-wip-us.apache.org/repos/asf?p=commons-lang.git
        str.append(String.format(FORMAT, "instance ID",
                                 Integer.toHexString(
                                         System.identityHashCode(this))));

        str.append(String.format(FORMAT, "Aboard ferry", isAboardFerry()));
        str.append(String.format(FORMAT, "Space required", getSpaceRequired()));
        str.append(String.format(FORMAT, "Passenger capacity", getPassengerCapacity()));
        //str.append(String.format(FORMAT, "Vehicle fee", fe()));
        //str.append(String.format(FORMAT, "Per passenger fee", countVehicleSpace()));

        return str.toString();
    }
}
