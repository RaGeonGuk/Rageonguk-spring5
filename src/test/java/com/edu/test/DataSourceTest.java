package com.edu.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

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
	//dataSource객체는 데이터베이스 객체를 pool로 저장해서 사용할때 DataSource 클래스를 사용(아래)
	@Inject //인젝트는 스프링에서 객체를 만드는 방법, 이전 자바에서는 new 키워드로 객체를 만들었고...
	DataSource dataSource; // 객체의 메모리 관리를 스프링이 대신 해줌.
	// Inject 자바8부터 지원, 그럼, 이전 자바7에서 @AoutoWired 로 객체를 만들었음
	
	@Test
	public void dbConnectionTest() {
		//데이터베이스 커넥션 테스트 설정은 root-context의 빈을 이용
			try {
				Connection  connection = dataSource.getConnection();
				logger.debug("데이터베이스 접속이 성공하였습니다. DB종류는 "+ connection.getMetaData().getDatabaseProductName());	
			} catch (SQLException e) {
				logger.debug("데이터베이스 접속이 실패 하였습니다.");
				//e.printStackTrace();
			}
	}
	@Test
	public void Junittest() {
		logger.debug("Junit테스트 시작입니다.");
	}
}
