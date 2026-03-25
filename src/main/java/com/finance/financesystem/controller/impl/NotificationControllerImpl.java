package com.finance.financesystem.controller.impl;

import com.finance.financesystem.controller.NotificationController;
import com.finance.financesystem.dto.NotificationDto;
import com.finance.financesystem.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/notification")
public class NotificationControllerImpl implements NotificationController{

    private final NotificationService notificationService;

    public NotificationControllerImpl(NotificationService notificationService){
        this.notificationService = notificationService;
    }
    @Override
    @GetMapping(value = "/get-all-notification", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<NotificationDto>> getAllNotification(){
        List<NotificationDto> notificationDtoList = this.notificationService.getAllNotification();

        return ResponseEntity.status(HttpStatus.OK)
                .body(notificationDtoList);

    }
    @Override
    @GetMapping(value = "/get-by-id-budget/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NotificationDto> getByIdNotification(@PathVariable("id") Long id) {
        NotificationDto notificationDto = this.notificationService.getByIdNotification(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(notificationDto);

    }
    @Override
    @PostMapping(value = "/create-budget", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NotificationDto> createNotification(@RequestBody NotificationDto notificationDto) {
        NotificationDto notificationSave = this.notificationService.createNotification(notificationDto);

        return ResponseEntity.status(HttpStatus.OK)
                .body(notificationSave);
    }

}
