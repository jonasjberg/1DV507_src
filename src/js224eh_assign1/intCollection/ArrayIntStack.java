// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 1: Inheritance, Recursion and Java 1.8
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-01-19.

package js224eh_assign1.intCollection;


public class ArrayIntStack extends AbstractIntCollection implements IntStack
{
    /**
     * Add integer at top of stack.
     *
     * @param n The integer to add.
     */
    @Override
    public void push(int n)
    {
        if (values.length == size()) {
            resize();
        }

        values[size++] = n;
    }

    /**
     * Returns and removes integer at top of stack.
     *
     * @return The integer at the top of the stack.
     * @throws IndexOutOfBoundsException
     */
    @Override
    public int pop() throws IndexOutOfBoundsException
    {
        if (size() == 0) {
            throw new IndexOutOfBoundsException();
        }

            int i = values[size - 1];
        size--;
        return i;
    }

    /**
     * Returns without removing integer at top of stack.
     *
     * @return The integer at the top of the stack.
     * @throws IndexOutOfBoundsException
     */
    @Override
    public int peek() throws IndexOutOfBoundsException
    {
        int index = size - 1;
        return values[index];
    }
}
