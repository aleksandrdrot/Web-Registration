package com.drot.registration;

import com.drot.registration.exceptions.LogException;
import com.drot.registration.exceptions.PassException;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    public static boolean input(String login, String password, String confirmPassword) {
        boolean log = true;
        String okPass = "ok";
        if (login.equals(checkLogin(login))) {
            log = true;
        } else {
            log = false;
        }

        if (okPass.equals(comparePass(password, confirmPassword))) {
            log = true;
        } else {
            log = false;
        }
        return log;
    }

    //-------------------------------------------------------------//
    //  Проверяем логин на длинну и символы                        //
    //-------------------------------------------------------------//
    public static String checkLogin(String str) {
        if (checkSymbol(str) == null || checkLengthLogin(str) == null) {
            throw new LogException();
        } else {
            return str;
        }
    }

    //-------------------------------------------------------------//
    //  Проверяем пароли на сходство                               //
    //-------------------------------------------------------------//
    public static String comparePass(String pass1, String pass2) {
        String str1 = checkPass(pass1);
        String str2 = checkPass(pass2);
        if (!str1.equals(str2)) {
            throw new PassException();
        } else {
            return "ok";
        }
    }


    //-------------------------------------------------------------//
    //  Проверяем пароль на длинну и символы                       //
    //-------------------------------------------------------------//
    public static String checkPass(String pass) {
        if (checkSymbol(pass) == null || checkLengthPass(pass) == null) {
            throw new PassException();
        } else {
            return pass;
        }
    }

    public static String checkSymbol(String str) {
        if (str.matches("^[a-zA-Z0-9_]*$")) {
            return str;
        } else {
            return null;
        }
    }

    public static String checkLengthLogin(String login) {
        if (login.length() <= 20) {
            return login;
        } else {
            return null;
        }
    }

    public static String checkLengthPass(String pass) {
        if (pass.length() < 20) {
            return pass;
        } else {
            return null;
        }
    }

}
