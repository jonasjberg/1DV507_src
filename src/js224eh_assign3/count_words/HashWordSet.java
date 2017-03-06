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

    private final int STARTING_SIZE = 8;

    private int size;
    private Node[] buckets = new Node[STARTING_SIZE];

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

        /* Search the list in this bucket for a matching entry. */
        while (node != null) {
            if (node.data.equals(word)) {
                /* Element found in the list at this bucket number. */
                return;
            } else {
                /* Point to the next node in the list. */
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

    /**
     * Find the bucket number for a specific Word.
     *
     * @param word The word whose bucket to find.
     * @return The bucket number for "word".
     */
    private int getBucketNumber(Word word) {
        /* Use hashCode() from String class, get absolute value
           and pass through simple hash function. */
        int hashCode = word.hashCode();
        if (hashCode < 0) {
            hashCode = -hashCode;
        }

        return hashCode % buckets.length;
    }

    /**
     * Rehashes the set.
     * Moves the current contents into a container that is twice as large.
     */
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
        return size;
    }

    private class HashWordSetIterator implements Iterator<Word> {

        private Node[] buckets;
        private int currentBucket;
        private int previousBucket;
        private Node currentNode;
        private Node previousNode;


        public HashWordSetIterator() {
            currentNode = null;
            previousNode = null;
            currentBucket = -1;
            previousBucket = -1;
        }

        /**
         * Determine if there are non-null entries in the hash set.
         *
         * @return True if the iterator has an additional element available.
         */
        @Override
        public boolean hasNext() {
            if (currentNode != null && currentNode.next != null) {
                return true;
            }

            for (int i = currentBucket + 1; i < buckets.length; i++) {
                if (buckets[i] != null) {
                    return true;
                }
            }

            return false;
        }

        @Override
        public Word next() {
            previousNode = currentNode;
            previousBucket = currentBucket;

            if (currentNode == null || currentNode.next == null) {
                currentBucket++;

                while (currentBucket < buckets.length && buckets[currentBucket] == null) {
                    currentBucket++;
                }

                if (currentBucket < buckets.length) {
                    currentNode = buckets[currentBucket];
                } else {
                    throw new NoSuchElementException();
                }
            } else {
                currentNode = currentNode.next;
            }

            return currentNode.data;
        }

        @Override
        public void remove() {
            if (previousNode != null && previousNode.next == currentNode) {
                previousNode.next = currentNode.next;
            } else if (previousBucket < currentBucket) {
                buckets[currentBucket] = currentNode.next;
            } else {
                throw new IllegalStateException();
            }

            currentNode = previousNode;
            currentBucket = previousBucket;
        }

        // @Override
        // public void forEachRemaining(Consumer<? super Word> action) { }
    }

    /**
     * Returns an element iterator for the queue.
     *
     * @return An element iterator for this queue.
     */
    @Override
    public Iterator iterator() {
        return new HashWordSetIterator();
    }

    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public Spliterator spliterator() {
        return null;
    }
}
