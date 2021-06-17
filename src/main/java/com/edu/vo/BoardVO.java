package com.edu.vo;

import java.util.Date;

/**
 * 이 클래스는 게시물 CRUD에 필요한 멤버변수(필드)가 정의된 클래스 입니다.
 * 목적은 데이터 변수값 이동시 Get/Set 작업이 주 목적입니다.
 * @author 라건국
 *
 */
public class BoardVO {
	//멤버변수 생성
	private Integer bon;
	private String title;
	private String content;
	private String writer;
	private Integer view_count;
	private Integer reply_count;
	private Date reg_date;
	private Date update;
	private Integer board_type; //FK
	//디버그용 toString()생성
	@Override
	public String toString() {
		return "BoardVO [bon=" + bon + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", view_count=" + view_count + ", reply_count=" + reply_count + ", board_type=" + board_type + "]";
	}

	//
	public Integer getBon() {
		return bon;
	}
	public void setBon(Integer bon) {
		this.bon = bon;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Integer getView_count() {
		return view_count;
	}
	public void setView_count(Integer view_count) {
		this.view_count = view_count;
	}
	public Integer getReply_count() {
		return reply_count;
	}
	public void setReply_count(Integer reply_count) {
		this.reply_count = reply_count;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public Date getUpdate() {
		return update;
	}
	public void setUpdate(Date update) {
		this.update = update;
	}
	public Integer getBoard_type() {
		return board_type;
	}
	public void setBoard_type(Integer board_type) {
		this.board_type = board_type;
	}
}
