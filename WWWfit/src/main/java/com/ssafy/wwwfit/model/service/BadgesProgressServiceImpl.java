package com.ssafy.wwwfit.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.wwwfit.model.dao.BadgesProgressDao;
import com.ssafy.wwwfit.model.dao.HavingBadgeDao;
import com.ssafy.wwwfit.model.dao.NotificationDao;
import com.ssafy.wwwfit.model.dao.UserDao;
import com.ssafy.wwwfit.model.dto.User;

@Service
public class BadgesProgressServiceImpl implements BadgesProgressService {
    
	@Autowired
    private BadgesProgressDao badgesProgressDao;
	@Autowired
    private HavingBadgeDao havingBadgeDao;
	@Autowired
	private NotificationDao notificationDao;
	@Autowired
	private UserDao userDao;
    
	@Override
	public int registBagesProgress(int userNo) {
		return badgesProgressDao.createBadgesprogress(userNo);
	}

	@Override
	public int updateBagesProgress(int userNo, String fitPartName) {
		
		int task = badgesProgressDao.fitPartNamecountupdate(userNo, fitPartName);
		
		int count = badgesProgressDao.getFitPartNamecount(userNo, fitPartName); // count 값 반환 ( 내가 운동을 얼마나 했는지 ) 
		
		if(count == 5 || count == 10 || count == 20 || count == 50 || count == 100) {
			Map<String, String> params = new HashMap<String, String>();
			
			params.put("userNo", String.valueOf(userNo));
			params.put("fitPartName", fitPartName);
			params.put("count",String.valueOf(count));
			System.out.println(fitPartName);
			String context = "";
			context += "[뱃지 획득] ";
			if(fitPartName.equals("neck")) {
			    context += "목지킴이 ";
			} else if(fitPartName.equals("leg")) {
			    context += "다리지킴이 ";
			} else if(fitPartName.equals("shoulder")) {
			    context += "어깨지킴이 ";
			} else if(fitPartName.equals("back")) {
			    context += "등지킴이 ";
			} else if(fitPartName.equals("hand")) {
			    context += "손지킴이 ";
			} else {
			    context += "눈지킴이 ";
			}
			context += String.valueOf(count);
			context += "회를 달성하였습니다.";
			notificationDao.insertNotification(userNo, context);
			return havingBadgeDao.updateHavingBadge(params);
		} else return task;
	}

	@Override
	public int deleteUserBadgesProgress(int userNo) {
		return badgesProgressDao.deleteUserBadgesProgress(userNo);
	}

}
