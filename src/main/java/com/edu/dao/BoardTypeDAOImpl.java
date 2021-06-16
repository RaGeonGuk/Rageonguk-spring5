package com.edu.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.edu.vo.BoardTypeVO;

/**
 * 이 클래스는 게시판생성관리 쿼리의 인터페이스르 구현메서드가 있는 클래스입니다.
 * @author 라건국
 * 20210616
 */
@Repository
public class BoardTypeDAOImpl implements IF_BoardTypeDAO {
	//sqlSession 템플릿 의존성(를)을 주입
	@Inject//자바 8부터 신규로 나온 에노테이션입니다.
	private SqlSession sqlSession;

	@Override
	public void deleteBoardType(String board_type) throws Exception {
		// TODO sqlSession템플릿(를)을 이용해서 매퍼쿼리를 실행
		sqlSession.delete("boardTypeMapper.deleteBoardType", board_type);
	}

	@Override
	public void updateBoardType(BoardTypeVO boardTypeVO) throws Exception {
		// TODO 아래 주석과 동일
		sqlSession.update("boardTypeMapper.updateBoardType", boardTypeVO);
	}

	@Override
	public BoardTypeVO readBoardType(String board_type) throws Exception {
		// TODO 아래 주석과 동일
		return sqlSession.selectOne("boardTypeMapper.readBoardType", board_type);
	}

	@Override
	public void insertBoardType(BoardTypeVO boardTypeVO) throws Exception {
		// TODO 아래 주석과 동일
		sqlSession.insert("boardTypeMapper.insertBoardType", boardTypeVO);
	}

	@Override
	public List<BoardTypeVO> selectBoardType() throws Exception {
		// TODO 매퍼쿼리를 실행 sqlSession 템플릿(를)을 이용해서
		return sqlSession.selectList("boardTypeMapper.selectBoardType");
	}
}