--DESC: Description 테이블구조를 설명
DESC dept;
--select: 테이블내용 조회, where 조회조건, as(Alias)별칭으로 필드명이 길때
--concat오라클내장함수는 레포트 작성시 
SELECT 
concat(deptno,' 번') as "부서번호"
, dname as "부서명" 
, concat(loc, ' 시') as "위치"
FROM dept 
WHERE loc = 'NEW YORK';
--DUAL 가상 테이블 이름, 테이블이 없는 내용을 select 할때
--SELECT concat('라','건국') from dual;
SELECT 3+5 as "3더하기8은" from dual;
-- 레코드(row): 컬럼(필드field)들로 구성
SELECT concat(count(*),'명') as"연봉이 2000인 직원" FROM emp WHERE sal > 2000;
-- 큰 따옴표(필드명), 작은 따옴표(문자 처리, 비교, 결합)
SELECT * FROM emp WHERE ename != 'KING';
-- '!' 느낌표는 ~이 아닌사람을 구하는 것
SELECT * FROM emp WHERE hiredate >= '1982/01/01';

-- OR는 +(합집합), AND는 X(교집합)
SELECT * FROM emp
WHERE deptno = 10 OR job ='MANAGER';

-- BETWEEN
SELECT * FROM emp WHERE sal
NOT BETWEEN 2000 AND 3000;

SELECT * FROM emp WHERE hiredate
BETWEEN '1980/01/01' AND '1980/12/31';
SELECT * FROM emp WHERE comm NOT IN (300,500,1400);

-- LIKE 조회, 와일드카드=% 조회
-- 키워드에 괄호가 있으면 함수 upper(), concat(), count()
SELECT * FROM emp WHERE ename LIKE upper('k%');
SELECT * FROM emp WHERE ename LIKE '%N';

-- null(널) 이 중요한 이유: null 값이 있으면 검색 안됨 (null은 0이나 공백이 아님)
-- 그러면, null 값이 필드에 있을때, 검색 방법은?
SELECT * FROM emp WHERE comm IS NULL;
-- NVL(Null VlaLue) null(널) 값을 (대치)처리하는 함수
-- 사원중에 커미션을 0원 받은 사람은?
SELECT * FROM emp WHERE comm = 0;

-- 사원중에 커미션을 0원받은 사람과 null 받은 사람은?
-- 아래 E는 emp 테이블의 알리아스 별칭으로 E.* 모든것은 emp.*과 같은내용
SELECT nvl(comm,0), E.* FROM emp E WHERE NVL(comm,0) = 0;
-- 오라클은 표준 쿼리X ANSI 쿼리가 표준입니다.

-- NVL2 (필드명, 널이아닐때 100, 널일때 0), NVL(필드명, 널일때 0)
널이 아니면 0을 넣고 널이면 100을 넣어라
SELECT nvl2(comm,100,0), E.* FROM emp E WHERE NVL(comm,0) = 0;
-- DECODE는 NVL2와 비슷하지만 직관적이라 더 사용함 DECODE(comm,null,일때 '0',아닐때 'comm')
SELECT DECODE(comm,null,0,comm), nvl2(comm,100,0), E.* FROM emp E WHERE NVL(comm,0) = 0;

-- 정렬 sort = 순서 order by 필드명 오름차순[초기값]ascending | 내림차순desending
-- 연봉 기준으로 정렬 해주세요.
SELECT emp.sal, emp.* FROM emp ORDER BY emp.sal DESC; --내림차순
SELECT E.sal, E.* FROM emp E ORDER BY E.sal ASC; --올림차순

-- 서브쿼리? (select 쿼라기 중복되어 있는...)가 필요함 
-- 연봉 1등을 구해주세요.
SELECT ROWNUM, E.* FROM (--테이블명
SELECT * FROM emp ORDER BY sal DESC --내림차순
) E WHERE ROWNUM =1 ;
-- 위 서브쿼리 문장을 해석 할 때는 내부 안쪽부터 해석합니다.
-- 위 정렬에서 1등만 구할 limit는 mysql(마리아DB)의 명령어. 오라클 X
-- mysql(마리아DB)에 있는 AI(AutoIncrement) 자동증가값 명령 오라클X 

-- 중복레코드 (row)를 제거하는 명령어 distinct
SELECT * FROM emp;
--부서번호 구하는 방법
SELECT deptno as "부서번호" FROM emp; -- 사원수대로 부서번호가 출력
-- 중복되는 부서번호 지우는 방법
SELECT DISTINCT deptno as "부서번호" FROM emp;

-- 문자열을 연결할때 CONCAT 함수 외에 || 파이프라인 2개를 겹처서 구현
SELECT ename || 'is a'|| job AS "문자열 연결" FROM emp;

--여기까지 SELECT 마무리 Read
-- 이후에는 CRUD 중에 Isert, Update, Delete 3개의 쿼리로 끝

-- 함수용어 ABS (Absolute 절대값), Floor(바닥함수 1.5=1)-Ceil (천정함수 1.5=2)
-- ROUND(반올림), TRUNC(Truncate 버리는 함수), Mod(나머지 구하는 함수)
-- UPPER(소문자->대문자), Lower(대문자->소문자),length(길이구하는 함수)
-- INSTR (문자 위치를 구하는 함수), SUBSTR(매개변수로 입력한 숫자 위치만큼 문자열 추출)
-- LPAD(LeftPadding왼쪽여백),  RPAD(오른쪽여백), 레포트 프로그램에서 출력조정시 사용
-- TRIM(왼쪽 or 오른쪽 문자열을 잘라내는 함수)
-- 날짜 SYSDATE,systimestamp 로 오라클전용 함수로서 게시물 입력 시간, 회원등록시간, 
SELECT to_char (systimestamp,'yyyy-mm-dd hh24:mi:ss:ff') from dual;
-- 위 to char(날짜를 문자열로 변환) 형 변환 함수라고 합니다.
SELECT sysdate + 1 FROM dual;
SELECT sysdate - 1 FROM dual;
-- 6개월간 회원정보 수정이 없는 회원에게 메일 발송 같은 서비스를 처리 하는 용도(아래)
SELECT * FROM
TBL_MEMBER
WHERE UPDATE_DATE < ADD_MONTHS(SYSDATE,-6);






