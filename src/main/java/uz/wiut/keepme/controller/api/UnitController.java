package uz.wiut.keepme.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.wiut.keepme.dto.NamingDto;
import uz.wiut.keepme.dto.ResponseDto;
import uz.wiut.keepme.dto.UnitDto;
import uz.wiut.keepme.service.UnitService;

import java.util.List;

@RestController
@RequestMapping("/api/unit")
public class UnitController {

    @Autowired
    UnitService unitService;

    @GetMapping("/get/all")
    public ResponseDto get(){

        return unitService.getAll();
    }

    @GetMapping("/get/byid")
    public ResponseDto getById(@RequestParam(value = "id", required = true) Integer id){

        return unitService.getById(id);
    }

    @PostMapping("/save")
    public ResponseDto save(
        @RequestBody UnitDto dto
    ){
        ResponseDto response = new ResponseDto();

        try {
            dto = unitService.save(dto);
            response.setData(dto);
            response.setSuccess(Boolean.TRUE);
        } catch (Exception ex){
            NamingDto naming = new NamingDto();

            naming.setName_en(ex.getMessage());
            naming.setName_ru(ex.getMessage());
            naming.setName_uz_cyrl(ex.getMessage());
            naming.setName_uz_latn(ex.getMessage());

            response.setMessage(naming);
        }

        return response;
    }

}