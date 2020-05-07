-- #7201) t_student 테이블을 조회하여 각 학년별로 최대 키를 가진 학생들의 학년과 이름과 키를 출력하세요,  학년 오름차순으로 출력

SELECT GRADE,name,HEIGHT FROM T_STUDENT WHERE (grade,HEIGHT) IN (SELECT grade,max(HEIGHT) FROM T_STUDENT GROUP BY grade);

-- #7202) t_professor , t_department 테이블 :  각 학과별로 입사일이 가장 오래된 교수의 교수번호와 이름, 학과명을 출력하세요.  단 학과이름 순으로 오름차순 정렬하세요

SELECT p.profno "교수번호", p.name "교수명",
        TO_CHAR(p.hiredate, 'YYYY-MM-DD') "입사일", d.dname "학과명"
FROM t_professor p, t_department d
WHERE p.deptno = d.deptno
AND (p.deptno, p.hiredate) 
    IN ( SELECT deptno, MIN(hiredate) FROM t_professor GROUP BY deptno)
ORDER BY d.dname ASC;

-- #7203)  t_emp2 테이블 : 직급별로 해당직급에서 최대 연봉을 받는 직원의 이름과 직급, 연봉을 출력하세요,  단, 연봉순으로 오름차순 정렬하세요
SELECT name,POST,pay
FROM t_emp2
WHERE (post,pay) IN (select post,Max(pay) FROM t_emp2 GROUP BY post) ORDER BY pay;

SELECT  * FROM T_emp2 ;

--#7204)  t_emp2, t_dept2 테이블 : 각 부서별 평균 연봉을 구하고 그 중에서 평균 연봉이 가장 적은 부서의 평균연봉보다 적게 받는 직원들의 부서명, 직원명, 연봉을 출력 하세요
SELECT b.DNAME ,a.NAME ,a.PAY 
FROM t_emp2 a, t_dept2 b
WHERE a.DEPTNO = b.DCODE 
    AND (a.PAY) < ALL (SELECT avg(PAY) FROM t_emp2 GROUP BY DEPTNO)
ORDER BY 3;  

--#7205) t_emp2 테이블 :  직원들 중에서 자신의 직급의 평균연봉과 같거나 많이 받는 사람들의 이름과 직급, 현재 연봉을 출력하세요.
--일단 자신이 직급을 구해야 한다.
--그 것을 Sub Query 에 전달해 주어야 한다
--Sub Query는 받은뒤 수행하여 결과를 다시 Main Query에 전달해야 한다

SELECT a.name,nvl2(a.post,a.POST,' '),pay 
FROM t_emp2 a
WHERE a.PAY >=(SELECT AVG(b.PAY)
FROM T_EMP2 b WHERE nvl2(a.POST,a.POST,' ') = nvl2(b.POST,b.POST,' ')) 
;

SELECT AVG(b.PAY)
FROM T_EMP2 b WHERE '과장' = b.POST ;

SELECT 
name "사원이름", (SELECT d.DNAME FROM t_dept2 d WHERE e.deptno = d.dcode ) "부서이름"
FROM t_emp2 e;


