package com.autentia.tutoriales.unsafe.concurrency.counters;

public interface Counter {

    void increment();

    long getCurrentValue();
}
