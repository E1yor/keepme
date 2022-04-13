package uz.wiut.keepme.controller.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @GetMapping("/info")
    public void getCompanyInfo(){
    }

}