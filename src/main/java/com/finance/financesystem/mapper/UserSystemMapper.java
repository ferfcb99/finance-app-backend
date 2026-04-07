package com.finance.financesystem.mapper;

import com.finance.financesystem.dto.UserSystemDto;
import com.finance.financesystem.entity.UserSystem;

import java.util.ArrayList;
import java.util.List;

public final class UserSystemMapper {
    private UserSystemMapper(){
    }
    public static UserSystem toEntity(UserSystemDto userSystemDto){
        UserSystem userSystem = new UserSystem();
        userSystem.setId(userSystemDto.getId());
        userSystem.setName(userSystemDto.getName());
        userSystem.setEmail(userSystemDto.getEmail());
        userSystem.setPassword(userSystemDto.getPassword());
        userSystem.setCurrency(userSystemDto.getCurrency());
        userSystem.setStatus(userSystemDto.getStatus());
        userSystem.setLastLogin(userSystemDto.getLastLogin());

        return userSystem;

    }

    public static UserSystemDto toDto(UserSystem userSystem){
        UserSystemDto userSystemDto = new UserSystemDto();

        userSystemDto.setId(userSystem.getId());
        userSystemDto.setName(userSystem.getName());
        userSystemDto.setEmail(userSystem.getEmail());
        userSystemDto.setPassword(userSystem.getPassword());
        userSystemDto.setCurrency(userSystem.getCurrency());
        userSystemDto.setStatus(userSystem.getStatus());
        userSystemDto.setLastLogin(userSystem.getLastLogin());

        return userSystemDto;
    }
    // UserSystem a UserSystemDto
    public static List<UserSystemDto> toListDto(List<UserSystem> userSystems){
        List<UserSystemDto> userSystemDtoList = new ArrayList<>();
        for(UserSystem userSystem : userSystems){
            userSystemDtoList.add(toDto(userSystem));
        }
        return userSystemDtoList;
    }

    public static List<UserSystem> toListEntity(List<UserSystemDto> userSystemDtoList){
        List<UserSystem> userSystems = new ArrayList<>();
        for(UserSystemDto userSystemDto : userSystemDtoList){
            userSystems.add(toEntity(userSystemDto));
        }
        return userSystems;
    }

}
