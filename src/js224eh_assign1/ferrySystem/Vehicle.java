// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 1: Inheritance, Recursion and Java 1.8
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-01-26.

package js224eh_assign1.ferrySystem;


import java.util.ArrayList;
import java.util.Iterator;


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

    /* Normalize the unit of vehicle sizes to the size of the smallest
       vehicle, the bicycle. Otherwise we would have to use a floating
       point number to store the space required for a bicycle --- 0.2

       Which means:            The ferry has 200 sizeUnits of space
                               ((40 cars) * (5*car per bicycle))

       Which translates to:    | Vehicle | Space needed |
                               |---------|--------------|
                               | Bicycle |  1 sizeUnits |
                               | Car     |  5 sizeUnits |
                               | Bus     | 20 sizeUnits |
                               | Lorry   | 40 sizeUnits |
     */

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

    /**
     * Tests whether this Vehicle is aboard a specified ferry.
     *
     * @param ferry The ferry to test.
     * @return True if this vehicle is aboard the specified ferry.
     */
    public boolean isAboardFerry(Ferry ferry)
    {
        Iterator<Vehicle> iterator = ferry.iterator();

        while (iterator.hasNext()) {
            Vehicle v = iterator.next();

            if (v.equals(this)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Have this vehicle leave the ferry.
     *
     * @param ferry The ferry to leave.
     */
    public void leaveFerry(Ferry ferry)
    {
        if (!isAboardFerry(ferry)) {
            System.out.println("The vehicle has left the ferry!");
        } else {
            System.out.println("[WARNING] The vehicle is unable to leave the " +
                               "ferry -- the ferry must first disembark!");
        }
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

        str.append(String.format(FORMAT, "Aboard ferry", aboardFerry));
        str.append(String.format(FORMAT, "Space required", (float) getSpaceRequired() / 5));
        str.append(String.format(FORMAT, "Passenger capacity", getPassengerCapacity()));
        //str.append(String.format(FORMAT, "Vehicle fee", fe()));
        //str.append(String.format(FORMAT, "Per passenger fee", countVehicleSpace()));

        return str.toString();
    }
}
