package com.autentia.tutoriales.unsafe.concurrency.counters;

import com.autentia.tutoriales.unsafe.utilities.UnsafeUtilities;

import sun.misc.Unsafe;

public class UnsafeCounter implements Counter {

    private volatile long currentValue = 0;

    private final Unsafe unsafe;

    private final long offset;

    public UnsafeCounter() throws Exception {
        unsafe = UnsafeUtilities.getUnsafe();
        offset = unsafe.objectFieldOffset(UnsafeCounter.class.getDeclaredField("currentValue"));
    }

    @Override
    public void increment() {
        long before = currentValue;
        while (!unsafe.compareAndSwapLong(this, offset, before, before + 1)) {
            before = currentValue;
        }
    }

    @Override
    public long getCurrentValue() {
        return currentValue;
    }

}
