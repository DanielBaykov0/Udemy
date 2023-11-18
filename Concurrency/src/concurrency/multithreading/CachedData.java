package concurrency.multithreading;

import java.util.concurrent.TimeUnit;

public class CachedData {

    // volatile keyword fixes the issue
    /*  It's an indicator that this variable's value may be changed
        by multiple threads. This modifier ensures that the variable
        is always read from, and written to the main memory, rather
        than from any thread-specific caches.

        When to use:
        - when a variable is used to track the state of a shared resource,
            such as a counter or a flag
        - when a variable is used to communicate between threads
     */
    private boolean flag = false;

    public static void main(String[] args) {

        // Memory Consistency Errors
        /*  The operating system may read from heap variables,
            and make a copy of the value, in each thread's own storage cache.
            Each thread has its own small and fast memory storage, that holds
            its own copy of a shared resource's value. One thread can modify
            a shared variable, but this change might not be immediately
            reflected or visible. Instead, it's first updated in the thread's
            local cache. The operating system may not flush the first thread's
            changes to the heap, until the thread has finished executing.
         */

        CachedData example = new CachedData();

        Thread writerThread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            example.toggleFlag();
            System.out.println("A. Flag set to " + example.isReady());
        });

        Thread readerThread = new Thread(() -> {
            while (!example.isReady()) {

            }

            System.out.println("B. Flag is " + example.isReady());
        });

        writerThread.start();
        readerThread.start();
    }

    public void toggleFlag() {
        flag = !flag;
    }

    public boolean isReady() {
        return flag;
    }
}
