// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 3: Algorithms, Hashing/BSTs and GUI #2
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-03-04.

// Exercise 6
// ==========

package js224eh_assign3.count_words;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * This class borrows heavily from the 1DV507 Lecture #8 lecture notes 
 * by Jonas Lundberg. Some parts are copied as-is or with only minor
 * modifications.
 */
public class HashWordSet implements WordSet {

    private int size;
    private Node[] buckets;

    /**
     * Private inner class "Node" represents a "bucket" in the hash set.
     */
    private class Node {
        Word data;
        Node next = null;

        public Node(Word word) {
            data = word;
        }

        public String toString() {
            return data.toString();
        }
    }

    @Override
    public void add(Word word) {
        int pos = getBucketNumber(word);

        /* First node in list. */
        Node node = buckets[pos];

        while (node != null) {
            if (node.data.equals(word)) {
                /* Element found. */
                return;
            } else {
                /* Next node in list. */
                node = node.next;
            }
        }

        /* Not found, add new node as first element. */
        node = new Node(word);
        node.next = buckets[pos];
        buckets[pos] = node;
        size++;

        /* Rehash if needed. */
        if (size == buckets.length) {
            rehash();
        }
    }

    private int getBucketNumber(Word word) {
        /* Use hashCode() from String class, get absolute value
           and pass through simple hash function. */
        int hashCode = word.hashCode();
        if (hashCode < 0) {
            hashCode = -hashCode;
        }

        return hashCode % buckets.length;
    }

    private void rehash() {
        /* Get a copy of the old "buckets". */
        Node[] temp = buckets;

        /* Create a new, empty "buckets". */
        buckets = new Node[2 * temp.length];
        size = 0;

        /* Insert old values into new buckets. */
        for (Node n : temp) {
            if (n == null) {
                /* Empty bucket. */
                continue;
            }

            while (n != null) {
                /* Add elements back. */
                add(n.data);
                n = n.next;
            }
        }
    }

    @Override
    public boolean contains(Word word) {
        int pos = getBucketNumber(word);
        Node node = buckets[pos];

        while (node != null) {
            /* Search the list for element "word". */
            if (node.data.equals(word)) {
                /* Found! */
                return true;
            } else {
                node = node.next;
            }
        }

        /* Not found. */
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    /**
     * Returns an element iterator for the queue.
     *
     * @return An element iterator for this queue.
     */
    @Override
    public Iterator<Object> iterator()
    {
        return new Iterator<Object>()
        {
            // TODO: Implement iterator.

            private Node current;

            @Override
            public boolean hasNext()
            {
                return false;
            }

            @Override
            public Object next()
            {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                Object data = current.data;
                current = current.next;
                return data;
            }

            @Override
            public void remove()
            {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public Spliterator spliterator() {
        return null;
    }
}
