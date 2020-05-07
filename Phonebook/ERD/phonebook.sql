
/* Drop Tables */
DROP TABLE phonebook CASCADE CONSTRAINTS;
/* Create Tables */
CREATE TABLE phonebook
(
	pb_uid number NOT NULL,
	pb_name varchar2(40) NOT NULL,
	pb_phonenum varchar2(40),
	pb_memo clob,
	pb_regdate date DEFAULT SYSDATE,
	PRIMARY KEY (pb_uid)
);

DROP SEQUENCE phonebook_seq;
CREATE SEQUENCE phonebook_seq;

SELECT * FROM PHONEBOOK ORDER BY PB_UID desc;
SELECT * FROM TEST_MEMBER;
