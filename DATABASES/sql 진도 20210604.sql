-- DDL문 (create; alter;), DCL문 (commit; rollback;)
-- DML문 (Data Manufature Language) insert, update, delete
-- insert문: 테이블에 새로운 레코드(row)를 추가
CREATE TABLE dept02 AS SELECT * FROM dept WHERE 1=0;
-- 위 커리는 데이터 테이블을 복제하는 명령
-- 위처럼 쿼리를 실행하면 dept테이블과 구조와 내용이 똑같은 테이블이 만들어진다
-- where 조건이 붙으면, 구조는 같으나 내용은 빈 테이블이 생성
INSERT INTO dept02(
--필드명
deptno, dname, loc 
)VALUES(
10, '개발부서', '천안'
--바인딩값
);
COMMIT; --데이터베이스 쿼리 직접 입력한결과는 반드시 커밋을 해줘야지만 실제 저장이됩니다.커밋을 하지 않으면, 여기만 보이고, 다른곳에선 안보임
-- 
SELECT * FROM dept02 ORDER BY deptno;
-- DELETE는 레코드 1줄 자체를 지우는 명령
DELETE FROM dept02; --이렇게 사용하면 안됨. 모든 레코드 삭제됨 주의요
DELETE FROM dept02 WHERE deptno >= 0; -- 모두 삭제하는 명령이더라도 where를 포함해야함










