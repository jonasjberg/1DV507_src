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
 *    String[] words = text.split(" "); // Simple split, will be cleaned up
 *    later on
 *    System.out.println("Initial word count: "+words.length); // We found
 *    577091
 *
 *    Stream stream = Arrays.stream(words);
 *    ... continue here
 */

package js224eh_assign1;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;


public class WarAndPeace
{
    static final String TEXT_FILE_PATH =
            "/home/jonas/LNU/1DV507_Datastrukturer/src/1DV507/src" +
            "/js224eh_assign1/WarAndPeace.txt";

    public static void main(String[] args)
    {
        String   text  = readText(TEXT_FILE_PATH);
        String[] words = text.split(" ");
        System.out.println("Initial word count: " + words.length);

        Stream<String> stream = Arrays.stream(words);

        long count = stream.map(s -> s.trim())
                           .map(String::toLowerCase)
                           .map(word -> word.replaceAll("[^a-zA-Z\'-]", ""))
                           .filter(s -> s.length() > 0)
                           .distinct()
                           .count();

        System.out.printf("Number of unique words: %d%n", count);
    }

    /**
     * Reads text from a path and returns the contents.
     *
     * Lifted pretty much as-is from eample in the slides for Lecture #3
     * in the course 1DV507 at Linnaeus University, page 24.
     *
     * @param path The path to the file to read.
     * @return The contents of the file at path as a string.
     */
    private static String readText(String path)
    {
        String contents = null;
        try {
            contents = new String(Files.readAllBytes(Paths.get(path)),
                                  StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.printf("[ERROR] %s%n", e.toString());
        }

        return contents;
    }
}
