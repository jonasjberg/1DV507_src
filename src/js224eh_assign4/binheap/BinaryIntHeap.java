// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 4: Generic Classes and More Algorithms
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-03-20.

package js224eh_assign4.binheap;


public class BinaryIntHeap
{
    final static int DEFAULT_CAPACITY = 8;

    private int       size;
    private Integer[] elements;

    /**
     * Constructs a new empty binary int heap.
     */
    public BinaryIntHeap()
    {
        size = 0;
        elements = new Integer[DEFAULT_CAPACITY];
    }

    /**
     * Inserts a integer "newInteger" to the heap.
     *
     * @param newInteger The integer to insert.
     */
    public void insert(Integer newInteger)
    {
        if (newInteger == null) {
            throw new IllegalArgumentException();
        }

        if (size() >= elements.length - 1) {
            resize();
        }

        int position = ++size;
        while (position > 1 &&
               newInteger.compareTo(elements[position / 2]) > 0) {
            elements[position] = elements[position / 2];
            position = position / 2;
        }

        elements[position] = newInteger;
    }

    /**
     * Returns and removes the highest prioritized element.
     *
     * @return The element in this heap with the highest priority.
     */
    public int pullHighest()
    {
        // TODO: Implement ..
        return 0;
    }

    /**
     * Returns the current heap size.
     *
     * @return The current size of this heap.
     */
    public int size()
    {
        return size;
    }

    /**
     * Returns whether the heap is empty or not.
     *
     * @return True if this heap is empty, otherwise False.
     */
    public boolean isEmpty()
    {
        // TODO: Implement ..
        return false;
    }

    /**
     * Resizes the heap in order to fit additional elements.
     */
    private void resize()
    {
        int     size   = (elements.length * 2) - 1;
        Integer temp[] = new Integer[size];

        System.arraycopy(elements, 1, temp, 1, elements.length - 1);
        elements = temp;
    }
}
