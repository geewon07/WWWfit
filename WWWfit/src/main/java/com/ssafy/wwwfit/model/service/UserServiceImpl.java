package com.ssafy.wwwfit.model.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
		if(exp<10&&0<=exp) {
			user.setUserRank("Green");
		}else if(exp<20) {
			user.setUserRank("Bronze");
		}else if(exp<40) {
			user.setUserRank("Silver");
		}else if(exp<60) {
			user.setUserRank("Gold");
		}else if(exp<=100) {
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

				System.out.println("인식됨");
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

	@Override
	public int updateTokenFirebase(int userNo, String token) {
		return uDao.updateTokenFirebase(userNo, token);
	}

	@Override
	public List<String> gettokens() {
		// TODO Auto-generated method stub
		return uDao.gettokens();
	}

	@Override
	public String getKakaoAccessToken (String code) {
        String access_Token = "";
//        String email = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //POST 요청을 위해 기본값이 false인 setDoOutput을 true로
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            //POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=948d2203ba0cab173c54be84a312f82b"); // TODO REST_API_KEY 입력
            sb.append("&redirect_uri=http://localhost:8080/login"); // TODO 인가코드 받은 redirect_uri 입력
            sb.append("&code=" + code);
            bw.write(sb.toString());
            bw.flush();

            //결과 코드가 200이라면 성공
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            //요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> resultMap = objectMapper.readValue(result, new TypeReference<Map<String, Object>>() {});
          
            //Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
//            JsonParser parser = new JsonParser();
//            JsonElement element = parser.parse(result);
              
            
            access_Token = (String) resultMap.get("access_token");
//            System.out.println("!!!!!"+access_Token);
//            refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();
//
//            System.out.println("access_token : " + access_Token);
//            System.out.println("refresh_token : " + refresh_Token);
//
//            br.close();
//            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//
        return access_Token;
    }

	@Override
	public User createKakaoUser(String access_token) {
		String reqURL = "https://kapi.kakao.com/v2/user/me";
        String email = "";
        long id = 0;
        String userId ="";
        String name = "";
        String password = "";
		//access_token을 이용하여 사용자 정보 조회
	    try {
	       URL url = new URL(reqURL);
	       HttpURLConnection conn = (HttpURLConnection) url.openConnection();

	       conn.setRequestMethod("POST");
	       conn.setDoOutput(true);
	       conn.setRequestProperty("Authorization", "Bearer " + access_token); //전송할 header 작성, access_token전송

	       //결과 코드가 200이라면 성공
	       int responseCode = conn.getResponseCode();
	       System.out.println("responseCode : " + responseCode);

//	       //요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
	       BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	       String line = "";
	       String result = "";
//
	       while ((line = br.readLine()) != null) {
	           result += line;
	       }
	       System.out.println("response body : " + result);
//
//	       //Gson 라이브러리로 JSON파싱
	       ObjectMapper objectMapper = new ObjectMapper();
           Map<String, Object> resultMap = objectMapper.readValue(result, new TypeReference<Map<String, Object>>() {});
//         access_Token = (String) resultMap.get("access_token");
	       id = (long) resultMap.get("id");
	       Map<String, Object> kakaoAccount = (Map<String, Object>) resultMap.get("kakao_account");
	       boolean hasEmail = (boolean) kakaoAccount.get("has_email");
	       if(hasEmail){
	           email = (String) kakaoAccount.get("email");
	       }
	       Map<String, Object> properties = (Map<String, Object>) resultMap.get("properties");
           name = (String) properties.get("nickname");
	       
           System.out.println("id : " + id);
	       System.out.println("email : " + email);
           System.out.println(name);
//	       br.close();
           
	       } catch (IOException e) {
	            e.printStackTrace();
	       }
	       // user의 id는 이메일에서@앞
	        // 비번 : 이메일 + 고유 id
//	      System.out.println(email);
	      int idx = email.indexOf("@");
	      if(idx > 1) {
	      userId = email.substring(0,idx);}
	      password = email + id;
	      return new User(userId, password, name, email);
	}

	@Override
	public int getUserId(String userId) {
		// TODO Auto-generated method stub
		return uDao.getUserId(userId);
	}

	@Override
	public int insert_kakao(User user) {
		// TODO Auto-generated method stub
		return uDao.insert_kakao(user);
	}

//	@Override
//	public User kakaoLogin(String code) {
//		return null;
//	}

//	
//	@Override
//	public int loginUser() {
//		login
//		return 0;
//	}

}
