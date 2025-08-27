package com.personal.rebooked.notification;

import com.personal.rebooked.book.BookService;
import com.personal.rebooked.book.models.Book;
import com.personal.rebooked.chat.ChatService;
import com.personal.rebooked.chat.models.Chat;
import com.personal.rebooked.notification.dtos.CreateNotificationDto;
import com.personal.rebooked.notification.models.Notification;
import com.personal.rebooked.notification.respositories.NotificationRepository;
import com.personal.rebooked.user.UserService;
import com.personal.rebooked.user.models.User;
import com.personal.rebooked.user.repositories.UserRepository;
import com.personal.rebooked.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    private final UserService userService;
    private final ChatService chatService;
    private final BookService bookService;

    public Notification createNotification(CreateNotificationDto createNotificationDto) {
        User user = userService.findUserById(createNotificationDto.userId());
        Notification notification = new Notification();
        notification.setUser(user);
        notification.setMessage(createNotificationDto.message());
        if (createNotificationDto.metaType() != null && createNotificationDto.id() != null) {
            Notification.MetaData metaData =new  Notification.MetaData();
            if( createNotificationDto.metaType() == Constants.NotificationMetaType.BOOK_STATUS_CHANGED) {
                metaData.setMetaType(Constants.NotificationMetaType.BOOK_STATUS_CHANGED);
                Book book = bookService.findById(createNotificationDto.id());
                metaData.setBook(book);
            } else if (createNotificationDto.metaType() == Constants.NotificationMetaType.NEW_MESSAGE) {
                metaData.setMetaType(Constants.NotificationMetaType.NEW_MESSAGE);
                Chat chat = chatService.findById(createNotificationDto.id());
                metaData.setChat(chat);
            }
            notification.setMetaData(metaData);
        }
      return notificationRepository.save(notification);
    }

    public Notification findById(String id) {
        return notificationRepository.findById(id).orElse(null);
    }

    public List<Notification> findAllByUserId(String userId) {
        return notificationRepository.findAllByUserId(userId);
    }

    public void markNotificationAsRead(String id) {
        Notification notification = findById(id);
        if (notification != null) {
            notification.setRead(true);
            notificationRepository.save(notification);
        };
    }

    public Notification create(Notification notification) {
        return notificationRepository.save(notification);
    }
}
