package com.epam.controller;

import com.epam.dal.domain.UserRegistrationRequest;
import com.epam.exception.UserAlreadyExistException;
import com.epam.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by boros on 2017. 04. 16..
 */

@Controller
public class AuthController {

    public static final String REGISTRATION_SUCCESS = "Registration success, you can login now.";
    private String responseMsg = REGISTRATION_SUCCESS;
    private String responseStatus = "success"; //Bootstrap CSS class

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, Model model) {
        try {
            request.logout();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return "login";
    }

    @RequestMapping(value = "/registrate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String registrate(@ModelAttribute UserRegistrationRequest userRegistrationRequest, Model model) {

        try {
            registrationService.registrate(userRegistrationRequest);
        } catch (UserAlreadyExistException ex) {
            responseMsg = ex.getMessage();
            responseStatus = "danger"; //Bootstrap CSS class
        } catch (Exception ex) {
            responseMsg = ex.getMessage();
            responseStatus = "danger";
        } finally {
            model.addAttribute("regMessage", responseMsg);
            model.addAttribute("regStatus", responseStatus);
        }

        return "login";
    }
}
