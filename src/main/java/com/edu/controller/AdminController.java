package com.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 이 클래스는 Admin관리자단을 접근하는 클래스
 * 변수 Object를 만들어서 jsp로 전송 + jsp 값을 받아서 클래스에서 Object로처리
 * @author 라건국
 * 수정자: 아무개 20210602 수정 
 *
 */
@Controller
public class AdminController {
	// URL요청 경로는 @RequestMapping 반드시 절대경로로 표시
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String admin(Model model) {
		
		//아래 상대경로에서/WEB-INF/views/폴더가 루트(생략prefix접두어) 입니다.
		//아래 상대경로 home.jsp에서 .jps는 (생략 suffix접미어) 입니다.
		return "admin/home"; //리턴 경로 = 접근경로는 반드시 상대경로로 표시한다
	}
}
