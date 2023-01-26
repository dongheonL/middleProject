package com.jsp.dto;

import java.util.Date;

public class MemberVO {

	private String id;  //아이디
	private String pwd; //패스워드
    private String name="---"; //이름
    private String phone; //전화번호
	private String email;  //이메일
	private String nickName; // 닉네임
	private String picture; //사진파일 경로/파일명
	private Date regDate; // 등록일
	private int emailCheck; //이메일수신여부
	private int massageCheck; //문자수신여부
	private String role; // 권한
	private String address;//주소
	private String department; //부서
	   
	public MemberVO() {}

	public MemberVO(String id, String pwd, String name, String phone, String email, String nickName, String picture,
			int emailCheck, int massageCheck, String role, String address, String department) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name =name; 
		this.phone = phone;
		this.email = email;
		this.nickName = nickName;
		this.picture = picture;
		this.emailCheck = emailCheck;
		this.massageCheck = massageCheck;
		this.role = role;
		this.address = address;
		this.department = department;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getEmailCheck() {
		return emailCheck;
	}

	public void setEmailCheck(int emailCheck) {
		this.emailCheck = emailCheck;
	}

	public int getMassageCheck() {
		return massageCheck;
	}

	public void setMassageCheck(int massageCheck) {
		this.massageCheck = massageCheck;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}


	   
}