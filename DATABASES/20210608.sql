--SQL쿼리 페이징을 구현해서 변수로 삼을 것을 정의
--PageVO의 멤버변수로 사용예정
SELECT TableB. * FROM
(
    SELECT ROWNUM AS RNUM, TA. *FROM
    (
        SELECT * FROM tbl_member
        WHERE  user_id LIKE '%admin%'       
        OR user_name LIKE '%사용자8%'
        ORDER BY reg_date DESC
    ) TA WHERE ROWNUM <= (0*5) + 5
)TableB WHERE TableB.RNUM > 0 * 5
-- 페이징쿼리에서 필요한 변수는 2개
-- 현재페이지의 변수  page*b == qeruStanrtNO 
-- 1페이지당 보여줄 개수의 변수 b == qeryPerGageNum
-- PageVO에서 필요한 추가변수: page
-- UI 하단의 페이지 선택번호 출력할 때 사용하는 변수(아래)
-- perPageNum 변수 받아서 StartPage, endPage 를 구해서
-- 하단의 페이지 선택 번호를 출력


