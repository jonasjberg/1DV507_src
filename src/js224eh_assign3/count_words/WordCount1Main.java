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
import java.util.*;


public class WordCount1Main
{
    static final String DEFAULT_TEXT_FILE_PATH   =
            "/Users/jonas/LNU/1DV507_Datastrukturer/src/1DV507/src" +
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
        HashSet<Word> wordsHashSet = new HashSet<>();
        TreeSet<Word> wordsTreeSet = new TreeSet<>();

        // Read words from a text file on disk, create "Word" objects and
        // add to the list of "Word" objects.
        ArrayList<String> rawWords = readWordsFromFilePath(textFilePath);
        for (String str : rawWords) {
            Word wordObject = new Word(str);
            wordsHashSet.add(wordObject);
            wordsTreeSet.add(wordObject);
        }

        System.out.printf("Using words from file:%n\"%s\"%n%n", textFilePath);

        System.out.println("Size of resulting sets of Word objects:");
        System.out.printf("  HashSet: %d%n", wordsHashSet.size());
        System.out.printf("  TreeSet: %d%n", wordsTreeSet.size());


        System.out.printf("%nIterating over the words in the TreeSet:%n");
        String treeSetText = lineWrapWordSet(wordsTreeSet);
        System.out.println(treeSetText);

        System.out.printf("%nIterating over the words in the HashSet:%n");
        String hashSetText = lineWrapWordSet(wordsHashSet);
        System.out.println(hashSetText);
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

    /**
     * Returns a string with words contained in a Set of words,
     * wrapped at a maximum line length, 'MAX_LINE_LENGTH'.
     *
     * @param wordSet The Set of words to wrap and return.
     * @return The given of words as a string wrapped at 'MAX_LINE_LENGTH'.
     */
    private static String lineWrapWordSet(Set<Word> wordSet)
    {
        final int MAX_LINE_LENGTH = 80;
        int lineLength = 0;
        StringBuilder sb = new StringBuilder();

        for (Word word : wordSet) {
            int wordLength = word.size();
            if (lineLength + wordLength >= MAX_LINE_LENGTH) {
                sb.append("\n");
                lineLength = wordLength;
            } else {
                lineLength += wordLength;
            }

            sb.append(word).append(", ");
        }

        return sb.append("\n").toString();
    }
}

