package com.ssafy.wwwfit.model.dto;

public class HavingBadge {
	// 고민해보자
	// boolean으로 할 것인지 int형으로 5개를 만들어서 할것인지....!
	private int havingbadgeId;
	private int userNo;
	private Boolean neck_count5;
	private Boolean neck_count10;
	private Boolean neck_count20;
	private Boolean neck_count50;
	private Boolean neck_count100;
	
	private Boolean shoulder_count5;
	private Boolean shoulder_count10;
	private Boolean shoulder_count20;
	private Boolean shoulder_count50;
	private Boolean shoulder_count100;
	
	private Boolean back_count5;
	private Boolean back_count10;
	private Boolean back_count20;
	private Boolean back_count50;
	private Boolean back_count100;
	
	private Boolean hand_count5;
	private Boolean hand_count10;
	private Boolean hand_count20;
	private Boolean hand_count50;
	private Boolean hand_count100;
	
	private Boolean eye_count5;
	private Boolean eye_count10;
	private Boolean eye_count20;
	private Boolean eye_count50;
	private Boolean eye_count100;
	
	private Boolean leg_count5;
	private Boolean leg_count10;
	private Boolean leg_count20;
	private Boolean leg_count50;
	private Boolean leg_count100;
	public HavingBadge(int havingbadgeId, int userNo, Boolean neck_count5, Boolean neck_count10,
			Boolean neck_count20, Boolean neck_count50, Boolean neck_count100, Boolean shoulder_count5,
			Boolean shoulder_count10, Boolean shoulder_count20, Boolean shoulder_count50, Boolean shoulder_count100,
			Boolean back_count5, Boolean back_count10, Boolean back_count20, Boolean back_count50,
			Boolean back_count100, Boolean hand_count5, Boolean hand_count10, Boolean hand_count20,
			Boolean hand_count50, Boolean hand_count100, Boolean eye_count5, Boolean eye_count10, Boolean eye_count20,
			Boolean eye_count50, Boolean eye_count100, Boolean leg_count5, Boolean leg_count10, Boolean leg_count20,
			Boolean leg_count50, Boolean leg_count100) {
		super();
		this.havingbadgeId = havingbadgeId;
		this.userNo = userNo;
		this.neck_count5 = neck_count5;
		this.neck_count10 = neck_count10;
		this.neck_count20 = neck_count20;
		this.neck_count50 = neck_count50;
		this.neck_count100 = neck_count100;
		this.shoulder_count5 = shoulder_count5;
		this.shoulder_count10 = shoulder_count10;
		this.shoulder_count20 = shoulder_count20;
		this.shoulder_count50 = shoulder_count50;
		this.shoulder_count100 = shoulder_count100;
		this.back_count5 = back_count5;
		this.back_count10 = back_count10;
		this.back_count20 = back_count20;
		this.back_count50 = back_count50;
		this.back_count100 = back_count100;
		this.hand_count5 = hand_count5;
		this.hand_count10 = hand_count10;
		this.hand_count20 = hand_count20;
		this.hand_count50 = hand_count50;
		this.hand_count100 = hand_count100;
		this.eye_count5 = eye_count5;
		this.eye_count10 = eye_count10;
		this.eye_count20 = eye_count20;
		this.eye_count50 = eye_count50;
		this.eye_count100 = eye_count100;
		this.leg_count5 = leg_count5;
		this.leg_count10 = leg_count10;
		this.leg_count20 = leg_count20;
		this.leg_count50 = leg_count50;
		this.leg_count100 = leg_count100;
	}
	public HavingBadge() {
		super();
	}
	public int getHavingbadgeId() {
		return havingbadgeId;
	}
	public void setHavingbadgeId(int havingbadgeId) {
		this.havingbadgeId = havingbadgeId;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public Boolean getNeck_count5() {
		return neck_count5;
	}
	public void setNeck_count5(Boolean neck_count5) {
		this.neck_count5 = neck_count5;
	}
	public Boolean getNeck_count10() {
		return neck_count10;
	}
	public void setNeck_count10(Boolean neck_count10) {
		this.neck_count10 = neck_count10;
	}
	public Boolean getNeck_count20() {
		return neck_count20;
	}
	public void setNeck_count20(Boolean neck_count20) {
		this.neck_count20 = neck_count20;
	}
	public Boolean getNeck_count50() {
		return neck_count50;
	}
	public void setNeck_count50(Boolean neck_count50) {
		this.neck_count50 = neck_count50;
	}
	public Boolean getNeck_count100() {
		return neck_count100;
	}
	public void setNeck_count100(Boolean neck_count100) {
		this.neck_count100 = neck_count100;
	}
	public Boolean getShoulder_count5() {
		return shoulder_count5;
	}
	public void setShoulder_count5(Boolean shoulder_count5) {
		this.shoulder_count5 = shoulder_count5;
	}
	public Boolean getShoulder_count10() {
		return shoulder_count10;
	}
	public void setShoulder_count10(Boolean shoulder_count10) {
		this.shoulder_count10 = shoulder_count10;
	}
	public Boolean getShoulder_count20() {
		return shoulder_count20;
	}
	public void setShoulder_count20(Boolean shoulder_count20) {
		this.shoulder_count20 = shoulder_count20;
	}
	public Boolean getShoulder_count50() {
		return shoulder_count50;
	}
	public void setShoulder_count50(Boolean shoulder_count50) {
		this.shoulder_count50 = shoulder_count50;
	}
	public Boolean getShoulder_count100() {
		return shoulder_count100;
	}
	public void setShoulder_count100(Boolean shoulder_count100) {
		this.shoulder_count100 = shoulder_count100;
	}
	public Boolean getBack_count5() {
		return back_count5;
	}
	public void setBack_count5(Boolean back_count5) {
		this.back_count5 = back_count5;
	}
	public Boolean getBack_count10() {
		return back_count10;
	}
	public void setBack_count10(Boolean back_count10) {
		this.back_count10 = back_count10;
	}
	public Boolean getBack_count20() {
		return back_count20;
	}
	public void setBack_count20(Boolean back_count20) {
		this.back_count20 = back_count20;
	}
	public Boolean getBack_count50() {
		return back_count50;
	}
	public void setBack_count50(Boolean back_count50) {
		this.back_count50 = back_count50;
	}
	public Boolean getBack_count100() {
		return back_count100;
	}
	public void setBack_count100(Boolean back_count100) {
		this.back_count100 = back_count100;
	}
	public Boolean getHand_count5() {
		return hand_count5;
	}
	public void setHand_count5(Boolean hand_count5) {
		this.hand_count5 = hand_count5;
	}
	public Boolean getHand_count10() {
		return hand_count10;
	}
	public void setHand_count10(Boolean hand_count10) {
		this.hand_count10 = hand_count10;
	}
	public Boolean getHand_count20() {
		return hand_count20;
	}
	public void setHand_count20(Boolean hand_count20) {
		this.hand_count20 = hand_count20;
	}
	public Boolean getHand_count50() {
		return hand_count50;
	}
	public void setHand_count50(Boolean hand_count50) {
		this.hand_count50 = hand_count50;
	}
	public Boolean getHand_count100() {
		return hand_count100;
	}
	public void setHand_count100(Boolean hand_count100) {
		this.hand_count100 = hand_count100;
	}
	public Boolean getEye_count5() {
		return eye_count5;
	}
	public void setEye_count5(Boolean eye_count5) {
		this.eye_count5 = eye_count5;
	}
	public Boolean getEye_count10() {
		return eye_count10;
	}
	public void setEye_count10(Boolean eye_count10) {
		this.eye_count10 = eye_count10;
	}
	public Boolean getEye_count20() {
		return eye_count20;
	}
	public void setEye_count20(Boolean eye_count20) {
		this.eye_count20 = eye_count20;
	}
	public Boolean getEye_count50() {
		return eye_count50;
	}
	public void setEye_count50(Boolean eye_count50) {
		this.eye_count50 = eye_count50;
	}
	public Boolean getEye_count100() {
		return eye_count100;
	}
	public void setEye_count100(Boolean eye_count100) {
		this.eye_count100 = eye_count100;
	}
	public Boolean getLeg_count5() {
		return leg_count5;
	}
	public void setLeg_count5(Boolean leg_count5) {
		this.leg_count5 = leg_count5;
	}
	public Boolean getLeg_count10() {
		return leg_count10;
	}
	public void setLeg_count10(Boolean leg_count10) {
		this.leg_count10 = leg_count10;
	}
	public Boolean getLeg_count20() {
		return leg_count20;
	}
	public void setLeg_count20(Boolean leg_count20) {
		this.leg_count20 = leg_count20;
	}
	public Boolean getLeg_count50() {
		return leg_count50;
	}
	public void setLeg_count50(Boolean leg_count50) {
		this.leg_count50 = leg_count50;
	}
	public Boolean getLeg_count100() {
		return leg_count100;
	}
	public void setLeg_count100(Boolean leg_count100) {
		this.leg_count100 = leg_count100;
	}
	
	

}
