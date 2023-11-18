package concurrency.challenges;

public class ThreadChallenge {

    public static void main(String[] args) {

        SubThread subThread = new SubThread();
        subThread.start();

        Thread runnableThread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                if (i % 2 != 0) {
                    System.out.println("Runnable Thread " + i);
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Runnable Thread interrupted!");
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });

        runnableThread.start();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        subThread.interrupt();
    }
}

class SubThread extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println("SubThread " + i);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("SubThread interrupted!");
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
