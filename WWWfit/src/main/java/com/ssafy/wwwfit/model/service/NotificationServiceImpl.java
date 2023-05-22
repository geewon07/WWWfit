package com.ssafy.wwwfit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.services.storage.model.Notification;
import com.ssafy.wwwfit.model.dao.NotificationDao;

@Service
public class NotificationServiceImpl implements NotificationService {
	@Autowired
	private NotificationDao uDao;
	@Override
	public int insertNotification(int userNo, String context) {
		// TODO Auto-generated method stub
		return uDao.insertNotification(userNo, context);
	}

	@Override
	public int deleteOldNotification(String regDate) {
		return uDao.deleteOldNotification(regDate);
	}

	@Override
	public int deleteNotification(int NoticationNo) {
		return uDao.deleteNotification(NoticationNo);
	}

	@Override
	public List<Notification> getNotification(int userNo) {
		return uDao.getNotification(userNo);
	}

}
