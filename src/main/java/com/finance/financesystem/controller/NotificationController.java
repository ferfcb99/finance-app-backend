package com.finance.financesystem.controller;

import com.finance.financesystem.dto.NotificationDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NotificationController {

    ResponseEntity<List<NotificationDto>> getAllNotification();

    ResponseEntity<NotificationDto> getByIdNotification(Long id);

    ResponseEntity<NotificationDto> createNotification(NotificationDto notificationDto);

    ResponseEntity<NotificationDto> deleteByIdNotification(Long id);



}
