package com.ssafy.wwwfit.model.service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import org.springframework.stereotype.Service;


@Service
public class FCMService {

    public void sendNotification() {
        String token = "evjCzdiZtzYhx352GtbTnK:APA91bEC-ITbrG1JLUkR6F0B9Wsok2CDdHZBteX5ZwvmYwX1W_fgh6iQACFVeK_vdXYoyg-mIwfXfFJgSLbAofa6eC-470xiAyXffDA3HjrPtgJ_bJ3tYJEfTwOzSwr611FPWQgYTRD5"; // 알림을 받을 대상의 토큰을 설정

        Message message = Message.builder()
                .putData("title", "WWWfit2")
                .putData("content", "운동하세요1.")
                .setToken(token)
                .build();

        send(message);
    }

    public void send(Message message) {
        FirebaseMessaging.getInstance().sendAsync(message);
    }
}