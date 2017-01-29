// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 1: Inheritance, Recursion and Java 1.8
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-01-26.

package js224eh_assign1.ferrySystem;


import java.util.Random;


/**
 * Demonstrates the Ferry implementation and the other "ferrySystem" classes.
 */
public class FerryMain
{
    final static int MAX_PASSENGER_CAPACITY = 200;
    final static int MAX_VEHICLE_CAPACITY = 200;

    public static void main(String[] args)
    {
        Ferry ferry = new Ferry(MAX_PASSENGER_CAPACITY, MAX_VEHICLE_CAPACITY);
        System.out.println(ferry);

        Car car1 = new Car();
        Car car2 = new Car();
        ferry.embark(car1);
        ferry.embark(car2);

        car1.leaveFerry(ferry);

        Passenger p1 = new Passenger();
        Passenger p2 = new Passenger();
        ferry.embark(p1);
        ferry.embark(p2);
        System.out.println(ferry);

        ferry.embark(new Car());
        System.out.println(ferry);

        ferry.embark(new Bicycle());
        ferry.embark(new Bicycle());
        System.out.println(ferry);

        ferry.embark(new Lorry());
        ferry.embark(new Bus());
        System.out.println(ferry);

        embarkPassengers(ferry, 195);
        System.out.println(ferry);

        embarkPassengers(ferry, 5);
        System.out.println(ferry);

        embarkRandomVehicles(ferry, 50);
        System.out.println(ferry);

        ferry.disembark();
        System.out.println(ferry);
    }

    /**
     * Embark a specified number of vehicle types on a specified ferry.
     *
     * The type of vehicle (subclass of the Vehicle class) is randomized.
     *
     * @param ferry The ferry the vehicles embark.
     * @param numberOfVehicles The number of vehicles to embark.
     */
    private static void embarkRandomVehicles(Ferry ferry, int numberOfVehicles)
    {
        if (numberOfVehicles > 0) {
            Random random = new Random();

            for (int i = 0; i < numberOfVehicles; i++) {
                switch (random.nextInt(4)) {
                    case 0:
                        ferry.embark(new Bicycle());
                        break;
                    case 1:
                        ferry.embark(new Bus());
                        break;
                    case 2:
                        ferry.embark(new Car());
                        break;
                    case 3:
                        ferry.embark(new Lorry());
                        break;
                }
            }
        }


    }

    /**
     * Embark a specified number of passengers on a specified ferry.
     *
     * @param ferry The ferry the passengers embark.
     * @param numberOfPassengers The number of passengers to embark.
     */
    private static void embarkPassengers(Ferry ferry, int numberOfPassengers)
    {
        if (numberOfPassengers > 0) {
            for (int i = 0; i < numberOfPassengers; i++) {
                ferry.embark(new Passenger());
            }
        }
    }
}
