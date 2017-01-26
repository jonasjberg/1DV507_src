// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 1: Inheritance, Recursion and Java 1.8
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-01-19.

package js224eh_assign1.intCollection;


public class ArrayIntList extends AbstractIntCollection implements IntList
{
    /**
     * Add integer n to the end of the list.
     *
     * @param n The integer to add.
     */
    @Override
    public void add(int n)
    {
        if (values.length < size()) {
            resize();
        }

        values[size++] = n;
    }

    /**
     * Inserts integer n at position index.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right.
     *
     * @param n     The integer to insert.
     * @param index The position in which to insert integer n.
     * @throws IndexOutOfBoundsException
     */
    @Override
    public void addAt(int n, int index)
            throws IndexOutOfBoundsException
    {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        if (values.length == size()) {
            resize();
        }

        /* Make space for the new element by shifting all elements to the
           right of the inserted elements one position over to the right. */
        for (int i = size; i > index; i--) {
            values[i] = values[i - 1];
        }

        /* Insert the new element at the now empty position. */
        values[index] = n;
        size++;
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException
    {
        /* TODO: implement .. */

    }

    @Override
    public int get(int index) throws IndexOutOfBoundsException
    {
        /* TODO: implement .. */
        return 0;
    }

    @Override
    public int indexOf(int n)
    {
        /* TODO: implement .. */
        return 0;
    }
}
