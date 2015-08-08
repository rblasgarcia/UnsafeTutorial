package com.autentia.tutoriales.unsafe.concurrency;

import com.autentia.tutoriales.unsafe.concurrency.counters.Counter;

public class CounterClient implements Runnable {

    private final Counter counter;

    private final int maxIncrement;

    public CounterClient(Counter counter, int value) {
        this.counter = counter;
        this.maxIncrement = value;
    }

    @Override
    public void run() {
        for (int i = 0; i < maxIncrement; i++) {
            counter.increment();
        }
    }

}
