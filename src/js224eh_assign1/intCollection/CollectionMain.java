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

        System.out.println("ArrayIntList Demonstration");
        System.out.println("==========================");
        printActionMessage("Created a new ArrayIntList", intList);

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

        System.out.println("\nDemonstrates getting the element at index n");
        System.out.println("intList.get(2): " + intList.get(2));

        System.out.println("\nDemonstrates getting the index of an element");
        System.out.println("intList.indexOf(1337): " + intList.indexOf(1337));
        System.out.println("intList.indexOf(42): " + intList.indexOf(42));

        System.out.println("\nWill attempt to add 0 to the element at " +
                           "index 1337, expecting an exception to be thrown.");
        try {
            intList.addAt(0, 1337);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught exception: " + e);
        }

        System.out.println("\nWill attempt to get the element at " +
                           "index 1337, expecting an exception to be thrown.");
        try {
            int n = intList.get(1337);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught exception: " + e);
        }


        System.out.println("\n");
        System.out.println("ArrayIntStack Demonstration");
        System.out.println("===========================");
        ArrayIntStack intStack = new ArrayIntStack();
        printActionMessage("Created a new ArrayIntStack", intStack);

        intStack.push(1);
        printActionMessage("Pushed 1 to the stack", intStack);

        intStack.push(2);
        printActionMessage("Pushed 2 to the stack", intStack);

        int m = intStack.pop();
        printActionMessage("Popped the stack and got: " + m, intStack);

        intStack.push(3);
        printActionMessage("Pushed 3 to the stack", intStack);

        int n = intStack.peek();
        printActionMessage("Peeked the stack and got: " + n, intStack);

        int o = intStack.pop();
        printActionMessage("Popped the stack and got: " + o, intStack);

        int p = intStack.pop();
        printActionMessage("Popped the stack and got: " + p, intStack);

        System.out.println("\nWill attempt to pop the empty stack, " +
                           "expecting an exception to be thrown.");
        try {
            int q = intStack.pop();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught exception: " + e);
        }

        System.out.println("\nWill attempt to peek the empty stack, " +
                           "expecting an exception to be thrown.");
        try {
            int h = intStack.peek();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught exception: " + e);
        }
    }

    private static void printActionMessage(String message,
                                           AbstractIntCollection intCol)
    {
        System.out.println();
        System.out.println(message);
        System.out.println("Elements: " + intCol.toString());
        System.out.println("    Size: " + intCol.size());
        System.out.println("   Empty: " + (intCol.isEmpty() ? "Yes" : "No"));
    }
}
