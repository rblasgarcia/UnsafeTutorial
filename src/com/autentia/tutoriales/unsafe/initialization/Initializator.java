package com.autentia.tutoriales.unsafe.initialization;

public class Initializator {

    private final long value;

    public Initializator() {
        this.value = 1;
    }

    public void printValue() {
        System.out.println(this.value);
    }
}
