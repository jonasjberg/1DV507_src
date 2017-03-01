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


package js224eh_assign3.exercise3;


public class IdentifyWordsMain
{
    static final String SOURCE_TEXT_FILE_PATH =
            "/home/jonas/LNU/1DV507_Datastrukturer/src/1DV507/src" +
            "/js224eh_assign3/exercise3/HistoryOfProgramming.txt";
    static final String DEST_TEXT_FILE_PATH =
            "/home/jonas/LNU/1DV507_Datastrukturer/src/1DV507/src" +
            "/js224eh_assign3/exercise3/words.txt";

    public static void main(String[] args)
    {
        String rawText = readTextFromFilePath(SOURCE_TEXT_FILE_PATH);
        String textLetters = stripAllNonLetters(rawText);
        writeTextToFilePath(textLetters, DEST_TEXT_FILE_PATH);

    }

    private static void writeTextToFilePath(String textLetters,
                                            String destTextFilePath)
    {
        // TODO: Implement ..
    }

    private static String stripAllNonLetters(String rawText)
    {
        // TODO: Implement ..
        return null;
    }

    private static String readTextFromFilePath(String sourceTextFilePath)
    {
        // TODO: Implement ..
        return null;
    }
}
