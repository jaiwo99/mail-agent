package com.jaiwo99.mailagent.userwebapp.controller;

import com.jaiwo99.mailagent.common.service.UserService;
import com.jaiwo99.mailagent.userwebapp.command.RegisterCmd;
import com.jaiwo99.mailagent.userwebapp.service.UserDTOResolver;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import javax.validation.Valid;

/**
 * @author jaiwo99
 */
@Controller
@RequestMapping("/")
public class RegisterController {

    @Inject
    UserService userService;
    @Inject
    UserDTOResolver userDTOResolver;

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value = "doRegister", method = RequestMethod.POST)
    public String doRegister(@Valid @ModelAttribute RegisterCmd registerCmd, BindingResult result, RedirectAttributes flash) {
        if(result.hasErrors()) {
            return "register";
        }

        userService.register(userDTOResolver.resolve(registerCmd));
        flash.addAttribute("msg", "User registered successfully!");
        return "redirect:/register";
    }

    @ModelAttribute
    RegisterCmd registerCmd() {
        return new RegisterCmd();
    }
}
