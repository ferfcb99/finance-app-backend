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

        //metodo para obtener todos los registros

    }


    @Override
    public ResponseEntity<List<NotificationDto>> getAllNotification() {
        logger.info("Entro al metodo getAllNotification al controlador");
        List<NotificationDto> notificationDtoList = this.notificationService.getAllNotification();

        return ResponseEntity.status(HttpStatus.OK)
                .body(notificationDtoList);
    }

    @Override
    public ResponseEntity<NotificationDto> getByIdNotification(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<NotificationDto> createNotification(NotificationDto notificationDto) {
        return null;
    }

    @Override
    public ResponseEntity<NotificationDto> deleteByIdNotification(Long id) {
        return null;
    }
}
