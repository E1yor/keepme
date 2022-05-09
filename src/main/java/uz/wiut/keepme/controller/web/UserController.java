package uz.wiut.keepme.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("user")
@RequestMapping("/web/user")
public class UserController {

    @GetMapping(value={"/login"})
    public String login(Model model){

        return "login/index";
    }

}