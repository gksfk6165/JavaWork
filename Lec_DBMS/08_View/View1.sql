CREATE OR REPLACE VIEW v_prof
AS
SELECT profno, name, email, hpage FROM t_professor;
SELECT * FROM v_prof;

SELECT tname from tab;
--다음을 조회하는 View 를 생성하는 SQL을 작성하세요
--| 학생이름 | 학생학과명 | 담당교수님 이름 |      
--View  이름:  v_stud_info 
--View 출력컬럼명은 [ sname | dname | pname ]

CREATE OR REPLACE VIEW v_stud_info(sname,dname,pname)
AS
SELECT profno, name, email, hpage FROM t_professor;
SELECT * FROM v_prof;


CREATE OR REPLACE VIEW v_prof(pfno,nm,em,hp)
AS
SELECT profno, name, email, hpage FROM t_professor;
SELECT * FROM v_prof;

--#8102) t_professor, t_department 테이블을 join 하여 교수번호와 교수이름과 소속학과 이름을 조회하는 view 를 생성하세요.  
--(이름: v_prof_dept)

CREATE OR REPLACE VIEW v_prof_dept
AS
    SELECT a.PROFNO,a.NAME ,b.DNAME 
    FROM t_professor a,T_DEPARTMENT b
    WHERE a.DEPTNO = b.DEPTNO ;

SELECT * FROM v_prof_dept;

SELECT deptno1, MAX(height) max_height, MAX(weight) max_weight
    FROM t_student
    GROUP BY deptno1;


SELECT 
    d.dname "학과명", 
    s.max_height "최대키", 
    s.max_weight "최대몸무게"
FROM 
    ( SELECT deptno1, MAX(height) max_height, MAX(weight) max_weight
    FROM t_student
    GROUP BY deptno1 ) s , 
    t_department d
WHERE 
    s.deptno1 = d.deptno;


--#8104) 연습
--t_student, t_department 테이블  학과별로 가장 키가 큰 학생들의 이름과 키, 
--학과이름을 인라인뷰 를 사용하여 다음과 같이 출력하세요
SELECT d.dname "학과명", a.max_height "최대키", s.name "학생이름", s.height "키"
FROM 
    (SELECT deptno1, MAX(height) max_height FROM t_student GROUP BY deptno1) a,
    t_student s, t_department d
WHERE 
    s.deptno1 = a.deptno1 AND s.height = a.max_height
    AND s.deptno1 =  d.deptno
;

-- #8105) t_student 테이블 : 학생의 키가 동일 학년의 평균 키보다 큰 학생들의 학년과 이름과 키, 해당 학년의 평균키를 출력하되, inline view 를 사용해서 아래와 같이 출력하세요. 단 학년 칼럼은 오름 차순으로 정렬.
SELECT 
    s.GRADE ,s.NAME ,s.HEIGHT ,a.height
FROM
    (SELECT grade,avg(height) AS height FROM T_STUDENT GROUP BY GRADE) a,
    t_student s
WHERE a.grade =s.GRADE AND s.HEIGHT > a.height
ORDER BY 1
;
    
