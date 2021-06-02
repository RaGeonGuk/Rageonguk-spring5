package kr.or.test;
/**
 * 이 클래스는 자바앱에서 개발자 예외를 처리하는방법 실습하는 클래스입ㄴ다.
 * @author 라건국
 *
 */
public class ExceptionTest {

	public static void main(String[] args) {
		// 외부 클래스 형 변수 값을 저장해서 출력하는 프로그램(아래)
		MemberVO memberVO = new MemberVO();
		// 동일 패키지안의 클래스는 import 없이 사용 가능합니다.
		memberVO.setName("홍길동");
		memberVO.setAge(10);
		memberVO.setPhoneNum("000-0000-0000");
		System.out.println("한꺼번에 출력하고 싶을때 toString()매서드를 만듭니다.");
		System.out.println(memberVO.toString());
		
		//배열변수 선언
		String[] stringArray = {"10","2a","100"};
		int indexValue = 0;
		for(int cnt=0;cnt<=3;cnt++) {
			/*
			 * 개발자가 예외처리하는 기본형식
			 * try {구현프로그램에서 에러가 발생하면}
			 * catch(에러발생 기존 정의된 상황) {(필수)에러발생시 처리할 구현내용}
			 * finally {(선택사항)에러가 발생하든, 안하든 무조건 실행}
			 */
			try {
			indexValue = Integer.parseInt(stringArray[cnt]);
			} catch(NumberFormatException ex) { //Exception 대신에 선별적으로 예외사항을 잡습니다.
				
				System.out.println(cnt + "번째 숫자형태가 올바르지 않습니다. 확인해주세요!");
				System.out.println("에러내용은: " + ex.toString());
			} catch(Exception ex ) {
				System.out.println(ex.toString());
				System.out.println("배열의 크기가 올바르지 않습니다.");
			} finally {
				System.out.println(cnt + "번째 프로그램이 실행 되었습니다.");
			}
			
		}
		System.out.println("프로그램이 정상 종료 되었습니다.");
	}

}
