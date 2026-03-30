package com.finance.financesystem.controller.impl;

import com.finance.financesystem.controller.UserSystemController;
import com.finance.financesystem.dto.UserSystemDto;
import com.finance.financesystem.service.UserSystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/user-system")
public class UserSystemControllerImpl implements UserSystemController{

    Logger logger = LoggerFactory.getLogger(AccountControllerImpl.class);

    private final UserSystemService userSystemService;

    public UserSystemControllerImpl(UserSystemService userSystemService){
        this.userSystemService = userSystemService;
    }

    // metodo para obtener todos los datos
    @Override
    @GetMapping(value = "/get-all-user-system", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserSystemDto>> getAllUserSystem() {
        logger.info("Entro al metodo getAllUserSystem del controlador");
        List<UserSystemDto> userSystemDtoList = this.userSystemService.getAllUserSystem();

        return ResponseEntity.status(HttpStatus.OK)
                .body(userSystemDtoList);
    }

    // metodo para obtener datos por id
    @Override
    @GetMapping(value = "/get-by-id-user-system/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserSystemDto> getByIdUserSystem(@PathVariable Long id) {
        logger.info("Entro al metodo getByIdUserSystem del controlador");
        UserSystemDto userSystemById= this.userSystemService.getByIdUserSystem(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(userSystemById);
    }

    //metodo para crear datos
    @Override
    @PostMapping(value = "/create-user-system", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserSystemDto> createUserSystem(@RequestBody UserSystemDto userSystemDto) {
        logger.info("Entro al metodo createUserSystem del controlador");
        UserSystemDto userSystemCreated = this.userSystemService.createUserSystem(userSystemDto);

        return ResponseEntity.status(HttpStatus.OK)
                .body(userSystemCreated);
    }

    //metodo para eliminar datos por id
    @Override
    @DeleteMapping(value = "/delete-by-id-user-system/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserSystemDto> deleteByIdUserSystem(@PathVariable Long id) {
        logger.info("Entro al metodo deleteByIdUserSystem del controlador");
        UserSystemDto deletedUserSystem = this.userSystemService.deleteByIdUserSystem(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(deletedUserSystem);
    }
}

