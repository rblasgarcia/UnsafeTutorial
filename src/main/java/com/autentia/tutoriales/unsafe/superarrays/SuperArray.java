package com.autentia.tutoriales.unsafe.superarrays;

import com.autentia.tutoriales.unsafe.utilities.UnsafeUtilities;

public class SuperArray {

    private static final int BYTE_SIZE = 1;

    private final long size;

    private final long address;

    public SuperArray(long size) throws Exception {
        this.size = size;
        address = UnsafeUtilities.getUnsafe().allocateMemory(size * BYTE_SIZE);
    }

    public boolean setValueAt(long index, byte value) {

        if (!checkIndex(index)) {
            return false;
        }

        try {

            UnsafeUtilities.getUnsafe().putByte(address + (index * BYTE_SIZE), value);

        } catch (final Exception e) {
            System.err.println(e.getMessage());
            return false;
        }

        return true;
    }

    public Integer getValueAt(long index) {

        if (!checkIndex(index)) {
            return null;
        }

        try {
            return Integer.valueOf(UnsafeUtilities.getUnsafe().getByte(address + (index * BYTE_SIZE)));
        } catch (final Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    private boolean checkIndex(long index) {

        if (index > size || index < 0) {
            return false;
        }
        return true;
    }

    public long size() {
        return size;
    }

    public void destroy() throws Exception {
        UnsafeUtilities.getUnsafe().freeMemory(address);
    }
}
