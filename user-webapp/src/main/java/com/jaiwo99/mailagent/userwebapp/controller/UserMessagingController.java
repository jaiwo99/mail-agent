package com.jaiwo99.mailagent.userwebapp.controller;

import com.jaiwo99.mailagent.common.service.MessageSendService;
import com.jaiwo99.mailagent.userwebapp.command.MessageCmd;
import com.jaiwo99.mailagent.userwebapp.service.MailDTOResolver;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author jaiwo99
 */
@Controller
@RequestMapping("/msg/")
public class UserMessagingController {

    @Inject
    MessageSendService messageSendService;
    @Inject
    MailDTOResolver mailDTOResolver;

    @RequestMapping(value = "", method = GET)
    public String messageView() {
        return "message";
    }

    @RequestMapping(value = "send", method = POST)
    public String sendMessage(@Valid @ModelAttribute MessageCmd messageCmd, BindingResult result, RedirectAttributes flash) {
        if(result.hasErrors()) {
            return "message";
        }

        messageSendService.send(mailDTOResolver.resolve(messageCmd));
        flash.addAttribute("msg", "Message sent successfully!");
        return "redirect:/msg/";
    }

    @ModelAttribute
    MessageCmd messageCmd() {
        return new MessageCmd();
    }

}
