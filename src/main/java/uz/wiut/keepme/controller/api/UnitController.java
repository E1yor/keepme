package uz.wiut.keepme.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.wiut.keepme.dto.NamingDto;
import uz.wiut.keepme.dto.ResponseDto;
import uz.wiut.keepme.dto.UnitDto;
import uz.wiut.keepme.helper.StringHelper;
import uz.wiut.keepme.service.UnitService;

import java.util.List;

@RestController
@RequestMapping("/api/unit")
public class UnitController {

    @Autowired
    UnitService unitService;

    @GetMapping("/get/all")
    @ResponseBody
    public ResponseDto getAll(){

        return unitService.getAll();
    }

    @GetMapping("/get/byid")
    @ResponseBody
    public ResponseDto getById(@RequestParam(value = "id", required = true) Integer id){

        return unitService.getById(id);
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseDto add(@RequestBody UnitDto dto){

        return unitService.add(dto);
    }

    @PutMapping("/edit")
    @ResponseBody
    public ResponseDto edit(@RequestBody UnitDto dto){

        ResponseDto response = null;

        if (StringHelper.get(dto.getId()) == null){
            response = new ResponseDto();
            response.setSuccess(Boolean.FALSE);

            NamingDto message = new NamingDto();
            message.setName_en("Provided ID is empty");

            response.setMessage(message);

            return response;
        }

        ResponseDto service = unitService.getById(dto.getId());

        if(service == null || service.getData() == null){
            response = new ResponseDto();
            response.setSuccess(Boolean.FALSE);

            NamingDto message = new NamingDto();
            message.setName_en("Cannot find an entity by provided ID");

            response.setMessage(message);

            return response;
        }

        return unitService.edit(dto);
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

            return response;
        }

        ResponseDto service = unitService.getById(id);

        if(service == null || service.getData() == null){
            response = new ResponseDto();
            response.setSuccess(Boolean.FALSE);

            NamingDto message = new NamingDto();
            message.setName_en("Cannot find an entity by provided ID");

            response.setMessage(message);

            return response;
        }

        return unitService.remove(id);
    }

}