package concurrency.multithreading;

import java.util.concurrent.TimeUnit;

class StopWatch {

    private TimeUnit timeUnit;
    private int i;

    StopWatch(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public void countDown() {
        countDown(5);
    }

    public void countDown(int unitCount) {
        String threadName = Thread.currentThread().getName();

        ThreadColor threadColor = ThreadColor.ANSI_RESET;

        try {
            threadColor = ThreadColor.valueOf(threadName);
        } catch (IllegalArgumentException ignore) {

        }

        String color = threadColor.color();
        for (i = unitCount; i > 0; i--) {
            try {
                timeUnit.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.printf("%s%s Thread : i = %d%n", color, threadName, i);
        }
    }
}

public class MultipleThreads {

    public static void main(String[] args) {

        // TIme Slicing
        /*  Technique used in multitasking operating systems to allow multiple threads
            or processes to share a single CPU for execution. Available CPU time is sliced
            into small time intervals, which are divided out of the threads. Each thread
            gets that interval, to attempt to make some progress, on the tasks it has to do.
            Whether it completes its task or not, in that time slice, doesn't matter to the thread
            management system. When the time is up, it has to yield to another thread, and
            wait until its turn.
         */

        StopWatch stopWatch = new StopWatch(TimeUnit.SECONDS);
        Thread green = new Thread(stopWatch::countDown, ThreadColor.ANSI_GREEN.name());
        Thread purple = new Thread(() -> stopWatch.countDown(7), ThreadColor.ANSI_PURPLE.name());
        Thread red = new Thread(stopWatch::countDown, ThreadColor.ANSI_RED.name());
        green.start();
        purple.start();
        red.start();
    }
}
