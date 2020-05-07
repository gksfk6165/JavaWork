----------------------------------------
-- Sub Query

-- #7101
--t_emp 테이블에서 
-- scott 보다 급여를 많이 받는 사람의 이름과 급여 출력

SELECT ename, sal FROM t_emp
WHERE sal > (SELECT sal FROM t_emp WHERE ename = 'SCOTT');

-- #7102) t_student 테이블에서 가장 키 큰 학생의 '이름'과 '키'를 출력


SELECT name,HEIGHT FROM T_STUDENT WHERE HEIGHT = (SELECT MAX(HEIGHT) FROM T_STUDENT);

-- #7103) t_student, t_department 테이블 사용하여 이윤나 학생과 1전공이 동일한 학생들의 이름과 1전공 이름을 출력하세요

SELECT DEPTNO1 FROM T_STUDENT WHERE name='이윤나';

SELECT s.NAME ,d.DNAME FROM T_STUDENT s,T_DEPARTMENT d
WHERE s.DEPTNO1 =d.DEPTNO AND s.DEPTNO1 = (SELECT DEPTNO1 FROM T_STUDENT WHERE name='이윤나');

--#7104) t_professor, t_department 테이블 : 입사일이 송도권 교수보다 나중에 입사한 사람의 이름과 입사일, 학과명을 출력하세요
SELECT * FROM T_DEPARTMENT ;

SELECT t.NAME ,t.HIREDATE ,d.DNAME 
FROM t_professor t,t_department d
WHERE  t.HIREDATE > (SELECT HIREDATE FROM T_PROFESSOR WHERE name='송도권') AND t.DEPTNO =d.DEPTNO ;

--#7105) t_student 테이블 : 1전공이 101번인 학과의 평균 몸무게보다 몸무게가 많은 학생들의 이름과 몸무게를 출력하세요

SELECT  name,WEIGHT FROM T_STUDENT
WHERE WEIGHT >(SELECT avg(WEIGHT) FROM T_STUDENT t WHERE DEPTNO1 =101);

--#7106) t_professor 테이블에서 심슨 교수와 같은 입사일에 입사한 교수 중, 조인형 교수보다 월급을 적게 받는 교수의 이름과 급여, 입사일을 출력하세요
SELECT name,pay,HIREDATE FROM T_PROFESSOR
WHERE HIREDATE = (SELECT HIREDATE FROM T_PROFESSOR WHERE name='심슨')
        AND pay< (SELECT pay FROM T_PROFESSOR WHERE name='조인형');
    
SELECT * FROM t_emp2;
SELECT * FROM T_DEPT2 ;
SELECT empno, name, deptno
FROM t_emp2 WHERE deptno >ALL (  SELECT dcode FROM t_dept2 WHERE area = '서울지사');

-- #7108) t_emp2 테이블 : 전체직원중 과장 직급의 최소연봉자보다 연봉이 높은 사람의 이름(name)과 직급(post), 연봉(pay)을 출력하세요.  단, 연봉 출력 형식은 천 단위 구분 기호와 원 표시를 하세요
SELECT name,post,to_char(pay,'99,999,999,999') FROM t_emp2 WHERE pay >= ANY (SELECT pay FROM t_emp2 WHERE post='과장');

-- #7109) t_student 테이블 : 전체학생중에서 체중이 4학년 학생들의 체중에서 가장 적게 나가는 학생보다 몸무게가 적은 학생의 이름과 학년과 몸무게를 출력하세요
SELECT name,GRADE ,WEIGHT FROM T_STUDENT WHERE WEIGHT < (SELECT min(WEIGHT) FROM T_STUDENT WHERE GRADE =4) ORDER BY WEIGHT desc;

