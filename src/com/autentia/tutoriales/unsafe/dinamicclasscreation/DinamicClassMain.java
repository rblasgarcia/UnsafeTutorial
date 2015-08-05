package com.autentia.tutoriales.unsafe.dinamicclasscreation;

import java.io.File;
import java.io.FileInputStream;

import com.autentia.tutoriales.unsafe.utilities.UnsafeUtilities;

public class DinamicClassMain {

    private static final String FILE_PATH = "/Users/rodrideblas/tmp/DinamicClass.class";

    public static void main(String[] args) {
        byte[] classContents;
        final String message = "Clase dinámica creada";
        try {
            classContents = getClassContent(FILE_PATH);

            final Class dinamicClass = UnsafeUtilities.getUnsafe().defineClass(null, classContents, 0,
                    classContents.length, null, null);

            // imprime 'Clase Dinámica creada'
            dinamicClass.getMethod("printMessage", String.class).invoke(dinamicClass.newInstance(), message);
        } catch (final Exception e) {
            System.err.println(e.getMessage());
        }

    }

    private static byte[] getClassContent(String filePath) throws Exception {
        final File f = new File(filePath);
        final FileInputStream input = new FileInputStream(f);

        final byte[] content = new byte[(int)f.length()];
        input.read(content);
        input.close();

        return content;
    }
}
