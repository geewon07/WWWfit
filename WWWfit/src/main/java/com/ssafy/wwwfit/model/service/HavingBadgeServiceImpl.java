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
	public int registHavingBadge(String userId) {
		return havingBadgeDao.createHavingBadge(userId);
	}

	@Override
	public List<HavingBadge> readHavingBadge(String userId) {
		return havingBadgeDao.getHavingBadge(userId);
	}

}
