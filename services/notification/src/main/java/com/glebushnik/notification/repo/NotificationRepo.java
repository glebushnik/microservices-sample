package com.glebushnik.notification.repo;

import com.glebushnik.notification.domain.entity.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepo extends MongoRepository<Notification, String> {
}
