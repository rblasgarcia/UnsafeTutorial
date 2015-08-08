package com.autentia.tutoriales.unsafe.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.autentia.tutoriales.unsafe.concurrency.counters.Counter;
import com.autentia.tutoriales.unsafe.concurrency.counters.UnsafeCounter;

public class ConcurrencyMain {

    private static final int NUM_OF_THREADS = 1000;

    private static final int NUM_OF_INCREMENTS = 100000;

    public static void main(String[] args) {

        final ExecutorService service = Executors.newFixedThreadPool(NUM_OF_THREADS);

        Counter counter = createCounter();

        final long before = System.currentTimeMillis();

        runThreads(service, counter);

        service.shutdown();

        try {
            service.awaitTermination(1, TimeUnit.MINUTES);
        } catch (final InterruptedException ie) {

            System.err.println(ie.getMessage());
        }

        final long after = System.currentTimeMillis();

        System.out.println("Valor final del contador: " + counter.getCurrentValue());
        System.out.println("Tiempo trasncurrido: " + (after - before) + " ms");
    }

    private static Counter createCounter() {
        Counter counter = null;
        try {
            counter = new UnsafeCounter();
        } catch (final Exception e) {
            System.err.println(e.getMessage());
        }
        return counter;
    }

    private static void runThreads(final ExecutorService service, final Counter counter) {
        for (int i = 0; i < NUM_OF_THREADS; i++) {
            service.submit(new CounterClient(counter, NUM_OF_INCREMENTS));
        }
    }

}