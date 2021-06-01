package com.edu.controller;

//d외부 라이브러리(모듈) 사용 = import
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * 이 클래스는  MVC 웹프로젝트를 최로로 생성시 자동으로 생성되는 클래스
 * 웹 브라우저의 요청사항을 view 단(jsp)에 연결시켜주는 클래스 @Controller
 * 스프링에서 관리하는 클래스를 스프링빈(콩) = 스프링빈을 명시 @Controller 애노테이션
 * Beens(콩들) 그래프로 이 프로젝트의 규모를 확인 가능.
 * 스프링이 관리하는 클래스는 파일 아이콘 S가 붙습니다. 
 */

@Controller
public class HomeController {
	//스프링빈(클래스) 에서는 로거로 디버그를 합니다. = 로거객체를 만듭니다.
	// 로그중 slf4j(Spring Log For Java)
//	private Logger logger = Logger.
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * 사용자 요청(웹브라우저)을 받아서=@RequestMapping 인터페이스를 사용해서 메서드명을 스프링이 구현
	 * , route(루트routX)
	 * return 값으로 view를 선택해서 작업한 결과를 변수로 담아서 화면에 전송 후 결과를 표시(렌더링)합니다.
	 * 폼 전송시 post방식(자료 숨김), get방식(자료노출-URL쿼리스트링?있는자료전송)
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) { //콜백 메서드(함수), 자동실행
		String jspVar = "@서비스에서 처리한 결과";
		model.addAttribute("jspObject", jspVar);
		//home.jsp 파일로 자료를 전송하는 기능: model객체 인터페이스 객체(스프링이처리)에 내용만 채우면됨
		return "home"; //확장자가 생략 . jsp가 생략되어 있음.
	}
	
}
