package uz.wiut.keepme.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/web/driver")
@RequestMapping("/web/driver")
public class DriverController {

    @GetMapping(value={"", "/", "/index"})
    public String index(Model model){

        model.addAttribute("active", "driver");
        model.addAttribute("page_title", "Driver");
        return "driver/index";
    }

}