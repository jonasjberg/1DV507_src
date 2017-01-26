// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 1: Inheritance, Recursion and Java 1.8
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-01-19.

package js224eh_assign1.intCollection;


public class CollectionMain
{
    public static void main(String[] args)
    {
        ArrayIntList intList = new ArrayIntList();

        printActionMessage("Created a new ArrayIntList:", intList);

        intList.add(1);
        intList.add(5);
        intList.add(1337);
        printActionMessage("Added 1, 42 and 1337 to the array", intList);

        intList.addAt(2, 1);
        printActionMessage("Added 2 to position 1 of the array", intList);

        intList.addAt(6, 0);
        printActionMessage("Added 6 to position 0 of the array", intList);

        intList.remove(3);
        printActionMessage("Removed the integer at position 3 in the array", intList);
    }

    private static void printActionMessage(String message,
                                           AbstractIntCollection intCol)
    {
        System.out.println();
        System.out.println(message);
        System.out.println(intCol.toString());
    }
}
