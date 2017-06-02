package com.epam.controller;

import com.epam.dal.domain.UserRegistrationRequest;
import com.epam.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by boros on 2017. 04. 16..
 */

@Controller
public class AuthController {

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value="logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        try {
            request.logout();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return "login";
    }

    @RequestMapping(value = "/registrate", method = RequestMethod.POST)
    public String SuccessRegistrate(@RequestBody UserRegistrationRequest request) {
        registrationService.registrate(request);
        return "login?reg-success";
    }
}
