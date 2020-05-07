SELECT * FROM T_PROFESSOR ;
SELECT NAME ,PAY ,BONUS , PAY +BONUS FROM T_PROFESSOR ;
SELECT SUM(pay),sum(BONUS) FROM T_PROFESSOR ;
SELECT NAME ,PAY ,BONUS  FROM T_PROFESSOR ;
SELECT NAME ,PAY ,BONUS ,PAY+NVL(BONUS,0) AS 총지급액 FROM T_PROFESSOR ;
-- #4201) Professor 테이블 : 101번 학과 교수들의 이름(name), 급여(pay), 보너스(bonus ), 연봉(pay) 출력하기.  연봉은 pay * 12 + bonus 로 계산,  bonus 가 없는 교수는 0 으로 계산
SELECT NAME ,pay,BONUS,pay*12+Nvl(BONUS ,0) AS 연봉 FROM T_PROFESSOR ;
-- #4202) professor 테이블 :  101번 학과 교수의 이름과 pay, bonus, 연봉 출력,  연봉은 pay*12 + bonus 로 계산, bonus 가 없으면 급여를 0 으로 처리 (nvl2 사용)
SELECT NAME ,pay,NVL2(BONUS,BONUS ,0),pay*12+Nvl(BONUS ,0) AS 연봉 FROM T_PROFESSOR WHERE DEPTNO =101;

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

