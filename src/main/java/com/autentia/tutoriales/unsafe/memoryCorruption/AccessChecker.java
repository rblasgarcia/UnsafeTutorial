package com.autentia.tutoriales.unsafe.memoryCorruption;

public class AccessChecker {

    private int ACCESS_ALLOWED = 1;

    public boolean giveAccess() {
        return 42 == ACCESS_ALLOWED;
    }
}
