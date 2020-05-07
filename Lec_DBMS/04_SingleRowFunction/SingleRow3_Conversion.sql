

SELECT TO_CHAR(SYSDATE, 'YYYY') 연도4자리,TO_CHAR(SYSDATE, 'RRRR') 연도Y2K버그이후,TO_CHAR(SYSDATE, 'YY')  연도2자리,TO_CHAR(SYSDATE, 'YEAR') 연도영문 FROM dual;

SELECT 
    TO_CHAR(SYSDATE, 'MM') 월2자리,
    TO_CHAR(SYSDATE, 'MON') 월3자리,
    TO_CHAR(SYSDATE, 'MONTH')  월전체,
    TO_CHAR(SYSDATE, 'MON', 'NLS_DATE_LANGUAGE=ENGLISH') 월영문3자리,
    TO_CHAR(SYSDATE, 'MONTH', 'NLS_DATE_LANGUAGE=ENGLISH')  "월영문전체(대)",
    TO_CHAR(SYSDATE, 'month', 'NLS_DATE_LANGUAGE=ENGLISH')  "월영문전체(소)",
    TO_CHAR(SYSDATE, 'Month', 'NLS_DATE_LANGUAGE=ENGLISH')  "월영문전체(첫글자대)"
FROM dual;

SELECT 
    TO_CHAR(SYSDATE, 'HH24') 시24hr,
    TO_CHAR(SYSDATE, 'HH')  시12hr,
    TO_CHAR(SYSDATE, 'MI') 분,
    TO_CHAR(SYSDATE, 'SS') 초
FROM dual;

--#4301
SELECT TO_CHAR(SYSDATE, 'YY/mm/dd') AS "SYSDATE" ,TO_CHAR(SYSDATE, 'yyyy-mm-dd HH:MI:SS') AS 날짜 FROM dual;

-- 2017년10월25일 23시25분46초
SELECT TO_CHAR(SYSDATE, 'yyyy "년" mm "월" dd "일" hh24 "시" mi "분" ss "초"')FROM  dual;

SELECT
    TO_CHAR(1234, '99999')  "9하나당 1자리",
    TO_CHAR(1234, '099999')  "빈자리 0으로",
    TO_CHAR(1234, '$9999')  "$붙임",
    TO_CHAR(1234, '9999.99')  "소수점이하",
    TO_CHAR(1234, '99,999')  "천단위구분기호"
FROM dual;

--#4302)  t_student 테이블의 생일(birthday) 이 3월인 학생의 이름(name) 과 생일(birthday) 를  다음과 같은 형식으로 출력하세요 (TO_CHAR 사용)
SELECT name,TO_CHAR(BIRTHDAY,'yyyy-mm-dd') AS 생일 FROM T_STUDENT WHERE TO_CHAR(BIRTHDAY,'mm')=03 ;
--#4303)  t_professor 테이블에서 101번 학과 교수들의 이름(name), 연봉(pay) 를 출력하세요,단, 연봉은 (pay * 12) + bonus로 계산하고 천단위 구분기호로 표시하세요.(nvl() / to_char() 사용)
SELECT NAME ,pay,TO_CHAR(pay*12+nvl2(BONUS,BONUS ,0),'9,999') 연봉 FROM T_PROFESSOR ;
-- #4304) t_professor 테이블에서 2000년 이전에 입사한 교수명과 입사일,현재 연봉과 10% 인상 후 연봉을 아래와 같은 양식으로 출력하세요.연봉은 보너스(bonus)를 제외한 pay * 12 로 계산하고연봉과 인상후 연봉은 천단위 구분 기호를 추가하여 출력하세요
SELECT * FROM T_PROFESSOR ;
SELECT TO_DATE('2012-01-01', 'YYYY-MM-DD') TO_DATE FROM dual;
SELECT name,TO_char(HIREDATE,'yyyy-mm-dd') as 입사일,to_char(pay*12,'9,999') as 연봉,to_char(pay*1.1*12,'9,999') AS 인상후 FROM T_PROFESSOR WHERE TO_CHAR(HIREDATE,'yyyy')<2000; 





