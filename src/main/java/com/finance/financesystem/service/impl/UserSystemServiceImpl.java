package com.finance.financesystem.service.impl;

import com.finance.financesystem.controller.impl.UserSystemControllerImpl;
import com.finance.financesystem.dto.UserSystemDto;
import com.finance.financesystem.entity.UserSystem;
import com.finance.financesystem.mapper.UserSystemMapper;
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
    // UserSystem a UserSystemDto 
    @Override
    public List<UserSystemDto> getAllUserSystem() {
        logger.info("Entro al metodo getAllUserSystem del servicio");
        List<UserSystem> userSystems = this.userSystemRepository.findAll();
        
        return UserSystemMapper.toListDto(userSystems);
    }

    @Override
    public UserSystemDto getByIdUserSystem(Long id) {
        logger.info("Entro al metodo getByIdUserSystem del servicio");
        UserSystem userSystemById = this.userSystemRepository.findById(id).get();

        return UserSystemMapper.toDto(userSystemById);
    }

    @Override
    public UserSystemDto createUserSystem(UserSystemDto userSystemDto) {
        logger.info("Entro al metodo createUserSystem del servicio");

        UserSystem userSystemCreate = UserSystemMapper.toEntity(userSystemDto);

        userSystemCreate.setId(null);
        userSystemCreate.setCreatedAt(LocalDateTime.now());
        userSystemCreate.setUpdatedAt(LocalDateTime.now());

        userSystemCreate = this.userSystemRepository.save(userSystemCreate);
        userSystemDto.setId(userSystemCreate.getId());

        return UserSystemMapper.toDto(userSystemCreate);
    }

    @Override
    public UserSystemDto deleteByIdUserSystem(Long id) {
        logger.info("Entro al metodo deleteByIdUserSystem del servicio");

        UserSystem userSystemDeleted = this.userSystemRepository.getReferenceById(id);

        this.userSystemRepository.deleteById(id);

        return UserSystemMapper.toDto(userSystemDeleted);
    }
}
