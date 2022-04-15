package uz.wiut.keepme.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("default")
@RequestMapping("")
public class DefaultController {

    @GetMapping(value={"", "/"})
    public String login(Model model){

        return "redirect:user/login";
    }

    @GetMapping(value={"/info", "/index"})
    public String info(Model model){

        return "default/index";
    }


}