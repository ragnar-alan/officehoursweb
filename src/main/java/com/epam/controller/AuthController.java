package com.epam.controller;

import com.epam.dal.domain.User;
import com.epam.dal.domain.UserRegistrationRequest;
import com.epam.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

/**
 * Created by boros on 2017. 04. 16..
 */

@Controller
public class AuthController {

    public static final String REGISTRATION_SUCCESS = "Registration success, you can login now.";
    public static final String REGISTRATION_FAILED = "Something wrong happend, please try again later!";

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value="logout", method = RequestMethod.GET)
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

        User user = registrationService.registrate(userRegistrationRequest);
        String msg = user.equals(null)? REGISTRATION_FAILED : REGISTRATION_SUCCESS;
        String status = user.equals(null)? "false" : "true";
        model.addAttribute("regStatus", status);
        model.addAttribute("regMessage", msg);
        return "login";
    }
}
