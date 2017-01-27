// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 1: Inheritance, Recursion and Java 1.8
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-01-26.

package js224eh_assign1.ferrySystem;


public class FerryMain
{
    final static int MAX_PASSENGER_CAPACITY = 200;
    final static int MAX_VEHICLE_CAPACITY = 40;

    public static void main(String[] args)
    {
        Car car1 = new Car();
        Car car2 = new Car();

        Passenger p1 = new Passenger();
        Passenger p2 = new Passenger();

        Ferry ferry = new Ferry(MAX_PASSENGER_CAPACITY, MAX_VEHICLE_CAPACITY);

        System.out.println(ferry);

        ferry.embark(p1);
        ferry.embark(p2);

        ferry.embark(car1);
        ferry.embark(car2);

        System.out.println(ferry);
    }
}
