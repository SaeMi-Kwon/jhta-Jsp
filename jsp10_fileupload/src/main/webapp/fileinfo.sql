--fileinfo.sql

drop table fileinfo;

create table fileinfo(
	filenum number(5) primary key,
	writer varchar2(20),
	title varchar2(50),
	content varchar2(100),
	orgfilename varchar2(150),  --원본파일명
	savefilename varchar2(150),  --저장된파일명
	filesize number	  --파일크기
);

drop sequence fileinfo_seq;

create sequence fileinfo_seq;