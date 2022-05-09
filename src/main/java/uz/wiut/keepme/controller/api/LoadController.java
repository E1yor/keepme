package uz.wiut.keepme.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.wiut.keepme.dto.LoadDto;
import uz.wiut.keepme.dto.NamingDto;
import uz.wiut.keepme.dto.ResponseDto;
import uz.wiut.keepme.helper.StringHelper;
import uz.wiut.keepme.service.LoadService;

import java.util.Optional;

@RestController
@RequestMapping("/api/load")
public class LoadController {

    @Autowired
    LoadService loadService;

    @GetMapping("/get/all")
    @ResponseBody
    public ResponseDto getAll(
        @RequestParam(value = "search", required = false) String search
    ){
        String search_criteria = StringHelper.get(search) == null ? null : search;
        return loadService.getAll(
            search_criteria
        );
    }

    @GetMapping("/get/byid")
    @ResponseBody
    public ResponseDto getById(@RequestParam(value = "id", required = true) Integer id){

        return loadService.getById(id);
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseDto add(@RequestBody LoadDto dto){

        return loadService.add(dto);
    }

    @PutMapping("/edit")
    @ResponseBody
    public ResponseDto edit(@RequestBody LoadDto dto){

        ResponseDto response = null;

        if (StringHelper.get(dto.getId()) == null){
            response = new ResponseDto();
            response.setSuccess(Boolean.FALSE);

            NamingDto message = new NamingDto();
            message.setName_en("Provided ID is empty");

            response.setMessage(message);

            return response;
        }

        ResponseDto service = loadService.getById(dto.getId());

        if(service == null || service.getData() == null){
            response = new ResponseDto();
            response.setSuccess(Boolean.FALSE);

            NamingDto message = new NamingDto();
            message.setName_en("Cannot find an entity by provided ID");

            response.setMessage(message);

            return response;
        }

        return loadService.edit(dto);
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

        ResponseDto service = loadService.getById(id);

        if(service == null || service.getData() == null){
            response = new ResponseDto();
            response.setSuccess(Boolean.FALSE);

            NamingDto message = new NamingDto();
            message.setName_en("Cannot find an entity by provided ID");

            response.setMessage(message);

            return response;
        }

        return loadService.remove(id);
    }

}
