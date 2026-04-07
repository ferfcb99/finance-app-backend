package com.finance.financesystem.mapper;

import com.finance.financesystem.dto.NotificationDto;
import com.finance.financesystem.entity.Notification;

import java.util.ArrayList;
import java.util.List;

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

    public static List<NotificationDto> toListDto(List<Notification> notifications){
        List<NotificationDto> notificationDtoList = new ArrayList<>();
        for(Notification notification : notifications){
            notificationDtoList.add(toDto(notification));
        }
        return notificationDtoList;
    }

    public static List<Notification> toListEntity(List<NotificationDto> notificationDtoList){
        List<Notification> notifications = new ArrayList<>();
        for(NotificationDto notificationDto : notificationDtoList){
            notifications.add(toEntity(notificationDto));
        }
        return notifications;
    }
}
