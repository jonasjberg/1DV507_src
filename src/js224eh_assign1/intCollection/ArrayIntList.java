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
        addAt(n, size());
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
        if (index < 0 || index > size()) {
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

    /**
     * Remove integer at position index.
     *
     * @param index The index of the integer to remove.
     * @throws IndexOutOfBoundsException
     */
    @Override
    public void remove(int index) throws IndexOutOfBoundsException
    {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        /* Shift all elements starting with the element at position "index"
         * to the left. Essentially overwriting the removed element. */
        for (int i = index; i < size() - 1; i++) {
            values[i] = values[i + 1];
        }

        size--;
    }

    /**
     * Get integer at position index.
     *
     * @param index The position of the integer to get.
     * @return The integer at position index.
     * @throws IndexOutOfBoundsException
     */
    @Override
    public int get(int index) throws IndexOutOfBoundsException
    {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        return values[index];
    }

    /**
     * Find position of integer n, otherwise return -1.
     *
     * @param n The integer whose posiition is searched.
     * @return The position of integer n.
     */
    @Override
    public int indexOf(int n)
    {
        for (int i = 0; i < size(); i++) {
            if (values[i] == n) {
                return i;
            }
        }

        return -1;
    }
}
