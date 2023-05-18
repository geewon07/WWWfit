package com.ssafy.wwwfit.model.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.wwwfit.model.dao.BadgesProgressDao;
import com.ssafy.wwwfit.model.dao.HavingBadgeDao;

@Service
public class BadgesProgressServiceImpl implements BadgesProgressService {
    
	@Autowired
    private BadgesProgressDao badgesProgressDao;
	@Autowired
    private HavingBadgeDao havingBadgeDao;
    
	@Override
	public int registBagesProgress(int userNo) {
		return badgesProgressDao.createBadgesprogress(userNo);
	}

	@Override
	public int updateBagesProgress(int userNo, String fitPartName) {
		
		int task = badgesProgressDao.fitPartNamecountupdate(userNo, fitPartName);
		
		int count = badgesProgressDao.getFitPartNamecount(userNo, fitPartName); // count 값 반환 ( 내가 운동을 얼마나 했는지 ) 
		
		if(count == 5 | count == 10 | count == 20 | count == 50 | count == 100) {
			HashMap<String, String> params = new HashMap<String, String>();
			
			params.put("userNo", String.valueOf(userNo));
			params.put("fitPartName", fitPartName);
			params.put("count",String.valueOf(count));
			return havingBadgeDao.updateHavingBadge(params);
		} else return task;
	}

	@Override
	public int deleteUserBadgesProgress(int userNo) {
		return badgesProgressDao.deleteUserBadgesProgress(userNo);
	}

}
