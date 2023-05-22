package com.ssafy.wwwfit.model.service;

import java.util.List;

import com.google.api.services.storage.model.Notification;

public interface NotificationService {
	
	public int insertNotification(int userNo, String context);
	
	//날짜몇일 이상된 알림삭제하는 기능 ( 주기적으로 알림 오래된 것들을 삭제해주면 좋을 텐데 )
		public int deleteOldNotification(String regDate);
		
		public int deleteNotification(int NoticationNo);
		
		// 현재시간을 기준으로 일주일단위 알림만 가져오게 java에서 처리해주는 것도 좋을 듯?
		public List<Notification> getNotification(int userNo);
}
