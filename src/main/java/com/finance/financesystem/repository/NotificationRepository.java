package com.finance.financesystem.repository;

import com.finance.financesystem.dto.transactionrequest.TransactionRequest;
import com.finance.financesystem.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    Notification save(TransactionRequest transactionRequest);
}
