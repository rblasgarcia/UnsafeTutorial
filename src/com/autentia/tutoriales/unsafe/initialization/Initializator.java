package com.autentia.tutoriales.unsafe.initialization;

public class Initializator {

    private final long value; // no inicializada

    public Initializator() {
        this.value = 1; // inicialización
    }

    public void printValue() {
        System.out.println(this.value);
    }
}
