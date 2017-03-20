// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 4: Generic Classes and More Algorithms
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-03-20.

package js224eh_assign4.binheap;


/**
 * Based on code from:
 *
 *   "Data Structures And Algorithm Analysis In Java", 3rd Edition.
 *      Weiss M.A., 2011, AddisonWesley.
 *
 *   "Data Structures and Algorithms in Java", 5th Edition.
 *      Goodrich M.T. Tamassia R., 2010, Wiley.
 *
 *   "1DV507 - Lecture 10 - Generic Classes, Time Measurement, Binary Heaps"
 *      Lecture slides by Dr. Jonas Lundberg, 2017-02-27.
 */
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

        int hole = ++size;
        while (hole > 1 &&
               newInteger.compareTo(elements[hole / 2]) > 0) {
            elements[hole] = elements[hole / 2];
            hole = hole / 2;
        }

        elements[hole] = newInteger;
    }

    /**
     * Returns and removes the highest prioritized element.
     *
     * Based on code from:
     *
     *   "Data Structures And Algorithm Analysis In Java", 3rd Edition.
     *      Weiss M.A., 2011, AddisonWesley.
     *
     *   "Data Structures and Algorithms in Java", 5th Edition.
     *      Goodrich M.T. Tamassia R., 2010, Wiley.
     *
     * @return The element in this heap with the highest priority.
     */
    public int pullHighest()
    {
        Integer highest = elements[1];

        /* Place the last number in the root node. */
        Integer temp = elements[size()];
        elements[1] = temp;
        elements[size] = null;
        size--;

        /* Fixes the tree by checking the child and move the last added element
           until the heap property is fulfilled. */
        int nodeOne = 1;
        while (nodeOne < size && (nodeOne * 2) < elements.length) {
            int posTwo = nodeOne * 2;

            /* If "nodeOne" has two child nodes and the left one is bigger. */
            if (nodeExists(posTwo) && nodeExists(posTwo + 1) &&
                elements[posTwo] < elements[posTwo + 1]) {
                posTwo++;
            }

            /* If there are no suitable children left .. */
            if (elements[posTwo] == null) {
                break;
            }
            if (temp.compareTo(elements[posTwo]) < 0) {
                elements[nodeOne] = elements[posTwo];
                elements[posTwo] = temp;
                nodeOne = posTwo;
            } else {
                break;
            }
        }

        return highest;
    }

    /**
     * Checks whether a node at a specified index exists, as in the the index
     * lies within the allocated range and the node at that index is not NULL.
     *
     * @param index The index of the node to test.
     * @return True if the index is valid and the node is defined, else False.
     */
    private boolean nodeExists(int index)
    {
        return (index < elements.length) && elements[index] != null;
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
        return size() == 0;
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
