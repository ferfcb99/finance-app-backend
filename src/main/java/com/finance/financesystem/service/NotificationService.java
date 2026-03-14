package com.finance.financesystem.service;

import com.finance.financesystem.dto.NotificationDto;

import java.util.List;

public interface NotificationService {

    List<NotificationDto> getAllNotification();

    NotificationDto getByIdNotification(Long id);

    NotificationDto createNotification(NotificationDto notificationDto);


}
