// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 4: Generic Classes and More Algorithms
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-03-13.

package js224eh_assign4.exercise1;


import java.util.Iterator;

/*
 * Exercise 1
 * ==========
 * In Assignment 2 you were asked to provide a linked implementation of
 * the following queue interface:
 *
 *   public interface Queue {
 *     public int size();                    // current queue size
 *     public boolean isEmpty();             // true if queue is empty
 *     public void enqueue(Object element);  // add element at end of queue
 *     public Object dequeue();              // return and remove first element
 *     public Object first();                // return (without removing) first element
 *     public Object last();                 // return (without removing) last element
 *     public String toString();             // return a string representation of the queue content
 *     public Iterator<Object> iterator();   // element iterator
 *   }
 *
 * Tasks:
 * - Provide a similar _generic_ queue interface named Queue<T>.
 * - Provide a linked _generic_ queue named LinkedQueue<T> that implements
 *   the interface Queue<T> using the _head-and-tail_ approach.
 * - Write a JUnit test program QueueTest for you generic queue
 *   implementation. Make sure that you are using at least two parameter
 *   types (e.g. Integer and String) in your tests.
 *
 * You are of course allowed to reuse your own non-generic queue
 * implementation/test from Assignment 2. However, make sure to take into
 * account all comments given to you by your teaching assistant when he/she
 * corrected it.
 */

public interface Queue<T>
{
    /**
     * Gets the current size of the queue, I.E. the number of enqueued elements.
     *
     * @return The number of elements stored in this queue.
     */
    public int size();

    /**
     * Returns whether the queue is empty or not.
     *
     * @return True if this queue is empty, otherwise False.
     */
    public boolean isEmpty();

    /**
     * Adds an element to the queue. The element is added to the back of
     * the queue; FIFO -- First In First Out.
     *
     * @param element The element to add to this queue.
     */
    public void enqueue(T element);

    /**
     * Removes an element from the queue. The element that was enqueued first
     * is returned; FIFO -- First In First Out.
     *
     * @return The next element in line in this queue.
     */
    public T dequeue();

    /**
     * Returns the first element of the queue, without removing it.
     *
     * @return The first element in this queue.
     */
    public T first();

    /**
     * Returns the last element of the queue, without removing it.
     *
     * @return The last element in this queue.
     */
    public T last();

    /**
     * Returns a human readable textual representation of the queue.
     *
     * @return A string representation of this queue.
     */
    public String toString();

    /**
     * Returns an element iterator for the queue.
     *
     * @return An element iterator for this queue.
     */
    public Iterator<T> iterator();
}

/*
 * The iterator iterates over all elements of the queue. Operations not
 * allowed on an empty queue shall generate an unchecked exception.
 *
 * Tasks:
 * - Create a linked implementation LinkedQueue.java of the interface Queue.
 *   Use the head-and-tail approach.
 * - Write also a program QueueMain.java showing how all methods work.
 * - Create Javadoc comments in the code and generate good-looking and
 *   extensive HTML documentation for the interface and the class.
 *   All public class members shall be documented.
 *
 * Notice:
 * - The implementation shall be linked, i.e. a sequence of linked nodes
 *   where each node represents an element.
 * - You are not allowed to use any of the predefined collection classes in
 *   the Java library.
 * - In the report, the HTML pages generated by the classes Queue and
 *   LinkedQueue shall be attached. Attach no other HTML pages!
 */

