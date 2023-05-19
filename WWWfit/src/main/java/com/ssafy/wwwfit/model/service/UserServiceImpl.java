package com.ssafy.wwwfit.model.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.wwwfit.model.dao.CalendarDao;
import com.ssafy.wwwfit.model.dao.UserDao;
import com.ssafy.wwwfit.model.dto.SearchCondition;
import com.ssafy.wwwfit.model.dto.User;

//로그인 구현해야함!!


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao uDao;
	
	@Autowired
	private CalendarDao cDao;
	
	@Override
	public int regist(User user) {
		int result = uDao.insert(user);
		return result;
	}

	@Override
	public List<User> getUsers() {
		List<User> allUsers = uDao.selectAll();
		return allUsers;
	}

	@Override
	public List<User> searchUser(SearchCondition condition) {
		List<User> searchResult = uDao.searchBy(condition);
		return searchResult;
	}

	@Override/// 이거 이용해서 다른 서비스에서 유저정보 갱신할때 필요할 수 도>???? 분리해서 만들까??각 서비스마다 호출 가능한것 분리>?
	public int updateInfo(User user) {// 비밀번호 검증
		int result = uDao.update(user);
		return result;
	}

	@Override
	public int getExp(User user, int points) {
		//여기서???? 증감???
		user.setExperience(user.getExperience()+points);
		// if 문으로 특정 리밋 초과시 등급업도 시켜줄까??
		if(user.getExperience()>=20) {// switch 문으로 ??
//			rankUp(user);
		}
		//새싹 
		int exp=user.getExperience();
		if(exp<10&&0<exp) {
			user.setUserRank("Green");
		}else if(exp<20) {
			user.setUserRank("Bronze");
		}else if(exp<40) {
			user.setUserRank("Silver");
		}else if(exp<60) {
			user.setUserRank("Gold");
		}else if(exp>80) {
			user.setUserRank("VIP");
		}
		
		
		int result = uDao.update(user);
		return result;
	}


	@Override
	public int challengeProgress(User user) {
		int result = uDao.update(user);
		return result;
	}

	@Override
	public int quit(int userNo) {
		int result =uDao.delete(userNo);
		// 여기서 다른 서비스 전부다 호출해서 update 유저아이디 "탈퇴한 유저"로 바꿔주기,,,,
		//진짜로?
		//비밀번호 검증
		
		
		return result;
	}

	@Override
	public User getUser(int userNo) {
		User selectedUser = uDao.selectOne(userNo);
		return selectedUser;
	}

	@Override
	public Integer login(String userId, String password) {
//		String get = uDao.login(userId, password);
		
//		int result = get.equals("null")?0:Integer.parseInt(get);
		
		Integer result =  uDao.login(userId, password);
		System.out.println(result);
		return result;//==1?true:false;
	}

	@Override
	public void updatechallengedays(int userNo, String today) { // 평일만 확인하기!
		String[] str = today.split("-");
		LocalDate date = LocalDate.of(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]));
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		int todayWeek = dayOfWeek.getValue();
		
		if(todayWeek == 1) {
			LocalDate fridaydate = date.minusDays(3);
			String friday = fridaydate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			String yesterdayexcise = cDao.getCalendarDay(userNo, friday);
			if(yesterdayexcise == null) {
				int challengedays = 1;
				int check = 0;
				uDao.updatechallengedays(userNo, challengedays, check);
			} else {
				int check = 1;
				int challengedays = 1;
				uDao.updatechallengedays(userNo, challengedays, check);
			}
		} else {
			LocalDate yesterdaydate = date.minusDays(1);
			String yesterday = yesterdaydate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			
			String yesterdayexcise = cDao.getCalendarDay(userNo, yesterday);
			if(yesterdayexcise == null) {
				int challengedays = 1;
				int check = 0;
				uDao.updatechallengedays(userNo, challengedays, check);
			} else {
				int check = 1;
				int challengedays = 1;
				uDao.updatechallengedays(userNo, challengedays, check);
			}
		}
	}

	@Override
	public int getchallengedays(int userNo) {
		return uDao.getchallengedays(userNo);
		}

//	@Override
//	public int loginUser() {
//		login
//		return 0;
//	}

}
