package com.drot.registration;

import com.drot.registration.exceptions.LogException;
import com.drot.registration.exceptions.PassException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    private final RegistrationService checkService;

    public RegistrationController(RegistrationService checkService) {
        this.checkService = checkService;
    }

    @GetMapping("log")
    public String logPass(@RequestParam("login") String login, @RequestParam("password") String password, @RequestParam("confirmPassword") String confirmPassword) {
        try {
            checkService.input(login, password, confirmPassword);
        } catch (LogException e) {
            return "WrongLoginException";
        } catch (PassException e) {
            return "WrongPasswordException";
        }

        if (checkService.input(login, password, confirmPassword)) {
            return String.format("Login: %s,    Password: %s,     ConfirmPassword: %s ", login, password, confirmPassword);
        } else {
            return "Что-то не так!!!";
        }
    }
}





