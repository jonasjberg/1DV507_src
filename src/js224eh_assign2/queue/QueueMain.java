// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 2: Data Structures, JUnit, and JavaFX1
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-02-06.

// Exercise 1

package js224eh_assign2.queue;


import java.util.NoSuchElementException;


public class QueueMain
{
    private static LinkedQueue queue;

    public static void main(String[] args)
    {
        queue = new LinkedQueue();

        System.out.println("Created a new empty queue:");
        printQueueInfo(queue);

        System.out.println("Enqueuing three objects ..");
        queue.enqueue("object 1");
        queue.enqueue("object 2");
        queue.enqueue("object 3");
        printQueueInfo(queue);

        System.out.println("Dequeuing an object ..");
        Object o1 = queue.dequeue();
        System.out.println("Got object from queue: " + o1);
        printQueueInfo(queue);

        System.out.println("Dequeuing an object ..");
        Object o2 = queue.dequeue();
        System.out.println("Got object from queue: " + o2);
        printQueueInfo(queue);

    }

    private static void printQueueInfo(Queue queue)
    {
        final String FORMAT = "%10.10s: %-60.60s%n";

        System.out.println("{");
        System.out.printf(FORMAT, "Contents", queue.toString());
        System.out.printf(FORMAT, "Empty", queue.isEmpty() ? "True" : "False");
        System.out.printf(FORMAT, "Size", queue.size());

        String first = queue.isEmpty() ? "N/A" : String.valueOf(queue.first());
        String last = queue.isEmpty() ? "N/A" : String.valueOf(queue.last());
        System.out.printf(FORMAT, "First", first);
        System.out.printf(FORMAT, "Last", last);

        System.out.println("}");
        System.out.println();
    }
}
