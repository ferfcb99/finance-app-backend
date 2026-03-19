package com.finance.financesystem.controller.impl;

import com.finance.financesystem.controller.UserSystemController;
import com.finance.financesystem.dto.UserSystemDto;
import com.finance.financesystem.service.UserSystemService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/user-system")
public class UserSystemControllerImpl implements UserSystemController{
    private final UserSystemService userSystemService;

    public UserSystemControllerImpl(UserSystemService userSystemService){
        this.userSystemService = userSystemService;
    }
    @Override
    @GetMapping(value = "/get-all-user-system", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserSystemDto>> getAllUserSystem(){
        return null;
    }
    @Override
    @GetMapping(value = "/get-by-id-user-system/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserSystemDto> getByIdUserSystem(@PathVariable("id") Long id) {
        return null;
    }
    @Override
    @PostMapping(value = "/create-user-system", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserSystemDto> createBudget(@RequestBody UserSystemDto userSystemDto) {
        return null;
    }

}

