SELECT  
    d.DEPTNO ,d.DNAME 
FROM T_DEPARTMENT d;

SELECT 
   s.STUDNO ,s.NAME ,s.DEPTNO1 ,
   d.DEPTNO ,d.DNAME 
FROM T_STUDENT s,T_DEPARTMENT d;

--ANSI
SELECT 
   s.STUDNO ,s.NAME ,s.DEPTNO1 ,
   d.DEPTNO ,d.DNAME 
FROM T_STUDENT s CROSS JOIN T_DEPARTMENT d;

-- 등가조인 이퀄조인
SELECT s.name 학생이름, s.deptno1 "학과번호", d.dname "학과이름"
FROM t_student s, t_department d
WHERE s.deptno1 = d.deptno;

SELECT s.name 학생이름, s.deptno1 "학과번호", d.dname "학과이름"
FROM t_student s JOIN t_department d
ON s.deptno1 = d.deptno;

-- 제2전공은?  deptno2
SELECT s.name "학새이름", s.deptno2 "제2학과", d.dname "제2학과이름"
FROM t_student s, t_department d
WHERE s.deptno2 = d.deptno;


-- #6102) t_student 테이블, t_professor 테이블 을 join하여 ‘학생이름’, ‘지도교수 번호’, ‘지도교수이름’ 을 출력하세요

SELECT 
    ts.NAME ,ts.PROFNO ,tf.NAME 
FROM T_STUDENT ts,T_PROFESSOR tf
WHERE ts.PROFNO =tf.PROFNO 
;

SELECT 
    ts.NAME ,ts.PROFNO ,tf.NAME 
FROM T_STUDENT ts JOIN T_PROFESSOR tf
ON ts.PROFNO =tf.PROFNO 
;

--#6103) t_student, t_department, t_professor 테이블 을 join 하여  학생의 이름, 학과이름, 지도교수 이름  을 출력하세요

SELECT 
    ts.NAME,td.DNAME,tf.NAME 
FROM T_STUDENT ts,t_department td,T_PROFESSOR tf
WHERE ts.DEPTNO1=td.DEPTNO AND ts.PROFNO =tf.PROFNO 
;

SELECT 
    ts.NAME,td.DNAME,tf.NAME 
FROM T_STUDENT ts JOIN t_department td ON ts.DEPTNO1=td.DEPTNO 
                  JOIN T_PROFESSOR tf ON ts.PROFNO=tf.PROFNO
;

-- #6104) t_emp2 직원 테이블과 t_post 직급 테이블을 조회하여 사원의 이름과 직급, 현재연봉, 해당직급의 연봉의 하한금액(s_pay)과 상한금액(e_pay)을 출력하세요
SELECT * FROM t_emp2;
SELECT * FROM t_post;
SELECT
    te.NAME ,te.PAY ,tp.S_PAY ,tp.E_PAY 
FROM t_emp2 te,T_POST tp
WHERE te.POST =tp.POST 
;

SELECT
    te.NAME ,te.PAY ,tp.S_PAY ,tp.E_PAY 
FROM t_emp2 te JOIN T_POST tp on te.POST=tp.POST ;


-- #6105 t_student - t_professor 테이블 join 하여 제1전공(deptno1) 이 101번인 학생들의 학생이름과 지도교수 이름을 출력하세요
SELECT s.name "학생이름", p.name "교수이름"
FROM t_student s, t_professor p
WHERE 
    s.profno = p.profno 
    AND s.deptno1 = 101;

SELECT s.name "학생이름", p.name "교수이름"
FROM t_student s JOIN t_professor p
ON
    s.profno = p.profno 
    AND s.deptno1 = 101;

-- 비등가 조인
--#6201) t_customer 테이블, t_gift 테이블을 join 하여  고객의 마일리지 포인트별로 받을수 있는 상품을 조회하여  고객의 '이름(c_name)'과 포인트(c_point) 상품명(g_name)을 출력하세요 ** BETWEEN ~ AND ~ 사용

SELECT * FROM T_CUSTOMER ;
SELECT * FROM T_GIFT ;

SELECT 
    tc.C_NAME ,tc.C_POINT ,tg.G_NAME
FROM T_CUSTOMER tc,T_GIFT tg
WHERE tc.C_POINT BETWEEN tg.G_START AND tg.G_END;

SELECT 
    tc.C_NAME ,tc.C_POINT ,tg.G_NAME
FROM T_CUSTOMER tc JOIN T_GIFT tg
ON tc.C_POINT BETWEEN tg.G_START AND tg.G_END;

-- #6202) 앞 예제에서 조회한 상품의 이름(g_name)과  필요수량이 몇개인지 조회하세요** 그룹함수 적용!

SELECT 
    tg.G_NAME,COUNT(tg.G_NAME ) 
FROM T_CUSTOMER tc,T_GIFT tg
WHERE tc.C_POINT BETWEEN tg.G_START AND tg.G_END
GROUP BY tg.G_NAME
;
-- ANSI
SELECT g.g_name "상품명", count(*) "상품수량"
FROM t_customer c JOIN t_gift g
    ON c.c_point BETWEEN g.g_start AND g.g_end
GROUP BY g.g_name;

-- #6203)  t_student 테이블과 t_exam01 시험성적 테이블, t_credit 학점 테이블을 조회하여  학생들의 이름과 점수와 학점을 출력하세요

SELECT * FROM T_EXAM01 ;
SELECT * FROM T_CREDIT ;

SELECT 
    ts.NAME ,te.TOTAL ,tc.GRADE
FROM T_STUDENT ts ,T_EXAM01 te,T_CREDIT tc
WHERE ts.STUDNO = te.STUDNO AND 
        te.TOTAL BETWEEN tc.MIN_POINT AND tc.MAX_POINT;

SELECT 
    ts.NAME ,te.TOTAL ,tc.GRADE
FROM T_STUDENT ts JOIN T_EXAM01 te ON ts.STUDNO = te.STUDNO
                  JOIN T_CREDIT tc ON te.TOTAL BETWEEN tc.MIN_POINT AND tc.MAX_POINT;
              
-- #6204) t_customer 와 t_gift 테이블 join : 자기 포인트(c_point) 보다 낮은 포인트의 상품 중 한가지를 선택할수 있다고 할때 '산악용자전거'를 선택할 수 있는 고객명(c_name)과 포인트(c_point), 상품명(g_name)을 출력하세요
SELECT 
    tc.C_NAME ,tc.C_POINT ,tg.G_NAME
FROM T_CUSTOMER tc,T_GIFT tg
WHERE tc.C_POINT >= tg.G_START AND tg.G_NAME ='산악용자전거';

--#6205) t_emp2, t_post 테이블 사용하여
--사원들의 이름(name)과 나이, 현재직급(post),  ‘예상직급’을 출력하세요. 
--‘예상직급’은 나이로 계산하며 해당 나이가 받아야 하는 직급을 의미합니다. 
--나이는 오늘(SYSDATE)을 기준으로 하되 소수점 이하는 절삭하여 계산하세요
--(t_emp2 의 직급(post) 은 null 허용함에 주의)
--** 나이계산은 어떻게?  :  (현재연도 - 생년월일연도) + 1,SYSDATE, TO_CHAR() 사용
SELECT * FROM t_emp2;
SELECT * FROM t_post;

SELECT 
    te.NAME AS "이름",
    round(to_char(SYSDATE,'yyyy')-to_char(te.BIRTHDAY ,'yyyy')) AS "나이" ,
    nvl2(te.POST,te.POST,' ') AS "현재직급",
    tp.POST AS "예상직급"
FROM t_emp2 te,T_POST tp
WHERE round(to_char(SYSDATE,'yyyy')-to_char(te.BIRTHDAY ,'yyyy')) BETWEEN tp.S_AGE AND tp.E_AGE

SELECT 
    s.name "학생이름", 
    p.name "교수이름"
FROM 
    t_student s RIGHT OUTER JOIN t_professor p
    ON s.profno = p.profno;

SELECT 
    s.name "학생이름", 
    p.name "교수이름"
FROM 
    t_student s FULL OUTER JOIN t_professor p
    ON s.profno = p.profno;

------------------------------------------------
-- self join

-- #6209) 
-- t_dept2 테이블에서 
-- 부서명 과 그 부서의 상위부서명을 출력하세요

SELECT d1.dname "부서명", d2.dname "상위부서명"
FROM t_dept2 d1, t_dept2 d2
WHERE d1.pdept = d2.dcode;

-- ANSI
SELECT d1.dname "부서명", d2.dname "상위부서명"
FROM t_dept2 d1 JOIN t_dept2 d2
    ON d1.pdept = d2.dcode;

--#6210) 
--t_professor 테이블 : 교수번호, 교수이름, 입사일, 그리고 자신보다 입사일 빠른 사람의 인원수를 출력하세요, 단 자신보다 입사일이 빠른 사람수를 오름차순으로 출력하세요
--hint: left outer 사용 
-- / 그룹함수 사용
SELECT * FROM t_professor;

SELECT 
    t1.PROFNO ,t1.NAME ,t1.HIREDATE,count(t2.HIREDATE)
FROM  T_PROFESSOR t1 LEFT OUTER JOIN T_PROFESSOR t2
ON t2.HIREDATE < t1.HIREDATE
GROUP BY t1.PROFNO ,t1.NAME ,t1.HIREDATE
ORDER BY 4;


