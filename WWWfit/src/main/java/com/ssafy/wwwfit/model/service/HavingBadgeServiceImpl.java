package com.ssafy.wwwfit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.wwwfit.model.dao.HavingBadgeDao;
import com.ssafy.wwwfit.model.dto.HavingBadge;

@Service
public class HavingBadgeServiceImpl implements HavingBadgeService {
    
	@Autowired
	private HavingBadgeDao havingBadgeDao;
	
	@Override
	public int registHavingBadge(int userNo) {
		return havingBadgeDao.createHavingBadge(userNo);
	}

	@Override
	public List<HavingBadge> readHavingBadge(int userNo) {
		return havingBadgeDao.getHavingBadge(userNo);
	}

	@Override
	public int deleteUserHavingBadge(int userNo) {
		return havingBadgeDao.deleteUserHavingBadge(userNo);
	}

}
