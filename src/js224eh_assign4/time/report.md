Assignment 4: Generic Classes and More Algorithms
-------------------------------------------------
`1DV507` --- Programming and Data Structures, Spring 2017.


Created by Jonas Sjöberg (`js224eh`) on 2017-03-20.



Exercise 4 -- Report
====================


Instructions
------------

> Write a short report about your experiments in Exercises 2 and 3. 
> 
> For each experiment:
> 
> * Describe how you did your experiment.
> * Show a table of your results.
> 
> Also, try to explain why `StringBuilder` is much faster than string
> concatenation using the `+` operator.


Experiment Description
----------------------
I first created some utility functions for timing and logging results to the
terminal. My main concern was that the test "harness" code should be written as
to minimize its influence on the test results.  The code that executes after
the timing measurement has started should ideally be only the code under test.
However, in order to keep track of execution time, I used a simple class
`Stopwatch` that _will_ influence the results slightly with the polling of the
`hasTimeLeft()` method. This class uses `System.nanoTime` and simply compares a
certain starting time with the current time. 

I have written a couple of games in Java and they all used `System.nanoTime` in
the main update-loop for calculating frames per second and when the graphics
should be redrawn, etc.

Each test is performed 5 times and the results are then averaged.  This is to
slightly counteract unwanted interactions from other running systems, however,
a more sophisticated setup is needed if high precision measurements are needed.
For instance, my IDE uses the Java Virtual Machine and executing the tests
through the IDE means some kind of wrapper code is used to control my running
code through GUI "Run"- and "Stop"-buttons.

It would probably be best to run the compiled classes directly from a terminal.
