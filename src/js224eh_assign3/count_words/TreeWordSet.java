// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 3: Algorithms, Hashing/BSTs and GUI #2
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-03-06.

// Exercise 6
// ==========

package js224eh_assign3.count_words;


import java.util.Iterator;
import java.util.Stack;


public class TreeWordSet implements WordSet
{
    private BST root = null;
    private int nodeCount;

    public TreeWordSet()
    {
        nodeCount = 0;
    }

    @Override
    public void add(Word word)
    {
        if (root == null) {
            root = new BST(word);
        } else if (!contains(word)) {
            root.add(word);
            nodeCount++;
        }
    }

    @Override
    public boolean contains(Word word)
    {
        return root != null && root.contains(word);
    }

    @Override
    public int size()
    {
        return nodeCount;
    }

    @Override
    public Iterator iterator()
    {
        return new TreeWordSetIterator(root);
    }

    /**
     * Private inner class "BST" represents a node in the tree.
     */
    private class BST
    {
        Word data;
        BST left  = null;
        BST right = null;

        BST(Word word)
        {
            data = word;
        }

        void add(Word word)
        {
            int comparisonResult = word.compareTo(data);

            if (comparisonResult < 0) {
                /* Add to left branch. */
                if (left == null) {
                    left = new BST(word);
                } else {
                    left.add(word);
                }
            } else if (comparisonResult > 0) {
                /* Add to right branch. */
                if (right == null) {
                    right = new BST(word);
                } else {
                    right.add(word);
                }
            }
        }

        /**
         * Test if this tree node contains a specific element.
         *
         * Uses a recursive look-up.
         *
         * @param word The element to find.
         * @return True if this node contains the given element.
         */
        boolean contains(Word word)
        {
            int comparisonResult = word.compareTo(data);

            if (comparisonResult < 0) {
                /* Search left branch. */
                if (left == null) {
                    return false;
                } else {
                    return left.contains(word);
                }
            } else if (comparisonResult > 0) {
                /* Search right branch. */
                if (right == null) {
                    return false;
                } else {
                    return right.contains(word);
                }
            }

            /* Found! */
            return true;
        }
    }


    private class TreeWordSetIterator implements Iterator
    {
        private Stack<BST> stack = new Stack<>();
        private BST current;

        private TreeWordSetIterator(BST root)
        {
            current = root;
        }

        @Override
        public boolean hasNext()
        {
            return (!stack.isEmpty() || current != null);
        }

        @Override
        public Word next()
        {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            BST node = current;
            current = current.right;

            return node.data;
        }
    }
}
