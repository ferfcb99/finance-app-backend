package com.finance.financesystem.controller.impl;

import com.finance.financesystem.controller.NotificationController;
import com.finance.financesystem.dto.NotificationDto;
import com.finance.financesystem.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/notification")
public class NotificationControllerImpl implements NotificationController{

    Logger logger = LoggerFactory.getLogger(AccountControllerImpl.class);

    private final NotificationService notificationService;

    public NotificationControllerImpl(NotificationService notificationService){
        this.notificationService = notificationService;

    }

    //metodo para obtener todos los registros
    @Override
    @GetMapping(value = "/get-all-notification", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<NotificationDto>> getAllNotification() {
        logger.info("Entro al metodo getAllNotification al controlador");
        List<NotificationDto> notificationDtoList = this.notificationService.getAllNotification();

        return ResponseEntity.status(HttpStatus.OK)
                .body(notificationDtoList);
    }

    //metodo para obtener datos por id
    @Override
    @GetMapping(value = "/get-by-id-notification/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NotificationDto> getByIdNotification(@PathVariable Long id) {
        logger.info("Entro al metodo getByIdNotification al controlador ");
        NotificationDto notificationById = this.notificationService.getByIdNotification(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(notificationById);
    }

    // metodo para crear datos
    @Override
    @PostMapping(value = "/create-notification", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NotificationDto> createNotification(@RequestBody NotificationDto notificationDto) {
        logger.info("Entro el metodo createNotification del controlador");
        NotificationDto notificationCreated = this.notificationService.createNotification(notificationDto);

        return ResponseEntity.status(HttpStatus.OK)
                .body(notificationCreated);
    }

    // metodo para eliminar datos por id
    @Override
    @DeleteMapping(value = "/delete-by-id-notification/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NotificationDto> deleteByIdNotification(@PathVariable Long id) {
        logger.info("Entro al metodo deleteByIdNotification del controlador ");
        NotificationDto notificationDelete = this.notificationService.deleteByIdNotification(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(notificationDelete);
    }
}
