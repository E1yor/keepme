package uz.wiut.keepme.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/web/unit")
@RequestMapping("/web/unit")
public class UnitController {

    @GetMapping(value={"", "/", "/index"})
    public String index(Model model){

        model.addAttribute("active", "unit");
        return "unit/index";
    }

}