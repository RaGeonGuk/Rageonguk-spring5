package com.edu.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.service.IF_MemberService;
import com.edu.vo.MemberVO;
import com.edu.vo.PageVO;

/**
 * 이 클래스는 Admin관리자단을 접근하는 클래스
 * 변수 Object를 만들어서 jsp로 전송 + jsp 값을 받아서 클래스에서 Object로처리
 * @author 라건국
 * 수정자: 아무개 20210602 수정 
 *
 */
@Controller
public class AdminController {
	//컨트롤러 수정하면 자동로딩(auto 컴파일)
	// 디버그용 로그객체 생성(아래)
	private Logger logger = LoggerFactory.getLogger(AdminController.class);
	// 이 메서드는 회원목록을 출력하는 jsp와 매핑이 됩니다.
	@Inject
	private IF_MemberService memberService;
	
	@RequestMapping(value="/admin/member/member_view", method=RequestMethod.GET)
	public String viewMemberForm(Model model, @RequestParam("user_id")String user_id, @ModelAttribute("pageVO")PageVO pageVO) throws Exception{
		/*
		 * 이 메서드는 리스트페이지에서 상세보기로 이동할때 보여주는 1개 레코드값을 보여주는 구현을 합니다.
		 * JUnit에서 테스트했던 readMember 방식을 이용.
		 * 다른점은 JUnit에서는 식별자ID를 강제로 지정했찌만, 이 메서드 에서는 @RequestParam인터페이스를 이용해서 식별자 값을 받음.
		 */
		memberService.readMember(user_id);
		// 위 출력값 memberVO 1개의 레코드를model을 이용해서 member_view.jsp보냅니다.(아래)
		model.addAttribute("memberVO", memberService.readMember(user_id));
		return "admin/member/member_view"; //상태경로 폴더파일위치
	}
	@RequestMapping(value="/admin/member/member_list", method=RequestMethod.GET)
	public String selecetmember (@ModelAttribute("pageVO")PageVO pageVO, Model model) throws Exception {
		/* 
		이 메서드는 2개 객체 생성하는 로직이 필요. 결과를 JSP로 보내는 기능을 수행
		1 객체: memberList객체를 생성해서 model을 통해서 jsp로 전송
		2 객체: pageVO객체(perv, next, startPage,endPage)를 생성해서 model을 통해서 jsp로 전송
		2번객체부터 로직이 필요 -> memberList구하는 쿼리 변수가 만들어지기 때문에 이것부터 구현
		*/
		if (pageVO.getPage() == null) { //jsp에서 클릭값이 없을때만 초기값 입력
			pageVO.setPage(1); //초기값 1페이지 입력
		}
		// 학습포인트: calcPage()로직 < 변수(객체) 값의 이동확인 중요 (코딩)
		pageVO.setQueryPerPageNum(5); //memberList객체 + endPage구할때 필요
		pageVO.setPerPageNum(5);//startPage,endPage구할때 -UI하단 페이지 번호 개수
		// 위 2개의 변수값을 이용해서 아래 setTotalCount메서드에서 calcPage()호출됨
		pageVO.setTotalCount(memberService.countMember(pageVO));
		// calcPage 실행되면, prev, next 변수값이 입력됩니다.
		List<MemberVO> listMember = memberService.selectMember(pageVO);
		// 위 setPerPageNum 20이면 next가 false(비활성화), 5이면 next 가  true(활성화)
		logger.info("디버그" + pageVO.toString());// 지금까지 jsp->컨트롤러 일방향 자료 이동.
		//컨트롤러에서 jsp로 역방향으로 보내는 자료를 Model에 담아서 보내게 됩니다.
		model.addAttribute("listMember", listMember);
		model.addAttribute("pageVO", pageVO); //나중에 @ModelAttribute로 다시 보냄?
		return "admin/member/member_list"; //jsp파일 상대경로;
	}
	// URL요청 경로는 @RequestMappingt 반드시 절대경로로 표시
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String admin(Model model) throws Exception { //에러발생시 Exception 클래스의의 정보를  스프링으로 보내게 됩니다.
		
		//아래 상대경로에서/WEB-INF/views/폴더가 루트(생략prefix접두어) 입니다.
		//아래 상대경로 home.jsp에서 .jps는 (생략 suffix접미어) 입니다.
		return "admin/home"; //리턴 경로 = 접근경로는 반드시 상대경로로 표시한다
	}
}
