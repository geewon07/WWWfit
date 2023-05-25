package com.ssafy.wwwfit.model.service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.ssafy.wwwfit.model.dao.UserDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FCMService {
	@Autowired
	private UserDao uDao;

    public void sendNotification() {
        List<String> tokens = uDao.gettokens();
        
        for(int i=0;i<tokens.size();i++) {
        	String token = tokens.get(i);
        	if(token != null) {
        	Message message = Message.builder()
                    .putData("title", "WWWfit2")
                    .putData("content", "운동하세요.")
                    .putData("click_action", "http://localhost:8080/")
                    .setToken(token)
                    .build();

            send(message);
        	}
        }
    	
//    	String token = "eVOOBW4b300N8CHOCzYhAn:APA91bEPdulIfWuIIXwAxx6eWx4Lvtw0s5AFYUAFbGWqbh-j2WGsFlNbtRBsBrgf_5sWEXNsyMZ9VX_2Dg51YeXKehKe2SdfJ_uO4dUNfG4PcdckqDwa9wKoijz7xksAOe-9PjmB2Gfv"; // 알림을 받을 대상의 토큰을 설정
//
//        Message message = Message.builder()
//                .putData("title", "WWWfit2")
//                .putData("content", "운동하세요.")
//                .putData("click_action", "http://localhost:8080/")
//                .setToken(token)
//                .build();
//
//        send(message);
    }

    public void send(Message message) {
        FirebaseMessaging.getInstance().sendAsync(message);
    }
}