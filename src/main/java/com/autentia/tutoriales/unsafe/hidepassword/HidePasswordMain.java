package com.autentia.tutoriales.unsafe.hidepassword;

public class HidePasswordMain {

    public static void main(String[] args) throws Exception {
        final String passwordOne = new String("l00k@myHor$e");
        final String passwordTwo = new String("1s4mazin6");

        showSafeWayToHide(passwordOne);

        showNonSafeWayToHide(passwordTwo);

    }

    private static void showSafeWayToHide(String pwd) {
        System.out.println("Forma segura de esconder contraseña");
        try {
            System.out.println("Original " + pwd);

            HidePassword.safe(pwd);

            System.out.println("Escondida " + pwd); // ????????????
        } catch (final Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static void showNonSafeWayToHide(String pwd) {
        System.out.println("Forma NO segura de esconder contraseña");
        try {
            System.out.println("Original " + pwd);

            HidePassword.notSafe(pwd);

            System.out.println("Escondida " + pwd); // ????????????
        } catch (final Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
