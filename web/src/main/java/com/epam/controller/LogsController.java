package com.epam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by boros on 2017. 04. 15..
 */
@Controller
public class LogsController {


    @RequestMapping(value = "/logs", method = RequestMethod.GET)
    public String showTodayLogs() {
        return "logs";
    }

}
