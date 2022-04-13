package uz.wiut.keepme.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.wiut.keepme.dto.DriverDto;
import uz.wiut.keepme.dto.NamingDto;
import uz.wiut.keepme.dto.ResponseDto;
import uz.wiut.keepme.helper.StringHelper;
import uz.wiut.keepme.service.DriverService;
import uz.wiut.keepme.service.StatusService;

import java.util.Optional;

@RestController("/api/driver")
@RequestMapping("/api/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @GetMapping("/get/all")
    @ResponseBody
    public ResponseDto getAll(){

        return driverService.getAll();
    }

    @GetMapping("/get/byid")
    @ResponseBody
    public ResponseDto getById(@RequestParam(value = "id", required = true) Integer id){

        return driverService.getById(id);
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseDto add(@RequestBody DriverDto dto){

        return driverService.add(dto);
    }

    @PutMapping("/edit")
    @ResponseBody
    public ResponseDto edit(@RequestBody DriverDto dto){

        ResponseDto response = null;

        if (StringHelper.get(dto.getId()) == null){
            response = new ResponseDto();
            response.setSuccess(Boolean.FALSE);

            NamingDto message = new NamingDto();
            message.setName_en("Provided ID is empty");

            response.setMessage(message);

            return response;
        }

        ResponseDto service = driverService.getById(dto.getId());

        if(service == null || service.getData() == null){
            response = new ResponseDto();
            response.setSuccess(Boolean.FALSE);

            NamingDto message = new NamingDto();
            message.setName_en("Cannot find an entity by provided ID");

            response.setMessage(message);

            return response;
        }

        return driverService.edit(dto);
    }

    @DeleteMapping("/remove")
    @ResponseBody
    public ResponseDto remove(@RequestParam(value = "id", required = true) Integer id) {

        ResponseDto response = null;

        if (StringHelper.get(id) == null){
            response = new ResponseDto();
            response.setSuccess(Boolean.FALSE);

            NamingDto message = new NamingDto();
            message.setName_en("Provided ID is empty");

            response.setMessage(message);
        }

        ResponseDto service = driverService.getById(id);

        if(service == null || service.getData() == null){
            response = new ResponseDto();
            response.setSuccess(Boolean.FALSE);

            NamingDto message = new NamingDto();
            message.setName_en("Cannot find an entity by provided ID");

            response.setMessage(message);
        }

        return driverService.remove(id);
    }

}
