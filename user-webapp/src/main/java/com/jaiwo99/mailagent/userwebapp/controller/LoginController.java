package com.jaiwo99.mailagent.userwebapp.controller;

import com.jaiwo99.mailagent.common.service.UserService;
import com.jaiwo99.mailagent.userwebapp.command.LoginCmd;
import com.jaiwo99.mailagent.userwebapp.service.UserDTOResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

/**
 * @author jaiwo99
 */
@Controller
@RequestMapping("/")
public class LoginController {

    @Inject
    UserService userService;
    @Inject
    UserDTOResolver userDTOResolver;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String register() {
        return "login";
    }

    @ModelAttribute
    LoginCmd loginCmd() {
        return new LoginCmd();
    }
}
