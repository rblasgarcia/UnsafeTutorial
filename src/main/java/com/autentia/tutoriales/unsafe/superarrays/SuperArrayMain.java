package com.autentia.tutoriales.unsafe.superarrays;

public class SuperArrayMain {

    public static void main(String[] args) {
        final long HUGE_SIZE = (long)Integer.MAX_VALUE * 2;

        SuperArray superArray = null;

        try {
            superArray = new SuperArray(HUGE_SIZE);
        } catch (final Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Tamaño de Array: " + superArray.size());

        putValuesinArray(superArray);

        printChargedValues(superArray);

        try {
            superArray.destroy();
        } catch (final Exception e) {
            System.err.println(e.getMessage());
        }

    }

    private static void putValuesinArray(SuperArray superArray) {

        for (int i = 0; i < 100; i++) {
            final long pos = (long)Integer.MAX_VALUE + i;

            superArray.setValueAt(pos, (byte)3);
        }
    }

    private static void printChargedValues(SuperArray superArray) {
        for (int i = 0; i < 100; i++) {
            final long pos = (long)Integer.MAX_VALUE + i;
            System.out.println("Valor en posicion [" + pos + "]: " + superArray.getValueAt(pos));
        }

    }
}
