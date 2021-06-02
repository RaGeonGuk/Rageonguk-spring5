package com.edu.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
/**
 * 이 클래스는 오라클과 연동해서 CRUD를 테스트 하는 클래스입니다.
 * 과장(이사,팀장) JUnit CRUD 까지 만들어서 일반사원에게 공개
 * @author 라건국
 * 
 * 
 */
//Runwidth 인터페이스 현재클리스가 Junit 실행 클래스라고 명
@RunWith (SpringJUnit4ClassRunner.class)
//경로에서 ** 모든폴더명시, 모든파일명을 명시
@ContextConfiguration(locations = {"file:src/main/webaap/WEB-INF/spring**/*xml"})
@WebAppConfiguration
public class DataSourceTest{
	//디버그용 로그 객체변수생성
	private Logger logger = Logger.getLogger(DataSourceTest.class);
	
	@Test
	public void Junittest() {
		logger.debug("Junit테스트 시작입니다.");
	}
}