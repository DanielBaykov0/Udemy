package concurrency.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SynchronizationChallenge {

    private static final Random random = new Random();

    public static void main(String[] args) {

        ShoeWarehouseExecutor warehouse = new ShoeWarehouseExecutor();

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                warehouse.receiveOrder(new OrderExecutor(
                        random.nextLong(100000, 9999999),
                        ShoeWarehouseExecutor.PRODUCTS[random.nextInt(0, 5)],
                        random.nextInt(1, 4)
                ));
            }
        });

        producer.start();

        for (int i = 0; i < 2; i++) {
            Thread consumer = new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    OrderExecutor orderExecutor = warehouse.fulfillOrder();
                }
            });

            consumer.start();
        }
    }
}

record Order(long orderId, String shoeType, int quantity) {
}

class ShoeWarehouse {

    public final static String[] PRODUCTS = {"Running Shoes", "Sandals", "Boots", "Slippers", "High Tops"};
    private List<OrderExecutor> orders;

    public ShoeWarehouse() {
        this.orders = new ArrayList<>();
    }

    public synchronized void receiveOrder(OrderExecutor orderExecutor) {
        while (orders.size() > 10) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        orders.add(orderExecutor);
        System.out.println("Incoming " + orderExecutor);
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

        OrderExecutor orderExecutor = orders.remove(0);
        System.out.println(Thread.currentThread().getName() + " - Fulfilled: " + orderExecutor);
        notifyAll();
        return orderExecutor;
    }
}
