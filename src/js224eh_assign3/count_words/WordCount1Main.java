// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 3: Algorithms, Hashing/BSTs and GUI #2
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-03-01.

// Exercise 5
// ==========
// Create a program WordCount1Main doing the following:
//
// For each word in the file word.txt:
//
//     1. Create an object of the class Word
//     2. Add the object to a set of the type java.util.HashSet
//     3. Add the object to a set of the type java.util.TreeSet
//
// Note:
// 1. The size of the sets should correspond to the number of different words in
//    the files. (Our tests gave 350 words for the file HistoryOfProgramming)
// 2. An iteration over the words in the TreeSet should give the words in
//    alphabetical order.
// 3. Since our definition of a word is not very precise (similar to the
//    WarAndPeace exercise in Assignment 2), we do not expect all of you to end
//    up with exactly 350 words. But it should be rather close.

package js224eh_assign3.count_words;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class WordCount1Main
{
    static final String DEFAULT_TEXT_FILE_PATH   =
            "/home/jonas/LNU/1DV507_Datastrukturer/src/1DV507/src" +
            "/js224eh_assign3/count_words/words.txt";

    public static void main(String[] args)
    {
        String textFilePath;

        if (args.length == 0) {
            textFilePath = DEFAULT_TEXT_FILE_PATH;
        } else {
            textFilePath = args[0];
        }

        // Create an empty list of "Word" objects.
        ArrayList<Word> words = new ArrayList<>();

        // Read words from a text file on disk, create "Word" objects and
        // add to the list of "Word" objects.
        ArrayList<String> rawWords = readWordsFromFilePath(textFilePath);
        for (String w : rawWords) {
            // System.out.println(w);
            words.add(new Word(w));
        }

        System.out.println(words);
    }

    /**
     * Reads words from a text file at a specified path.
     *
     * Only the letters A through Z and spaces are read, any other letters
     * or symbols are ignored. Empty lines are also omitted.
     * The read words are split by whitespace and added to a list.
     *
     * @param sourcePath The path of the file to read.
     * @return The words in the specified file as an ArrayList of strings.
     */
    private static ArrayList<String> readWordsFromFilePath(String sourcePath)
    {
        ArrayList<String> words = new ArrayList<>();

        Scanner scan = null;
        try {
            scan = new Scanner(new File(sourcePath));

            while (scan.hasNext()) {
                String str = scan.nextLine();

                str = str.replaceAll("[^A-Za-z ]", "");
                if (!str.isEmpty()) {
                    for (String s : str.split("\\s")) {
                        words.add(s);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.printf("ERROR: %s%n", e.toString());
        } finally {
            if (scan != null) {
                scan.close();
            }
        }

        return words;
    }
}
