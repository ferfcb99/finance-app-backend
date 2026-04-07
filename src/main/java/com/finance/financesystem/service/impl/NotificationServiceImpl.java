package com.finance.financesystem.service.impl;

import com.finance.financesystem.dto.NotificationDto;
import com.finance.financesystem.entity.Category;
import com.finance.financesystem.entity.Notification;
import com.finance.financesystem.mapper.NotificationMapper;
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

        return NotificationMapper.toListDto(notifications);
    }

    @Override
    public NotificationDto getByIdNotification(Long id) {
        logger.info("Entro el metodo getByIdNotification del servidor");
        Notification notificationById = this.notificationRepository.findById(id).get();

        return NotificationMapper.toDto(notificationById);
    }

    @Override
    public NotificationDto createNotification(NotificationDto notificationDto) {
        logger.info("Entro al metodo createNotification del servicio");

        Notification notificationCreate = NotificationMapper.toEntity(notificationDto);
        notificationCreate.setId(null);
        notificationCreate.setCreatedAt(LocalDateTime.now());

        notificationCreate = this.notificationRepository.save(notificationCreate); // crear y actualizar

        notificationDto.setId(notificationCreate.getId());

        return NotificationMapper.toDto(notificationCreate);
    }

    @Override
    public NotificationDto deleteByIdNotification(Long id) {
        logger.info("Entro al metodo deleteByIdNotification del servicio");
        Notification notificationDeleted = this.notificationRepository.findById(id).get();

        this.notificationRepository.deleteById(id);

        return NotificationMapper.toDto(notificationDeleted);
    }
}
