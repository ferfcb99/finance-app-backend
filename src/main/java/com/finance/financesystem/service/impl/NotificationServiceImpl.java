package com.finance.financesystem.service.impl;

import com.finance.financesystem.dto.NotificationDto;
import com.finance.financesystem.entity.Category;
import com.finance.financesystem.entity.Notification;
import com.finance.financesystem.repository.NotificationRepository;
import com.finance.financesystem.service.NotificationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;

    private NotificationServiceImpl(NotificationRepository notificationRepository){
        this.notificationRepository = notificationRepository;
    }

    @Override
    public List<NotificationDto> getAllNotification() {
        List<Notification> notificationList = this.notificationRepository.findAll();
        List<NotificationDto> notificationDtoList = new ArrayList<>();

        for (Notification notificationTmp: notificationList){
            NotificationDto notificationDto = new NotificationDto();
            notificationDto.setId(notificationTmp.getId());
            notificationDto.setMessage(notificationTmp.getMessage());
            notificationDto.setType(notificationTmp.getType());
            notificationDto.setRead(notificationTmp.getRead());
            notificationDto.setStatus(notificationTmp.getStatus());

            notificationDtoList.add(notificationDto);

        }
        return notificationDtoList;
    }

    @Override
    public NotificationDto getByIdNotification(Long id) {
        Notification notificationTmp = this.notificationRepository.findById(id).get();

        NotificationDto notificationDto = new NotificationDto();
        notificationDto.setId(notificationTmp.getId());
        notificationDto.setMessage(notificationTmp.getMessage());
        notificationDto.setType(notificationTmp.getType());
        notificationDto.setRead(notificationTmp.getRead());
        notificationDto.setStatus(notificationTmp.getStatus());

        return notificationDto;
    }

    @Override
    public NotificationDto createNotification(NotificationDto notificationDto) {
        Notification notification = new Notification(
                null,
                notificationDto.getMessage(),
                notificationDto.getType(),
                notificationDto.getRead(),
                LocalDateTime.now(),
                notificationDto.getStatus()
        );
        Notification saveNotification = this.notificationRepository.save(notification);
        notificationDto.setId(saveNotification.getId());

        return notificationDto;

    }
}
