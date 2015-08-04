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
            corruptField(guard);

            System.out.println(guard.giveAccess()); // true
        } catch (final Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static void corruptField(AccessChecker guard) throws Exception {
        final Unsafe unsafe = UnsafeUtilities.getUnsafe();
        final Field f = guard.getClass().getDeclaredField("ACCESS_ALLOWED");
        unsafe.putInt(guard, unsafe.objectFieldOffset(f), 42); // corrupción de memoria
    }
}
