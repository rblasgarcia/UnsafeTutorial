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

    public static Object objectFromAddress(long address) throws Exception {
        final Object[] array = new Object[] { null };

        final long baseOffset = getUnsafe().arrayBaseOffset(Object[].class);
        getUnsafe().putLong(array, baseOffset, address);

        return array[0];
    }

    public static long addressOfObject(Object o) throws Exception {
        final Object[] array = new Object[] { o };

        final long baseOffset = getUnsafe().arrayBaseOffset(Object[].class);
        final int addressSize = getUnsafe().addressSize();

        return addressByArchitecture(addressSize, array, baseOffset);
    }

    private static long addressByArchitecture(int addressSize, Object[] array, long baseOffset) throws Exception {
        switch (addressSize) {
        case 4:
            return getUnsafe().getInt(array, baseOffset);

        case 8:
            return getUnsafe().getLong(array, baseOffset);

        default:
            throw new Error("unsupported address size: " + addressSize);
        }
    }
}
