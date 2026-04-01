package com.finance.financesystem.mapper;

import com.finance.financesystem.dto.NotificationDto;
import com.finance.financesystem.entity.Notification;

public final class NotificationMapper {
    private NotificationMapper(){
    }
    public static Notification toEntity(NotificationDto notificationDto){
        Notification notification = new Notification();
        notification.setId(notificationDto.getId());
        notification.setMessage(notificationDto.getMessage());
        notification.setType(notificationDto.getType());
        notification.setRead(notificationDto.getRead());
        notification.setStatus(notificationDto.getStatus());

        return notification;

    }

    public static NotificationDto toDto(Notification notification){
        NotificationDto notificationDto = new NotificationDto();

        notificationDto.setId(notification.getId());
        notificationDto.setMessage(notification.getMessage());
        notificationDto.setType(notification.getType());
        notificationDto.setRead(notification.getRead());
        notificationDto.setStatus(notification.getStatus());

        return notificationDto;

    }
}
