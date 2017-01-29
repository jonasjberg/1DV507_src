// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 1: Inheritance, Recursion and Java 1.8
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-01-29.

/*
 *  Exercise 9
 *  ----------
 *  The (very large) file WarAndPeace.txt contains the entire text of the book
 *  War and Peace by the russian author Leo Tolstoy. Your task is to write a
 *  single-class program WarAndPeace.java that, once you have split the text
 *  into separate words, use a single Java 1.8 stream to compute the number of
 *  unique words used in the text. Words are substrings made of ordinary letters
 *  and the characters ' (as in don't) and - (as in well- known). Other type of
 *  characters (e.g. digits) should be removed from each word as well as entire
 *  words only containing such characters. Also, we do not care about upper and
 *  lower case when looking for unique words. Hence, HELLO and Hello are
 *  considered to be the same word.
 *
 *  The first lines in your code should look something like:
 *
 *    String text = readText("WarAndPeace.txt"); // My own method
 *    String[] words = text.split(" "); // Simple split, will be cleaned up later on
 *    System.out.println("Initial word count: "+words.length); // We found 577091
 *
 *    Stream stream = Arrays.stream(words);
 *    ... continue here
 */

package js224eh_assign1;


import java.util.Arrays;
import java.util.stream.Stream;


public class WarAndPeace
{
    public static void main(String[] args)
    {
        String text = readText("WarAndPeace.txt");
        String[] words = text.split(" ");
        System.out.println("Initial word count: " + words.length);

        Stream stream = Arrays.stream(words);
    }
}
