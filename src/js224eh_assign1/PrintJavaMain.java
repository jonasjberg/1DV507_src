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
import java.util.Collections;


public class PrintJavaMain
{
    static final String DEFAULT_PATH = "/home/jonas/today/";


    public static void main(String[] args)
    {
        if (args == null || args.length == 0) {
            recurseDirAndPrintJavaFileInfo(DEFAULT_PATH);
        } else {
            recurseDirAndPrintJavaFileInfo(args[0]);
        }
    }


    private static void recurseDirAndPrintJavaFileInfo(String path)
    {
        File startPath = null;
        try {
            startPath = new File(path);
        } catch (Exception e) {
            System.out.printf("[ERROR] %s%n", e.toString());
        }

        // Recurse paths and store results  in
        if (startPath != null && startPath.exists() && startPath.isDirectory()) {
            recursePath(startPath);
        } else {
            System.out.println("Please provide a valid starting path.");
        }

        if (foundJavaFiles.isEmpty()) {
            System.out.printf("Found no \"*.java\" files in \"%s\"", startPath);

        } else {

            // Sort by file size comparison.
            foundJavaFiles.sort((f1, f2) -> (int) (f1.size - f2.size));

            // Setup output string formatting.
            final int nameFieldWidth = JavaFile.longestFilenameLength + 2;
            final String FORMAT = "[%-10.10s] " + "%-" + nameFieldWidth + "s" + " (%d bytes)%n";

            // Print results header.
            System.out.printf("%s%n%s%n%n", "THESE ARE THE SEARCH RESULTS",
                              "(sorted by file size, smallest first)");

            // Print results line by line.
            for (JavaFile f : foundJavaFiles) {
                int normalizedSize = (int) (10 * f.size / JavaFile.biggestSize);

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < normalizedSize; i++) {
                    sb.append("#");
                }

                System.out.printf(FORMAT, sb.toString(), "\"" + f.name + "\"", f.size);
            }
        }
    }

    static class JavaFile
    {
        static int  longestFilenameLength = 0;
        static long biggestSize = 0;
        String name;
        long size;

        JavaFile(String name, long size)
        {
            this.name = name;
            this.size = size;

            // Used for text column width when printing the results.
            if (name.length() > longestFilenameLength) {
                longestFilenameLength = name.length();
            }

            // Used for normalizing the bar graph when printing the results.
            if (size > biggestSize) {
                biggestSize = size;
            }
        }
    }

    private static int depth = 1;
    private static ArrayList<JavaFile> foundJavaFiles = new ArrayList<>();

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
            String fileName  = path.getName();
            if (fileName.endsWith(".java")) {

                // Store the file name and file size in a list of results.
                long fileSize = path.length();
                foundJavaFiles.add(new JavaFile(fileName, fileSize));
            }
        }
    }
}
