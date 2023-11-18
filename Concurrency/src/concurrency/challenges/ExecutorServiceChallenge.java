package concurrency.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceChallenge {

    private static final Random random = new Random();

    public static void main(String[] args) {

        ShoeWarehouseExecutor warehouse = new ShoeWarehouseExecutor();

        ExecutorService orderingService = Executors.newCachedThreadPool();

        Callable<OrderExecutor> orderingTask = () -> {
            {
                OrderExecutor newOrder = generateOrder();
                try {
                    Thread.sleep(random.nextInt(500, 5000));
                    warehouse.receiveOrder(newOrder);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                return newOrder;
            }
        };

//        List<Callable<OrderExecutor>> tasks = Collections.nCopies(15, orderingTask);
//        try {
//            orderingService.invokeAll(tasks);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        try {
            for (int i = 0; i < 15; i++) {
                Thread.sleep(random.nextInt(500, 2000));
                orderingService.submit(() -> warehouse.receiveOrder(generateOrder()));
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        orderingService.shutdown();
        try {
            orderingService.awaitTermination(6, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        warehouse.shutDown();
    }

    private static OrderExecutor generateOrder() {
        return new OrderExecutor(
                random.nextLong(100000, 9999999),
                ShoeWarehouseExecutor.PRODUCTS[random.nextInt(0, 5)],
                random.nextInt(1, 4));
    }
}

record OrderExecutor(long orderId, String shoeType, int quantity) {
}

class ShoeWarehouseExecutor {

    public final static String[] PRODUCTS = {"Running Shoes", "Sandals", "Boots", "Slippers", "High Tops"};
    private final ExecutorService fulfillmentService;
    private List<OrderExecutor> orders;

    public ShoeWarehouseExecutor() {
        this.orders = new ArrayList<>();
        fulfillmentService = Executors.newFixedThreadPool(3);
    }

    public void shutDown() {
        fulfillmentService.shutdown();
    }

    public synchronized void receiveOrder(OrderExecutor order) {
        while (orders.size() > 10) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        orders.add(order);
        System.out.println(Thread.currentThread().getName() + " - Incoming " + order);
        fulfillmentService.submit(this::fulfillOrder);
        notifyAll();
    }

    public synchronized OrderExecutor fulfillOrder() {
        while (orders.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        OrderExecutor order = orders.remove(0);
        System.out.println(Thread.currentThread().getName() + " - Fulfilled: " + order);
        notifyAll();
        return order;
    }
}
