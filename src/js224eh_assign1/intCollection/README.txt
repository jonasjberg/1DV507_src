~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
1DV507 -- Programming and Data Structures, VT2017
Assignment 1: Inheritance, Recursion and Java 1.8
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Created by Jonas Sjöberg (js224eh) on 2017-01-26.

Exercise 1
==========
The zipped directory int_collection.zip contains an abstract class
AbstractIntCollection and two interfaces IntList and IntStack. The abtract class
contains support for developing array-based data structures. The two interfaces
define the functionality of an integer list and an integer stack.
Your task is to implement the two interfaces by inheriting the support provided
by the abstract class and by adding the code required for each individual data
structure.
That is, provide two classes ArrayIntList and ArrayIntStack with the following
signatures.

    public class ArrayIntList extends AbstractIntCollection implements IntList

    public class ArrayIntStack extends AbstractIntCollection implements IntStack

Additionally, write a program CollectionMain that demonstrates how the two
classes can be used.

Notice: The two classes must make use of the abstract class and you are not
        allowed to make any changes (not a sing
