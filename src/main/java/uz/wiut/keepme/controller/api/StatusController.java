package uz.wiut.keepme.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import uz.wiut.keepme.dto.ResponseDto;
import uz.wiut.keepme.service.StatusService;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    @Autowired
    StatusService statusService;

    @GetMapping("/get/all")
    @ResponseBody
    public ResponseDto getAll(){

        return statusService.getAll();
    }

    @GetMapping("/get/byid")
    @ResponseBody
    public ResponseDto getById(@RequestParam(value = "id", required = true) Integer id){

        return statusService.getById(id);
    }

}
