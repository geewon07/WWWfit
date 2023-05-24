package com.ssafy.wwwfit.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.ssafy.wwwfit.model.service.FCMService;
import com.ssafy.wwwfit.model.service.NotificationService;


//@RestController
//@RequestMapping("/api-noti")
@Component
public class NotificationScheduler {
    
	@Autowired
    private final FCMService fcmService;
	
	@Autowired
	private NotificationService notificationService;

    public NotificationScheduler(FCMService fcmService) {
        this.fcmService = fcmService;
    }

    @Scheduled(cron = "0 45 16 * * MON-FRI") // 매일 2시 15분에 실행
   public void sendNotification() throws FirebaseMessagingException {
        fcmService.sendNotification();
    }
   
   @Scheduled(cron = "0 30 10 ? * WED") // 매주 수요일 오전 10시 30분에 실행 (7일넘은 알림 삭제 )
   public void deleteOldNotification() {
	   LocalDate sevenDaysAgo = LocalDate.now().minusDays(7);
       String regDate = sevenDaysAgo.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
       notificationService.deleteOldNotification(regDate);
   }
}
