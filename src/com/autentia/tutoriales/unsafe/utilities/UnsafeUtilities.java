package com.autentia.tutoriales.unsafe.utilities;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class UnsafeUtilities {

    public static Unsafe getUnsafe() throws Exception {
        final Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        final Unsafe unsafe = (Unsafe)f.get(null);

        return unsafe;
    }
}
