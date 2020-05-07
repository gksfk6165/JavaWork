SELECT * FROM T_PROFESSOR ;
SELECT count(*),COUNT(hpage) FROM T_PROFESSOR ;  --그룹함수에서 널은 계산에서 제외~
SELECT count(BONUS),sum(BONUS),avg(BONUS) FROM T_PROFESSOR ; 
SELECT max(HIREDATE ),min(HIREDATE ) FROM T_emp;

-- 널 허용 컬럼의 그룹함수 저용시
-- nvl nvl2 사용해야함

SELECT DEPTNO ,round(avg(nvl(BONUS ,0)),1)FROM T_PROFESSOR GROUP BY DEPTNO ;

-- #5101) t_professor 테이블 : 학과별(deptno) 그리고 직급별(position)로 교수들의 평균 급여를 계산하여 출력하세요
SELECT DEPTNO ,POSITION,avg(pay) 
FROM T_PROFESSOR
GROUP BY DEPTNO ,POSITION
ORDER BY DEPTNO ASC,POSITION ASC
;


 -- 부서별 평균급여를 출력하되, 평균급여가 450 보다 많은 학과만 출력
SELECT deptno, avg(pay) 평균급여
FROM t_professor
GROUP BY deptno
HAVING AVG(pay) >300 
;

--SELECT [컬럼명 또는 표현식] 
--FROM [테이블명, 뷰명]  
--WHERE [조건절]  
--GROUP BY [그룹할 컬럼] 
--HAVING [그룹함수 조건절]   
--ORDER BY [정렬열] [ASC/DESC];

--#5102) t_emp 테이블: 매니저별(MGR)로 관리하는 직원들의 ‘매니저’, ‘직원수’와 ‘급여총액’과 ‘급여평균’과 ‘교통비 (COMM) 평균’ 지급액 을 출력하세요.  단 사장님은 (job = president)제외 
SELECT 
    mgr AS 매니저,
    count(job) AS 직원수,
    sum(sal) AS 급여총액,
    avg(sal) AS 급여평균,
    avg(nvl2(comm,comm,0)) AS 교통비평균
FROM t_emp
WHERE job !='PRESIDENT'
GROUP BY mgr
;

--#5103) t_professor 테이블 :  직위가 정교수 혹은 조교수 인 분들 중에서 ‘과별(deptno)’로  과번호, 소속교수 총수, 근속일 평균, 급여평균, 보너스 평균을 출력해보세요
SELECT 
    DEPTNO ,
    COUNT(position) AS 총인원,
    avg(ROUND(sysdate-HIREDATE,5)) AS 근속일평균,
    avg(pay+nvl2(BONUS,BONUS,0)) AS 급여평균,
    avg(nvl2(BONUS ,BONUS ,0)) AS 보너스평균
FROM T_PROFESSOR 
WHERE POSITION='정교수' or POSITION='조교수' 
GROUP BY DEPTNO
;

--#5104) t_student 테이블 : 학과별(deptno1) 로,  학과번호, 최대몸무게 - 최소몸무게 차이 값을 출력해보세요
SELECT 
    DEPTNO1 AS 학과,
    MAX(WEIGHT )-min(WEIGHT )
FROM T_STUDENT 
GROUP BY DEPTNO1 
;

--#5105) 그 차이가 30 이상인것만 출력하려면?
SELECT 
    DEPTNO1 AS 학과,
    MAX(WEIGHT )-min(WEIGHT )
FROM T_STUDENT 
GROUP BY DEPTNO1 
HAVING  MAX(WEIGHT )-min(WEIGHT)>=30
;









