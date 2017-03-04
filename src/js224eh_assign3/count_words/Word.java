// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 3: Algorithms, Hashing/BSTs and GUI #2
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-03-01.

// Exercise 4
// ==========
// Create a class Word, representing a word. Two words should be considered
// equal if they consist of the same sequence of letters and we consider upper
// case and lower case as equal. For example hello, Hello and HELLO are
// considered to be equal. The methods equals and hashCode define the meaning of
// "equality". Thus, the class Word should look like the following.
//
// public class Word implements Comparable<Word> {
//     private String word;

//     public Word(String str) { ... }
//     public String toString() { return word; }
//
//     /* Override Object methods */
//     public int hashCode() { ... compute a hash value for word }
//     public boolean equals(Object other) { ... true if two words are equal }
//
//     /* Implement Comparable */
//     public int compareTo(Word w) { ... compares two words lexicographically }
// }
//
// NOTE:
// * If you want, you can add more methods. The methods mentioned above are the
//   minimum requirement.
// * Exercise 5 and onward is based on Exercise 4. Thus, carefully test all
//   methods before proceeding.

package js224eh_assign3.count_words;


import java.util.Objects;


/**
 * The class "Word" represents a word.
 */
public class Word implements Comparable<Word>
{
    private String word;

    /**
     * Creates a new instance of the "Word" class.
     *
     * @param string This word as a text string.
     */
    public Word(String string)
    {
        word = string;
    }

    /**
     * Returns a "normalized" string; a cleanup version
     *
     * for simplified parsing, comparison and other operations.
     * Simply lowers the letter case as-is, but could include character set
     * decoding, ligature removal, umlaut removal etc.
     *
     * @return A normalized version of the string.
     */
    public String getNormalizedString()
    {
        return word.toLowerCase();
    }

    /**
     * Returns the number of letters in the word.
     *
     * @return The number of letters in this word.
     */
    public int size()
    {
        return word.length();
    }

    /**
     * Returns a human-readable string representation of the word.
     *
     * @return The Word state and date as a text string.
     */
    @Override
    public String toString()
    {
        return word;
    }

    /**
     * Returns a hash sum that uniquely reflects the state and
     * data stored in a Word-object.
     *
     * @return A hash sum for this word.
     */
    @Override
    public int hashCode()
    {
        //return Objects.hash(word);
        return this.getNormalizedString().hashCode();
    }

    /**
     * Test a book and another object for equality.
     *
     * @param o The object to test against this book.
     * @return True if the books are equal, otherwise False.
     */
    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Word word1 = (Word) o;
        return getNormalizedString().equals(word1.getNormalizedString());
    }

    /**
     * Compare this word against another word by doing a lexicographical
     * comparison on the "normalized" versions; simply lower-cased for now.
     * The 'String.compareTo()' method performs a lexicographical comparison
     * by default.
     */
    @Override
    public int compareTo(Word word)
    {
        return -word.getNormalizedString().compareTo(this.getNormalizedString());
    }
}
