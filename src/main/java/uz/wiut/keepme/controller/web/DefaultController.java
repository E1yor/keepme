package uz.wiut.keepme.controller.web;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.wiut.keepme.dto.CompanyDto;
import uz.wiut.keepme.dto.ResponseDto;
import uz.wiut.keepme.dto.UserDto;
import uz.wiut.keepme.service.CompanyService;

@Controller("default")
@RequestMapping("")
public class DefaultController {

    final CompanyService companyService;

    public DefaultController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping(value={"", "/"})
    public String login(Model model){

        return "redirect:/web/user/login";
    }

    @GetMapping(value={"/info", "/index"})
    public String info(Model model){

        // get user id
        UserDto userDto = (UserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer company_id = userDto.getCompanyId();

        // get company by user id
        ResponseDto<CompanyDto> service_dto = companyService.getById(company_id);
        if(service_dto != null && service_dto.getSuccess() && service_dto.getData() != null){
            model.addAttribute("company", service_dto.getData());
        }

        return "default/index";
    }


}