package com.finance.financesystem.service.impl;

import com.finance.financesystem.controller.impl.UserSystemControllerImpl;
import com.finance.financesystem.dto.UserSystemDto;
import com.finance.financesystem.entity.UserSystem;
import com.finance.financesystem.repository.UserSystemRepository;
import com.finance.financesystem.service.UserSystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserSystemServiceImpl implements UserSystemService {

    Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    private final UserSystemRepository userSystemRepository;

    public UserSystemServiceImpl(UserSystemRepository userSystemRepository){
        this.userSystemRepository = userSystemRepository;

    }

    @Override
    public List<UserSystemDto> getAllUserSystem() {
        logger.info("Entro al metodo getAllUserSystem del servicio");
        List<UserSystem> userSystems = this.userSystemRepository.findAll();
        List<UserSystemDto> userSystemDtoList = new ArrayList<>();

        for(UserSystem userSystem : userSystems){
            UserSystemDto userSystemDto = new UserSystemDto();

            userSystemDto.setId(userSystem.getId());
            userSystemDto.setName(userSystem.getName());
            userSystemDto.setEmail(userSystem.getEmail());
            userSystemDto.setPassword(userSystem.getPassword());
            userSystemDto.setCurrency(userSystem.getCurrency());
            userSystemDto.setStatus(userSystemDto.getStatus());
            userSystemDto.setLastLogin(userSystem.getLastLogin());

            userSystemDtoList.add(userSystemDto);

        }
        return userSystemDtoList;
    }

    @Override
    public UserSystemDto getByIdUserSystem(Long id) {
        logger.info("Entro al metodo getByIdUserSystem del servicio");
        UserSystem userSystemById = this.userSystemRepository.findById(id).get();

        UserSystemDto userSystemDto = new UserSystemDto();

        userSystemDto.setId(userSystemById.getId());
        userSystemDto.setName(userSystemById.getName());
        userSystemDto.setEmail(userSystemById.getEmail());
        userSystemDto.setPassword(userSystemById.getPassword());
        userSystemDto.setCurrency(userSystemById.getCurrency());
        userSystemDto.setStatus(userSystemById.getStatus());
        userSystemDto.setLastLogin(userSystemById.getLastLogin());


        return userSystemDto;
    }

    @Override
    public UserSystemDto createUserSystem(UserSystemDto userSystemDto) {
        logger.info("Entro al metodo createUserSystem del servicio");

        UserSystem userSystemCreate = new UserSystem();

        userSystemCreate.setId(null);
        userSystemCreate.setName(userSystemCreate.getName());
        userSystemCreate.setEmail(userSystemCreate.getEmail());
        userSystemCreate.setPassword(userSystemCreate.getPassword());
        userSystemCreate.setCurrency(userSystemCreate.getCurrency());
        userSystemCreate.setStatus(userSystemCreate.getStatus());
        userSystemCreate.setLastLogin(userSystemCreate.getLastLogin());

        userSystemCreate = this.userSystemRepository.save(userSystemCreate);
        userSystemDto.setId(userSystemCreate.getId());

        return userSystemDto;
    }

    @Override
    public UserSystemDto deleteByIdUserSystem(Long id) {
        logger.info("Entro al metodo deleteByIdUserSystem del servicio");

        UserSystem userSystemDeleted = this.userSystemRepository.getReferenceById(id);

        this.userSystemRepository.deleteById(id);

        UserSystemDto userSystemDto = new UserSystemDto();

        userSystemDto.setName(userSystemDto.getName());
        userSystemDto.setEmail(userSystemDto.getEmail());
        userSystemDto.setPassword(userSystemDto.getPassword());
        userSystemDto.setCurrency(userSystemDto.getCurrency());
        userSystemDto.setStatus(userSystemDto.getStatus());
        userSystemDto.setLastLogin(userSystemDto.getLastLogin());

        return userSystemDto;
    }
}
