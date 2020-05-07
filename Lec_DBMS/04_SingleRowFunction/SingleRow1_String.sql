-- INITCAP() 함수

-- #4101
SELECT INITCAP('pretty girl') FROM dual; 

-- #4102 학생 테이블(t_student)  에서 제1전공(deptno1) 이 201번인 학생들의 id를 첫 글자만 대문자로 출력 / initcap() 사용
SELECT id,INITCAP(id) FROM T_STUDENT WHERE DEPTNO1 = 201;
-- #4103) t_student 테이블 : 1전공(deptno1) 이 201번인 학생들의 id 를 이름과 함께 소문자, 대문자로 출력 / upper(), lower() 사용
SELECT name,UPPER(id),LOWER(id) FROM T_STUDENT WHERE DEPTNO1 =201;
-- #4104) t_student 테이블 : ID가 9글자 이상인 학생들의 이름과 ID 와 글자수 출력 / length() 사용
SELECT name,id ,LENGTH(id) FROM T_STUDENT WHERE LENGTH(id)>=9; 
-- #4105) t_student 테이블 : 1전공이 201번인 학생들의 이름과 이름의 글자수, 이름의 바이트 수를 출력하세요 / LENGTH(), LENGTHB() 사용 
SELECT name,LENGTH(name) 길이,lengthb(name) 바이트 FROM T_STUDENT WHERE DEPTNO1 =201; 
-- #4106) t_professor 테이블 :  101번 학과 (deptno) 의 교수들의 이름(name)과 직급(position)을 하나의 컬럼으로 출력하세요.  컬럼명은 "교수님명단" / concat() 사용 
SELECT CONCAT(name,POSITION) AS 교수님명단 FROM T_PROFESSOR WHERE DEPTNO =101;

SELECT SUBSTR('ABCDE', 2, 3) FROM dual;

-- #4107) t_student 테이블 : jumin 칼럼을 사용해서 1전공(deptno1)이 101번인 학생의 이름과 생년월일 출력 / substr() 사용
SELECT name, SUBSTR(jumin, 1, 6) 생년월일 FROM t_student WHERE deptno1 = 101;
-- #4108) t_student 테이블 : jumin 칼럼을 사용해서  태어난 달이 8월인 사람의 이름과 생년월일을 출력하세요 / substr() 사용
SELECT name,SUBSTR(jumin, 1, 6) 생년월일 FROM t_student WHERE substr(jumin, 3, 2) = '08';

--instr()
SELECT instr('a*b*c*','*',1,2) FROM dual;
SELECT instr('a*b*c*','*',1,2) FROM dual;
SELECT instr('a*b*c*','*',3,2) FROM dual;
SELECT instr('a*b*c*','*',-4,1) FROM dual;  --음의 인덱스 경우 검색방향도 음의방향
SELECT instr('a*b*c*','*',-4,2) FROM dual; 

-- #4110) t_student 테이블 : tel 칼럼을 사용하여 101번 학과(deptno1) 의 학생의 이름과 전화번호, ‘)’ 가 나오는 위치 출력  / instr() 사용
SELECT NAME,TEL, INSTR(TEL ,')',1,1) FROM T_STUDENT WHERE DEPTNO1 =101;
--#4111) t_student 테이블 : 1전공이 101 인 학생의 이름과 전화번호, 지역번호를 출력하세요. 지역번호는 숫자만!  / substr(), instr() 사용
SELECT NAME,SUBSTR(TEL ,1,INSTR(TEL ,')',1,1)-1) FROM T_STUDENT WHERE DEPTNO1 =101;

SELECT LTRIM('수퍼수퍼수가맨','수퍼') ltrim FROM dual;
SELECT LTRIM('수퍼수퍼수가맨','수') ltrim FROM dual;
SELECT LTRIM('   수퍼수퍼수가맨',' ') ltrim FROM dual;
SELECT TRIM('   수퍼수퍼수가맨  ') trim FROM dual;
-- #4117) p_dept2 테이블에서 부서명(dname) 을 출력하되 오른쪽 끝에 ‘부’ 라는 글자는 제거하고 출력하세요.
SELECT DNAME,RTRIM(DNAME ,'부') FROM  T_DEPT2 ;
SELECT REPLACE('슈퍼맨 슈퍼걸', '슈퍼', '파워') REPLACE예제 FROM dual;
-- #4118) t_student 테이블에서 102번 학과(deptno1) 의 학생들의 이름을 출력하되 성 부분은 ‘#’  으로 표시되게 출력하세요 / replace() , substr()사용 
SELECT name,REPLACE(name,SUBSTR(NAME,1,1),'#') AS fisrtName FROM T_STUDENT WHERE DEPTNO1 =102;
-- #4119) t_student 테이블에서 101번 학과(deptno1) 의 학생들의 이름을 출력하되 가운데 글자만 ‘#’  으로 표시되게 출력하세요 / replace() , substr()사용 
SELECT name,REPLACE(name,SUBSTR(NAME,2,1),'#') AS fisrtName FROM T_STUDENT WHERE DEPTNO1 =101;
-- #4120) t_student 테이블에서 1전공(deptno1) 이 101번인 학생들의 이름과 주민등록번호를 출력하되 주민등록번호의 뒤 7자리는 ‘*’ 로 표시되게 출력 
SELECT name,JUMIN,REPLACE(JUMIN ,SUBSTR(JUMIN,7,7),'*******') FROM T_STUDENT WHERE DEPTNO1 =101;
-- #4121) Student 테이블에서 다음 과 같이 1전공(deptno1) 이 102번인 학생들의 이름(name) 과 전화번호(tel), 전화번호에서 국번 부분만 ‘#’ 처리하여 출력하세요.  단 모든 국번은 3자리로 간주합니다.replace() / substr() / instr() 사용
SELECT name,tel,REPLACE(tel,SUBSTR(tel,INSTR(tel,')')+1,3),'###') FROM T_STUDENT WHERE DEPTNO1 =102;












