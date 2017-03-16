// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 4: Generic Classes and More Algorithms
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-03-16.

package js224eh_assign4.time;

public class Stopwatch {
    private long startTime;
    private long stopTime;
    private long estimatedTime;
    private boolean running;

    public Stopwatch()
    {
        running = false;
    }

    public void start()
    {
        startTime = System.nanoTime();
        running = true;
    }

    public void stop()
    {
        if (!running) {
            return;
        }

        stopTime = System.nanoTime();
        running = false;
        estimatedTime = stopTime - startTime;
    }

    public long getRunTime()
    {
        if (running) {
            return 0;
        }

        return estimatedTime;
    }
}
