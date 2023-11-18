package concurrency.executor;

import concurrency.multithreading.ThreadColor;

import java.util.List;
import java.util.concurrent.*;

public class Executor {

    public static void main(String[] args) {

        var multiExecutor = Executors.newCachedThreadPool();
        List<Callable<Integer>> taskList = List.of(
                () -> Executor.sum(1, 10, 1, "red"),
                () -> Executor.sum(10, 100, 10, "blue"),
                () -> Executor.sum(2, 20, 2, "green")
        );
        try {
            var results = multiExecutor.invokeAll(taskList);
            for (var result : results) {
                System.out.println(result.get(500, TimeUnit.MILLISECONDS));
            }
        } catch (InterruptedException | TimeoutException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            multiExecutor.shutdown();
        }
    }

    public static void cachedmain(String[] args) {

        var multiExecutor = Executors.newCachedThreadPool();
        try {
            var redValue = multiExecutor.submit(() -> Executor.sum(1, 10, 1, "red"));
            var blueValue = multiExecutor.submit(() -> Executor.sum(10, 100, 10, "blue"));
            var greenValue = multiExecutor.submit(() -> Executor.sum(2, 20, 2, "green"));

            try {
                System.out.println(redValue.get(500, TimeUnit.SECONDS));
                System.out.println(blueValue.get(500, TimeUnit.SECONDS));
                System.out.println(greenValue.get(500, TimeUnit.SECONDS));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } finally {
            multiExecutor.shutdown();
        }
    }

    public static void fixedmain(String[] args) {

        int count = 6;
        var multiExecutor = Executors.newFixedThreadPool(
                3, new ColorThreadFactory()
        );

        for (int i = 0; i < count; i++) {
            multiExecutor.execute(Executor::countDown);
        }

        multiExecutor.shutdown();
    }

    public static void singlemain(String[] args) {

        var blueExecutor = Executors.newSingleThreadExecutor(
                new ColorThreadFactory(ThreadColor.ANSI_BLUE)
        );
        blueExecutor.execute(Executor::countDown);
        blueExecutor.shutdown();

        boolean isDone = false;
        try {
            isDone = blueExecutor.awaitTermination(500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (isDone) {
            System.out.println("Blue finished, starting Yellow");
            var yellowExecutor = Executors.newSingleThreadExecutor(
                    new ColorThreadFactory(ThreadColor.ANSI_YELLOW)
            );
            yellowExecutor.execute(Executor::countDown);
            yellowExecutor.shutdown();

            try {
                isDone = yellowExecutor.awaitTermination(500, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        if (isDone) {
            System.out.println("Yellow finished, starting Red");
            var redExecutor = Executors.newSingleThreadExecutor(
                    new ColorThreadFactory(ThreadColor.ANSI_RED)
            );
            redExecutor.execute(Executor::countDown);
            redExecutor.shutdown();

            try {
                isDone = redExecutor.awaitTermination(500, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (isDone) {
                System.out.println("All processes completed");
            }
        }
    }

    public static void notmain(String[] args) {

        Thread blue = new Thread(
                Executor::countDown, ThreadColor.ANSI_BLUE.name()
        );

        Thread yellow = new Thread(
                Executor::countDown, ThreadColor.ANSI_YELLOW.name()
        );

        Thread red = new Thread(
                Executor::countDown, ThreadColor.ANSI_RED.name()
        );

        blue.start();

        try {
            blue.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        yellow.start();

        try {
            yellow.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        red.start();

        try {
            red.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void countDown() {
        String threadName = Thread.currentThread().getName();
        var threadColor = ThreadColor.ANSI_RESET;
        try {
            threadColor = ThreadColor.valueOf(threadName.toUpperCase());
        } catch (IllegalArgumentException ignore) {

        }

        String color = threadColor.color();
        for (int i = 20; i >= 0; i--) {
            System.out.println(color + " " +
                    threadName.replace("ANSI_", "") + " " + i);
        }
    }

    private static int sum(int start, int end, int delta, String colorString) {
        var threadColor = ThreadColor.ANSI_RESET;
        try {
            threadColor = ThreadColor.valueOf("ANSI_" +
                    colorString.toUpperCase());
        } catch (IllegalArgumentException ignore) {

        }

        String color = threadColor.color();
        int sum = 0;
        for (int i = start; i <= end; i += delta) {
            sum += i;
        }

        System.out.println(color + Thread.currentThread().getName() + ", " +
                colorString + " " + sum);
        return sum;
    }
}

class ColorThreadFactory implements ThreadFactory {

    private String threadName;
    private int colorValue = 1;

    public ColorThreadFactory(ThreadColor color) {
        this.threadName = color.name();
    }

    public ColorThreadFactory() {
    }

    @Override
    public Thread newThread(Runnable r) {

        Thread thread = new Thread(r);
        String name = threadName;
        if (name == null) {
            name = ThreadColor.values()[colorValue].name();
        }

        if (++colorValue > (ThreadColor.values().length - 1)) {
            colorValue = 1;
        }

        thread.setName(name);
        return thread;
    }
}
