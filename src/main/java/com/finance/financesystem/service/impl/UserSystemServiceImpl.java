package com.finance.financesystem.service.impl;

import com.finance.financesystem.dto.UserSystemDto;
import com.finance.financesystem.entity.UserSystem;
import com.finance.financesystem.repository.UserSystemRepository;
import com.finance.financesystem.service.UserSystemService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserSystemServiceImpl implements UserSystemService {
    private final UserSystemRepository userSystemRepository;

    private UserSystemServiceImpl(UserSystemRepository userSystemRepository){
        this.userSystemRepository = userSystemRepository;
    }

    @Override
    public List<UserSystemDto> getAllUserSystem() {
        List<UserSystem> userSystemList = this.userSystemRepository.findAll();
        List<UserSystemDto> userSystemDtoList = new ArrayList<>();

        for (UserSystem userSystemTmp: userSystemList){
            UserSystemDto userSystemDto = new UserSystemDto();
            userSystemDto.setId(userSystemTmp.getId());
            userSystemDto.setName(userSystemTmp.getName());
            userSystemDto.setEmail(userSystemTmp.getEmail());
            userSystemDto.setPassword(userSystemTmp.getPassword());
            userSystemDto.setCurrency(userSystemTmp.getCurrency());
            userSystemDto.setStatus(userSystemTmp.getStatus());
            userSystemDto.setLastLogin(userSystemTmp.getLastLogin());

            userSystemDtoList.add(userSystemDto);
        }

        return userSystemDtoList;
    }

    @Override
    public UserSystemDto getByIdUserSystem(Long id) {
        UserSystem userSystemTmp = this.userSystemRepository.findById(id).get();

        UserSystemDto userSystemDto = new UserSystemDto();
        userSystemDto.setId(userSystemTmp.getId());
        userSystemDto.setName(userSystemTmp.getName());
        userSystemDto.setEmail(userSystemTmp.getEmail());
        userSystemDto.setPassword(userSystemTmp.getPassword());
        userSystemDto.setCurrency(userSystemTmp.getCurrency());
        userSystemDto.setStatus(userSystemTmp.getStatus());
        userSystemDto.setLastLogin(userSystemTmp.getLastLogin());

        return userSystemDto;
    }

    @Override
    public UserSystemDto createUserSystem(UserSystemDto userSystemDto) {
        UserSystem userSystem = new UserSystem(
                null,
                userSystemDto.getName(),
                userSystemDto.getEmail(),
                userSystemDto.getPassword(),
                userSystemDto.getCurrency(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                userSystemDto.getStatus(),
                userSystemDto.getLastLogin()
        );
        UserSystem saveUserSystem = this.userSystemRepository.save(userSystem);
        userSystemDto.setId(saveUserSystem.getId());

        return userSystemDto;

    }
}
