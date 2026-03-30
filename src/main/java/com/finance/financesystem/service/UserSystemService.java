package com.finance.financesystem.service;

import com.finance.financesystem.dto.UserSystemDto;

import java.util.List;

public interface UserSystemService {

    List<UserSystemDto> getAllUserSystem();

    UserSystemDto getByIdUserSystem(Long id);

    UserSystemDto createUserSystem(UserSystemDto userSystemDto);

    UserSystemDto deleteByIdUserSystem(Long id);


}
