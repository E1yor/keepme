package uz.wiut.keepme.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.wiut.keepme.dto.ResponseDto;
import uz.wiut.keepme.service.FleetService;
import uz.wiut.keepme.service.LoadService;

@RestController
@RequestMapping("/api/fleet")
public class FleetController {

    @Autowired
    FleetService fleetService;

    @GetMapping("/get/all")
    @ResponseBody
    public ResponseDto getAll(){

        return fleetService.getAll();
    }

    @GetMapping("/get/byid")
    @ResponseBody
    public ResponseDto getById(@RequestParam(value = "id", required = true) Integer id){

        return fleetService.getById(id);
    }

}
