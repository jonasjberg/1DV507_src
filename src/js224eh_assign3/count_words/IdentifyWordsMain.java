// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 3: Algorithms, Hashing/BSTs and GUI #2
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-03-01.

// Exercise 3
// ==========
//
// Write a program IdentyfyWordsMain that reads a text file(like
// HistoryOfProgramming) and divide the text into a sequence of words (word =
// sequence of letters). All non-letters (except whitespace) should be removed.
// Save the result in a new file (words.txt). Example:
//
//     Text
//     ====
//     Computer programming, History of programming
//     From Wikipedia, the free encyclopedia (081110)
//
//     The earliest known programmable machine (that is a machine whose
//     behavior can be controlled by changes to a
//     "program") was Al-Jazari's programmable humanoid robot in 1206.
//
//     Sequence of words
//     =================
//     Computer programming History of programming
//     From Wikipedia the free encyclopedia
//     The earliest known programmable machine that is a machine whose
//     behavior can be controlled by changes to a
//     program was Al Jazaris programmable humanoid robot in
//
// All exceptions related to file handling shall be handled within the program.

package js224eh_assign3.count_words;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class IdentifyWordsMain
{
    static final String SOURCE_TEXT_FILE_PATH =
            "/home/jonas/LNU/1DV507_Datastrukturer/src/1DV507/src" +
            "/js224eh_assign3/count_words/HistoryOfProgramming.txt";
    static final String DEST_TEXT_FILE_PATH   =
            "/home/jonas/LNU/1DV507_Datastrukturer/src/1DV507/src" +
            "/js224eh_assign3/count_words/words.txt";

    public static void main(String[] args)
    {
        String textWords = readWordsFromFilePath(SOURCE_TEXT_FILE_PATH);
        System.out.println(textWords);
        writeTextToFilePath(textWords, DEST_TEXT_FILE_PATH);
    }

    /**
     * Writes a text string to a file on disk.
     *
     * @param text The text string to write.
     * @param destTextFilePath The path to the written file.
     */
    private static void writeTextToFilePath(String text,
                                            String destTextFilePath)
    {
        if (text.isEmpty()) {
            return;
        }

        PrintWriter output = null;
        try {
            output = new PrintWriter(destTextFilePath);
            output.write(text);
        } catch (FileNotFoundException e) {
            System.err.printf("ERROR: %s%n", e.toString());
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }

    /**
     * Reads words from a text file at a specified path.
     *
     * Only the letters A through Z and spaces are read, any other letters
     * or symbols are ignored. Empty lines are also omitted.
     *
     * @param sourcePath The path of the file to read.
     * @return The words in the specified file as a string.
     */
    private static String readWordsFromFilePath(String sourcePath)
    {
        StringBuilder sb = new StringBuilder();

        Scanner scan = null;
        try {
            scan = new Scanner(new File(sourcePath));

            while (scan.hasNext()) {
                String str = scan.nextLine();

                str = str.replaceAll("[^A-Za-z ]", "");
                if (!str.isEmpty()) {
                    sb.append(str).append("\n");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.printf("ERROR: %s%n", e.toString());
        } finally {
            if (scan != null) {
                scan.close();
            }
        }

        return sb.toString();
    }
}
