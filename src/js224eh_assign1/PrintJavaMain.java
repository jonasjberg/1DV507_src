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
import java.util.Comparator;


public class PrintJavaMain
{
    static final String DEFAULT_PATH = "/home/jonas/today/";


    public static void main(String[] args)
    {
        if (args == null || args.length == 0) {
            recurseDirAndPrintJavaFileInfo(DEFAULT_PATH);
        }
    }


    private static void recurseDirAndPrintJavaFileInfo(String path)
    {
        File file = null;
        try {
            file = new File(path);
        } catch (Exception e) {
            System.out.printf("[ERROR] %s%n", e.toString());
        }

        if (file.exists() && file.isDirectory()) {
            recursePath(file);
        } else {
            System.out.println("Please provide a valid directory");
        }

        if (foundJavaFiles.isEmpty()) {
            System.out.printf("Found no \"*.java\" files in \"%s\"", file);
        } else {
            Collections.sort(foundJavaFiles,
                             (f1, f2) -> (int) (f1.size - f2.size));

            for (JavaFile f : foundJavaFiles) {
                System.out.printf("\"%s\" (%d bytes)%n", f.name, f.size);
            }
        }
    }


    static class JavaFile
    {
        public String name;
        public long size;

        public JavaFile(String name, long size)
        {
            this.name = name;
            this.size = size;
        }
    }

    private static int depth = 1;
    private static ArrayList<JavaFile> foundJavaFiles = new ArrayList<>();

    private static void recursePath(File path)
    {
        if (path.isDirectory()) {
            depth++;

            File[] directoryContents = path.listFiles();
            if (directoryContents != null) {
                for (File file : directoryContents) {
                    if (file != null) {
                        recursePath(file);
                    }
                }
            }

            depth--;
        }

        if (path.isFile()) {
            String fileName  = path.getName();
            if (fileName.endsWith(".java")) {
                long fileSize = path.length();
                foundJavaFiles.add(new JavaFile(fileName, fileSize));
            }
        }
    }
}
