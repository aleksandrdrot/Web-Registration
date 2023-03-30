package com.drot.registration;

import com.drot.registration.exceptions.LogException;
import com.drot.registration.exceptions.PassException;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    public static boolean input(String login, String password, String confirmPassword) {

        return checkLogin(login) && comparePass(password, confirmPassword);
    }

    //-------------------------------------------------------------//
    //  Проверяем логин на длинну и символы                        //
    //-------------------------------------------------------------//
    public static boolean checkLogin(String str) {
        if (!checkSymbol(str) || !checkLengthLogin(str)) {
            throw new LogException();
        } else {
            return true;
        }
    }

    //-------------------------------------------------------------//
    //  Проверяем пароли на сходство                               //
    //-------------------------------------------------------------//
    public static boolean comparePass(String pass1, String pass2) {
        if (!checkPass(pass1) || !checkPass(pass2)) {
            throw new PassException();
        } else if (!pass1.equals(pass2)) {
            throw new PassException();
        } else {
            return true;
        }
    }


    //-------------------------------------------------------------//
    //  Проверяем пароль на длинну и символы                       //
    //-------------------------------------------------------------//
    public static boolean checkPass(String pass) {
        if (!checkSymbol(pass) || !checkLengthPass(pass)) {
            throw new PassException();
        } else {
            return true;
        }
    }

    public static boolean checkSymbol(String str) {
        if (str.matches("^[a-zA-Z0-9_]*$")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkLengthLogin(String login) {
        if (login.length() <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkLengthPass(String pass) {
        if (pass.length() < 20) {
            return true;
        } else {
            return false;
        }
    }

}
