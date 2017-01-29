// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 1: Inheritance, Recursion and Java 1.8
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-01-29.

/*
 * Exercise 4
 * ==========
 * Write a program PrintJavaMain that includes a recursive method
 * printAllJavaFiles(File directory) that prints all .java files in the
 * directory and all its sub directories. Both the name of the file and the
 * size, given as the number of rows, should be printed. All exceptions should
 * be handled in the program.
 */

package js224eh_assign1;

import java.io.File;
import java.util.ArrayList;

public class PrintJavaMain
{
    static final String DEFAULT_PATH = "/home/jonas/today/";

    private static int depth = 1;
    private static ArrayList<JavaFile> foundJavaFiles = new ArrayList<>();

    public static void main(String[] args)
    {
        if (args == null || args.length == 0) {
            System.out.printf("Using default path: \"%s\"%n%n", DEFAULT_PATH);
            recurseDirAndPrintJavaFileInfo(DEFAULT_PATH);
        } else {
            recurseDirAndPrintJavaFileInfo(args[0]);
        }
    }

    /**
     * Walks a path looking for files named "*.java" and prints information
     * if any such files are found. The specified path is traversed recursively.
     *
     * @param path The path to walk.
     */
    private static void recurseDirAndPrintJavaFileInfo(String path)
    {
        File startPath = null;
        try {
            startPath = new File(path);
        } catch (Exception e) {
            System.out.printf("[ERROR] %s%n", e.toString());
        }

        if (startPath == null || !startPath.isDirectory()) {
            System.out.println("[ERROR] Please provide a valid starting path!");
            System.exit(1);
        } else {
            // Recurse paths and store results in the ArrayList "foundJavaFiles".
            recursePath(startPath);
        }

        if (foundJavaFiles.isEmpty()) {
            System.out.printf("Found no \"*.java\" files in \"%s\"%n", startPath);

        } else {
            // Sort by file size.
            foundJavaFiles.sort((f1, f2) -> (int) (f1.size - f2.size));

            // Setup output format. Example line below:
            // [####      ] "NewsAgency.java"     (3250 bytes)
            final String FORMAT = "[%-10.10s] " +
                                  "%-" + (JavaFile.nameLengthMax + 2) + "s" +
                                  " (%d bytes)%n";

            // Print results header.
            System.out.printf("%n%s %s%n%n", "THE SEARCH RESULTS",
                              "(sorted by file size, smallest first)");

            // Print results line by line.
            for (JavaFile f : foundJavaFiles) {

                // Map the size to the range 0-10 for use if the bar graph.
                int normalizedSize = (int) (10 * f.size / JavaFile.biggestSize);

                StringBuilder bargraphBuilder = new StringBuilder();
                for (int i = 0; i < normalizedSize; i++) {
                    bargraphBuilder.append("#");
                }

                System.out.printf(FORMAT, bargraphBuilder.toString(),
                                  "\"" + f.name + "\"", f.size);
            }
        }
    }

    /**
     * Walks a path recursively looking for *.java files.
     *
     * Based on example code in lecture slides for lecture #2, pages 18-19.
     * The provided path is walked and all subdirectories are recursively
     * traversed.
     * Path that are files and have a name ending with ".java" are stored
     * in the foundJavaFiles Array as instances of the "JavaFile" class.
     *
     * @param path The path to traverse.
     */
    private static void recursePath(File path)
    {
        if (path.isDirectory()) {
            depth++;

            // Get the contents of "path".
            File[] directoryContents = path.listFiles();
            if (directoryContents != null) {

                // Iterate over the contents if there were any paths within.
                for (File file : directoryContents) {

                    // Recursively handle paths if they are readable.
                    if (file != null && file.canRead()) {
                        recursePath(file);
                    }
                }
            }

            depth--;
        }

        if (path.isFile()) {
            // We only care about files named "*.java".
            String fileName = path.getName();
            if (fileName.endsWith(".java")) {

                // Store the file name and file size in a list of results.
                long fileSize = path.length();
                foundJavaFiles.add(new JavaFile(fileName, fileSize));
            }
        }
    }

    /**
     * Simple class for the search results. Keeps track of names and sizes.
     */
    static class JavaFile
    {
        static int  nameLengthMax = 0;
        static long biggestSize   = 0;
        String name;
        long   size;

        JavaFile(String name, long size)
        {
            this.name = name;
            this.size = size;

            // Used for text column width when printing the results.
            if (name.length() > nameLengthMax) {
                nameLengthMax = name.length();
            }

            // Used for normalizing the bar graph when printing the results.
            if (size > biggestSize) {
                biggestSize = size;
            }
        }
    }
}
