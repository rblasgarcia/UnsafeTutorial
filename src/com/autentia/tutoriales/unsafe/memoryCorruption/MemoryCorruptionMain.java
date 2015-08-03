package com.autentia.tutoriales.unsafe.memoryCorruption;

import java.lang.reflect.Field;

import com.autentia.tutoriales.unsafe.utilities.UnsafeUtilities;

import sun.misc.Unsafe;

public class MemoryCorruptionMain {

    public static void main(String[] args) {
        final AccessChecker guard = new AccessChecker();
        System.out.println(guard.giveAccess()); // false

        // conseguimos true
        try {
            final Unsafe unsafe = UnsafeUtilities.getUnsafe();
            final Field f = guard.getClass().getDeclaredField("ACCESS_ALLOWED");
            unsafe.putInt(guard, unsafe.objectFieldOffset(f), 42); // corrupción de memoria

            System.out.println(guard.giveAccess()); // true, accedemos
        } catch (final Exception e) {
            System.err.println(e.getMessage());
        }

    }

}
