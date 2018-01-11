package com.example.showseverywhere.ui.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by carlos on 11/01/18.
 */

public class TextUtils {
    public static boolean verificarCampoLleno(String texto) {
        if (texto.isEmpty())
            return false;
        return true;
    }

    public static boolean verificarContrasenaBienFormada(String contrasena) {
        Pattern contrasenaPattern = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,}");
        Matcher contrasenaMatcher = contrasenaPattern.matcher(contrasena);
        if (contrasenaMatcher.find() && contrasena.length() <= 50)
            return true;
        return false;
    }

    public static boolean verificarEmailBienFormado(String email) {
        Pattern emailPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher emailMatcher = emailPattern.matcher(email);
        if (emailMatcher.find())
            return true;
        return false;
    }
}
