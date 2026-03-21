package com.finance.financesystem.service.impl;

import com.finance.financesystem.dto.NotificationDto;
import com.finance.financesystem.entity.Category;
import com.finance.financesystem.entity.Notification;
import com.finance.financesystem.repository.NotificationRepository;
import com.finance.financesystem.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    private final NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository){
        this.notificationRepository = notificationRepository;
    }

    @Override
    public List<NotificationDto> getAllNotification() {
        logger.info("Entro el metodo getAllNotification del servidor ");

        List<Notification> notifications = this.notificationRepository.findAll();
        List<NotificationDto> notificationDtoList = new ArrayList<>();

        for(Notification notification : notifications){
            NotificationDto notificationDto = new NotificationDto();

            notificationDto.setId(notification.getId());
            notificationDto.setMessage(notification.getMessage());
            notificationDto.setType(notification.getType());
            notificationDto.setRead(notification.getRead());
            notificationDto.setStatus(notification.getStatus());

            notificationDtoList.add(notificationDto);
        }


        return notificationDtoList;
    }

    @Override
    public NotificationDto getByIdNotification(Long id) {
        logger.info("Entro el metodo getByIdNotification del servidor");
        Notification notificationById = this.notificationRepository.findById(id).get();

        NotificationDto notificationDto = new NotificationDto();

        notificationDto.setId(notificationById.getId());
        notificationDto.setMessage(notificationById.getMessage());
        notificationDto.setType(notificationById.getType());
        notificationDto.setRead(notificationById.getRead());
        notificationDto.setStatus(notificationById.getStatus());

        return notificationDto;
    }

    @Override
    public NotificationDto createNotification(NotificationDto notificationDto) {
        logger.info("Entro al metodo createNotification del servicio");

        Notification notificationCreate = new Notification();
        notificationCreate.setId(null);
        notificationCreate.setMessage(notificationDto.getMessage());
        notificationCreate.setType(notificationDto.getType());
        notificationCreate.setRead(notificationDto.getRead());
        notificationCreate.setStatus(notificationDto.getStatus());

        return notificationDto;
    }

    @Override
    public NotificationDto deleteByIdNotification(Long id) {
        logger.info("Entro al metodo deleteByIdNotification del servicio");
        Notification notificationDeleted = this.notificationRepository.findById(id).get();

        this.notificationRepository.deleteById(id);
        NotificationDto notificationDto = new NotificationDto();

        notificationDto.setId(notificationDeleted.getId());
        notificationDto.setMessage(notificationDto.getMessage());
        notificationDto.setType(notificationDto.getType());
        notificationDto.setRead(notificationDto.getRead());
        notificationDto.setStatus(notificationDto.getStatus());

        return notificationDto;
    }
}
