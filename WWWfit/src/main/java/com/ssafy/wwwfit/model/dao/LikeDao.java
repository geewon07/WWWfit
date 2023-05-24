package com.ssafy.wwwfit.model.dao;

import java.util.List;

import com.ssafy.wwwfit.model.dto.Like;
//포스터에 좋아요? 댓글에 좋아요?
//팔로우한 유저가 좋아요 누른 포스터-->심화
public interface LikeDao {
	//-->like 에는 posterSeq 들이 들어있음,,, 이것을 하나하나 전부 표시해야 함--> 뷰에서 생각할 일? 디테일 뷰
	public List<Like> selectAll(int userNo);
	//포스터에 좋아요 누른 유저리스트, 이리스트 참고해서 좋아요 수 뽑기
	public List<Like> selectOne(int posterSeq);
	
	public Like selectLike(int likeId);
	
	//보류?
	//select count(userId) from likeposters where posterSeq = #{posterSeq};
	public int numLikes(int posterSeq);//? 굳이 해야할까? .size 돌리면 되나?
	
	//select likeposterId from likeposters where userId=#{userId} and posterSeq = #{posterSeq};
	public int alreadyliked(int userNo, int posterSeq);
	//like
	public int insert(Like like);
	
	//unlike
	//삭제 버튼은 본인과 관리자만 보이게,, 뷰!, 서비스에서도 확인
	public int delete(int likeId);
	
	
	
	
	
	

}
