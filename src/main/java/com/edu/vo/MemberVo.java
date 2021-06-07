package com.edu.vo;
/**
 * 이클래스는 DB에서 Model 클래스로 입출력, Model에서 Service 클래스로 입출력
 * Service에서 Controller클래스 데이터를 입출력,
 * Controller에서 jsp로 데이터를 주고 받을때 사용하는 데이터 클래스입니다.
 * @author 라건국
 *
 */
public class MemberVo {
	//ERD를 보고 멤버변수를 만듭니다.
	private String user_id;
	private String user_pw;
	private String user_name;
	private String email;
	private Integer point;//int를 사용하지 않고 Integer라는 함수를 사용하는 이유 -> int는 일반형/ integer는 참조형(데이터형) 자료인데 참조형자료는 Null을 허용하기때문에 사용
	private Boolean enabled; // boolean으로 안쓰고 대문자로 사용한 이유는 위와 같이 Null허용하기 때문에 오류 안생기려고.
	private String levels; 
	private Date reg_date;
	private Date update_date;
	//책에서는 롬복loombok.jar 을 사용해서 아래 내용을 생략가능합니다.
	// 우리는 Get/Set을 만들어서 사용합니다.
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public String getLevels() {
		return levels;
	}
	public void setLevels(String levels) {
		this.levels = levels;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	
}
