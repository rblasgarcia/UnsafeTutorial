package com.autentia.tutoriales.unsafe.utilities;

import static org.junit.Assert.fail;

import org.junit.Test;

import sun.misc.Unsafe;

public class UnsafeUtilitiesTest {

    @Test
    public void shouldReturnUnsafeInstance() {

        try {
            final Unsafe unsafe = UnsafeUtilities.getUnsafe();
        } catch (final Exception e) {
            e.printStackTrace();
            fail("No debería haber fallado");
        }

        assertNotNull

    }

}
