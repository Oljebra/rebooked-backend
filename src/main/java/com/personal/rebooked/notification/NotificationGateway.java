package com.personal.rebooked.notification;

import com.personal.rebooked.notification.models.Notification;
import com.personal.rebooked.notification.respositories.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class NotificationGateway {

    private final NotificationRepository notificationRepository;

    private final SimpMessagingTemplate messagingTemplate;

    @EventListener
    public void handleSubscribeEvent(SessionSubscribeEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        String destination = headerAccessor.getDestination();
        if( destination != null && destination.startsWith("/topic.notifications.")) {
            String userId = destination.substring("/topic.notifications.".length());
            sendNotification(userId);
        }
    }

    //TODO: Add pagination
    public void sendNotification( String userId) {
        List<Notification> notifications = notificationRepository.findAllByUserId(userId);
        messagingTemplate.convertAndSend("/topic.notifications." + userId, notifications);
    }

    @MessageMapping("/notification.{notificationId}.read")
    public Notification markAsRead( @DestinationVariable String notificationId) {
        Notification notification = notificationRepository.findById(notificationId).orElse(null);
        if (notification == null) {
            return null;
        }
        notification.setRead(true);
        return notificationRepository.save(notification);
    }
}
