package com.autentia.tutoriales.unsafe.hidepassword;

import java.lang.reflect.Field;

import com.autentia.tutoriales.unsafe.utilities.UnsafeUtilities;

public class HidePassword {

    public static void safe(String password) throws Exception {
        final Field stringValue = String.class.getDeclaredField("value");
        stringValue.setAccessible(true);
        final char[] mem = (char[])stringValue.get(password);
        for (int i = 0; i < mem.length; i++) {
            mem[i] = '?';
        }
    }

    public static void notSafe(String password) throws Exception {
        final String fake = new String(password.replaceAll(".", "?"));

        UnsafeUtilities.getUnsafe().copyMemory(UnsafeUtilities.addressOfObject(fake), UnsafeUtilities.addressOfObject(password),
                password.length());
    }
}
