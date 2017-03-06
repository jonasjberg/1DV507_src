// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 3: Algorithms, Hashing/BSTs and GUI #2
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-03-04.

// Exercise 7
// ==========
// Repeat Exercise 5 with the new implementations HashWordSet and TreeWordSet.
// The program shall be called WordCount2Main.
// The two notes of Exercise 5 should still be valid.

package js224eh_assign3.count_words;


import java.util.ArrayList;
import java.util.Iterator;

import static js224eh_assign3.count_words.WordCount1Main.readWordsFromFilePath;


public class WordCount2Main
{
    static final String DEFAULT_TEXT_FILE_PATH =
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
        HashWordSet hashWordSet = new HashWordSet();
        TreeWordSet treeWordSet = new TreeWordSet();

        // Read words from a text file on disk, create "Word" objects and
        // add to the list of "Word" objects.
        ArrayList<String> rawWords = readWordsFromFilePath(textFilePath);
        for (String str : rawWords) {
            Word wordObject = new Word(str);
            hashWordSet.add(wordObject);
            treeWordSet.add(wordObject);
        }

        System.out.printf("Using words from file:%n\"%s\"%n%n", textFilePath);

        System.out.println("Size of resulting sets of Word objects:");
        System.out.printf("  TreeWordSet: %d%n", treeWordSet.size());
        System.out.printf("  HashWordSet: %d%n", hashWordSet.size());


        System.out.printf("%nIterating over the words in the TreeSet:%n");
        String treeWordText = lineWrapWordSet(treeWordSet);
        System.out.println(treeWordText);

        System.out.printf("%nIterating over the words in the HashSet:%n");
        String hashWordText = lineWrapWordSet(hashWordSet);
        System.out.println(hashWordText);
    }

    /**
     * Returns a string with words contained in a Set of words,
     * wrapped at a maximum line length, 'MAX_LINE_LENGTH'.
     *
     * @param wordSet The Set of words to wrap and return.
     * @return The given of words as a string wrapped at 'MAX_LINE_LENGTH'.
     */
    public static String lineWrapWordSet(WordSet wordSet)
    {
        final int     MAX_LINE_LENGTH = 80;
        int           lineLength      = 0;
        StringBuilder sb              = new StringBuilder();

        /* TODO: Look over this once more .. */
        Iterator<WordSet> it = wordSet.iterator();

        while (it.hasNext()) {
            Word w = (Word) it.next();
            int wordLength = w.size();

            if (lineLength + wordLength >= MAX_LINE_LENGTH) {
                sb.append("\n");
                lineLength = wordLength;

            } else {
                lineLength += wordLength;
            }

            sb.append(w).append(", ");
        }

        return sb.append("\n").toString();
    }
}
