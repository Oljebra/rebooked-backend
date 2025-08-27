package com.personal.rebooked.notification.respositories;

import com.personal.rebooked.notification.models.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NotificationRepository extends MongoRepository<Notification, String> {
    List<Notification> findAllByUserId(String userId);
}
