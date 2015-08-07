package com.autentia.tutoriales.unsafe.concurrency.counters;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class ReentrantReadWriteLockCounter implements Counter {

    private long currentValue = 0;

    private final WriteLock lock = new ReentrantReadWriteLock().writeLock();

    @Override
    public void increment() {
        lock.lock();
        currentValue++;
        lock.unlock();
    }

    @Override
    public long getCurrentValue() {
        return currentValue;
    }
}
