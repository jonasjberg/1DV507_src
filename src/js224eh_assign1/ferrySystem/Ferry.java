// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 1: Inheritance, Recursion and Java 1.8
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-01-26.

package js224eh_assign1.ferrySystem;


import java.util.ArrayList;
import java.util.Iterator;


public class Ferry implements FerryInterface
{
    // An extra fee that might be added for passengers.
    private final boolean SHOULD_CHARGE_EXTRA_PASSENGER_FEE = false;

    private ArrayList<Vehicle> vehiclesAboard;
    private ArrayList<Passenger> passengersAboard;
    private int maxPassengerCapacity;
    private int maxVehicleCapacity;
    private int moneyEarned;

    public Ferry(int maxPassengerCapacity, int maxVehicleCapacity)
    {
        if (maxPassengerCapacity < 0 || maxVehicleCapacity < 0) {
            throw new IllegalArgumentException("Max capacity must not be < 0");
        }

        this.maxPassengerCapacity = maxPassengerCapacity;
        this.maxVehicleCapacity = maxVehicleCapacity;

        vehiclesAboard = new ArrayList<>();
        passengersAboard = new ArrayList<>();
    }

    private void acceptPayment(int amount)
    {
        if (amount > 0) {
            moneyEarned += amount;
        }
    }

    /**
     * Number of passengers on board.
     *
     * @return The number of passengers currently on board.
     */
    @Override
    public int countPassengers()
    {
        return passengersAboard.size();
    }

    /**
     * Used vehicle space. One car is 1.
     *
     * @return The total space currently occupied by vehicles.
     */
    @Override
    public int countVehicleSpace()
    {
        int spaceOccupied = 0;

        for (Vehicle v : vehiclesAboard) {
            spaceOccupied += v.getSpaceRequired();
        }

        return spaceOccupied;
    }

    /**
     * Earned money
     *
     * @return The total amount of money earned.
     */
    @Override
    public int countMoney()
    {
        return 0;
    }

    /**
     * Vehicle iterator
     *
     * @return
     */
    @Override
    public Iterator<Vehicle> iterator()
    {
        final ArrayList<Vehicle> vehicles = this.vehiclesAboard;

        return new Iterator<Vehicle>() {
            @Override public boolean hasNext()
            {
                return !vehicles.isEmpty();
            }

            @Override public Vehicle next()
            {
                return vehicles.remove(0);
            }
        };
    }

    /**
     * Embark vehicle, warning if not enough space
     *
     * @param v The vehicle to embark.
     */
    @Override
    public void embark(Vehicle v)
    {
        if (vehiclesAboard.contains(v)) {
            return;
        }

        if (!hasSpaceFor(v)) {
            System.out.println("[WARNING] The ferry is filled to capacity -- " +
                               "the vehicle cannot embark!");
            return;
        }

        // Charge for the vehicle itself.
        acceptPayment(v.payVehicleFee());

        // Option to charge an extra fee for the passengers in the vehicle.
        if (SHOULD_CHARGE_EXTRA_PASSENGER_FEE) {
            acceptPayment(v.payPassengerFee());
        }

        vehiclesAboard.add(v);
    }

    /**
     * Embark passenger, warning if not enough room
     *
     * @param p The passenger to embark.
     */
    @Override
    public void embark(Passenger p)
    {
        if (!hasRoomFor(p)) {
            System.out.println("[WARNING] The ferry is filled to capacity -- " +
                               "the passenger cannot embark!");
            return;
        }

        passengersAboard.add(p);
    }

    /**
     * Clear (empty) ferry. The money earned remains, i.e., is not reset to zero
     */
    @Override
    public void disembark()
    {

    }

    /**
     * true if we can embark vehicle v
     *
     * @param v The vehicle to test for fit.
     *
     * @return True if there is space available for vehicle v, else False.
     */
    @Override
    public boolean hasSpaceFor(Vehicle v)
    {
        return countVehicleSpace() < maxVehicleCapacity;
    }

    /**
     * true if we can embark passenger p
     *
     * @param p The passenger to test for available room.-
     *
     * @return True if there is room available for passenger p, else False.
     */
    @Override
    public boolean hasRoomFor(Passenger p)
    {
        return countPassengers() < maxPassengerCapacity;
    }

    @Override
    public String toString()
    {
        String FORMAT = "  %-15.15s : %s%n";
        StringBuilder str = new StringBuilder("{\n  ");
        str.append(this.getClass().getName()).append("\n");

        // Inspired by the ToStringBuilder in "Apache Commons Lang".
        // https://git-wip-us.apache.org/repos/asf?p=commons-lang.git
        str.append(String.format(FORMAT, "instance ID",
                                 Integer.toHexString(
                                         System.identityHashCode(this))));

        str.append(String.format(FORMAT, "Money earned", countMoney()));
        str.append(String.format(FORMAT, "Passengers #", countPassengers()));
        str.append(String.format(FORMAT, "Vehicle space used", countVehicleSpace()));

        Iterator<Vehicle> iterator = iterator();
        StringBuilder itStr = new StringBuilder();

        if (!iterator.hasNext()) {
            itStr.append("(empty)");
        } else {
            while (iterator.hasNext()) {
                Vehicle v = iterator.next();
                itStr.append("[").append(v).append("] ");
            }
        }

        str.append(String.format(FORMAT, "Vehicles on board", itStr.toString()));
        str.append("}");

        return str.toString();
    }
}
