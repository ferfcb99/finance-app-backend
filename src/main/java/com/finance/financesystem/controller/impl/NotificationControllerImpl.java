package com.finance.financesystem.controller.impl;

import com.finance.financesystem.controller.NotificationController;
import com.finance.financesystem.dto.NotificationDto;
import com.finance.financesystem.service.NotificationService;
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
        return null;
    }
    @Override
    @GetMapping(value = "/get-by-id-budget/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NotificationDto> getByIdNotification(@PathVariable("id") Long id) {
        return null;
    }
    @Override
    @PostMapping(value = "/create-budget", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NotificationDto> createNotification(@RequestBody NotificationDto notificationDto) {
        return null;
    }

}
