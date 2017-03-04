// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 3: Algorithms, Hashing/BSTs and GUI #2
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-03-04.

package js224eh_assign3.count_words;

import js224eh_assign3.count_words.Word;


// Exercise 6
// ==========
// Given the following interface:

public interface WordSet extends Iterable {
    public void add(Word word);         // Add word if not already added.

    public boolean contains(Word word); // Return true if word contained

    public int size();                  // Return current set size

    public String toString();           // Print contained words
}

// Implement the interface using a) Hashing, b) Binary Search Tree.
//
// In the case of hashing, a rehash shall be performed when the number of
// inserted elements equals the number of buckets.
//
// For the binary search tree, the elements shall be sorted using the method compareTo.
// The names of the two implementations shall be HashWordSet and TreeWordSet.
//
// Note: You are not allowed to use any predefined collection classes from
//       the Java library. However, you are allowed to use arrays.

