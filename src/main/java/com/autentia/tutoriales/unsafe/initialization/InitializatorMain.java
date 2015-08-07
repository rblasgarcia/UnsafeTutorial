package com.autentia.tutoriales.unsafe.initialization;

import com.autentia.tutoriales.unsafe.utilities.UnsafeUtilities;

public class InitializatorMain {

    public static void main(String[] args) throws Exception {
        final Initializator o1 = new Initializator(); // inicializa
        o1.printValue(); // 1

        final Initializator o2 = (Initializator)UnsafeUtilities.getUnsafe().allocateInstance(Initializator.class); // no
                                                                                                                   // inicializa
        o2.printValue(); // 0
    }

}
