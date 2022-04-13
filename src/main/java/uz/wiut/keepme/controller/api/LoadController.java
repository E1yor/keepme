package uz.wiut.keepme.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.wiut.keepme.dto.ResponseDto;
import uz.wiut.keepme.service.DriverService;
import uz.wiut.keepme.service.LoadService;

@RestController
@RequestMapping("/api/load")
public class LoadController {

    @Autowired
    LoadService loadService;

    @GetMapping("/get/all")
    @ResponseBody
    public ResponseDto getAll(){

        return loadService.getAll();
    }

    @GetMapping("/get/byid")
    @ResponseBody
    public ResponseDto getById(@RequestParam(value = "id", required = true) Integer id){

        return loadService.getById(id);
    }

}
