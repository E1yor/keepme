package uz.wiut.keepme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.wiut.keepme.config.Constants;
import uz.wiut.keepme.dto.CompanyDto;
import uz.wiut.keepme.dto.NamingDto;
import uz.wiut.keepme.dto.ResponseDto;
import uz.wiut.keepme.mapper.CompanyMapper;
import uz.wiut.keepme.repository.CompanyRepository;
import java.util.Optional;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    CompanyMapper companyMapper;

    @Override
    public ResponseDto getById(Integer id) {
        ResponseDto response = null;

        try {

            Optional<CompanyDto> single = companyRepository.findByIdAndStateNot(id, Constants.STATUS_DELETED).map(companyMapper::toDto);

            if(single != null){
                response = new ResponseDto();
                response.setSuccess(Boolean.TRUE);
                response.setData(single.get());
            }else{
                response = new ResponseDto();
                response.setSuccess(Boolean.FALSE);

                NamingDto message = new NamingDto();
                message.setName_en("Cannot find the entity by id");

                response.setMessage(message);
            }

        } catch (Exception ex){
            response = new ResponseDto();
            response.setSuccess(Boolean.FALSE);

            NamingDto message = new NamingDto();
            message.setName_en(ex.getMessage());

            response.setMessage(message);
        }

        return response;
    }

}
