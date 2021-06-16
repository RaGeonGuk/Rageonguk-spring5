package com.edu.vo;
/**
 * 이 클래스는 게시판 생성관리의 데이터를 입/출력 임시저장하는 기능의 클래스
 * 이 클래스를 이용해서 AspectOrientidePrograming(관점지향 프로그램) 실습
 * @author 라건국
 * 20210616
 */
public class BoardTypeVO {
	//멤버변수 생성
	private String board_type; //PK 고유값, 식별자
	private String board_name; 
	private Integer Board_sun; //integer로 한 이유: int는 null을 허용 nullPoint 예외 처리 방지가능
	//입출력 가능한 메서드를 만듭니다.
	public String getBoard_type() {
		return board_type;
	}
	public void setBoard_type(String board_type) {
		this.board_type = board_type;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public Integer getBoard_sun() {
		return Board_sun;
	}
	public void setBoard_sun(Integer board_sun) {
		Board_sun = board_sun;
	}
	
	
	
}
