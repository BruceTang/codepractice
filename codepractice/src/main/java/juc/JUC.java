package juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class JUC {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        AtomicLong atomicLong = new AtomicLong();
        atomicLong.addAndGet(1);

        LongAdder longAdder = new LongAdder();
        longAdder.add(1);

        Object[] objects = new Object[2];
        System.out.println(objects[0]);

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                MyThread.sleep(1000*5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
            }).thenApply(s -> s + "world");

        System.out.println(".....");
        System.out.println(future.get());

    }

}
