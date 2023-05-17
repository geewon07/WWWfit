package com.ssafy.wwwfit.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	private static final String SALT ="SSAFIT";
	
	//토큰 생성 인자로 키와 밸류가 넘어왔다고 처리 --> 우리는 데이터 바구니,,, dto로 써야??
	public String createToken(String claimMap, Map<String, String> data) throws Exception {
		return Jwts.builder()
				.setHeaderParam("alg", "HS256")
				.setHeaderParam("typ", "JWT")//헤더완료
				.claim(claimMap,data)
//				.claim("userId", "ssafy")
//				.setExpiration(new Date(System.currentTimeMillis()+3000))//페이로드 완료
				.signWith(SignatureAlgorithm.HS256, SALT.getBytes("UTF-8"))//서명 완료
				.compact();//토큰형식으로
		
	}
	
	public void valid(String token)throws Exception{
//		Jws<Claims> claims=
			Jwts.parser().setSigningKey("SSAFIT".getBytes("UTF-8")).parseClaimsJws(token);
//		System.out.println(claims);
	}

}
