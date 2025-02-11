--bitem.sql

drop table itemfiles;
drop table bitem;
drop sequence item_seq;
drop sequence itemfiles_seq;

--제품테이블
create table bitem(
	inum number(5) primary key,  --제품번호
	itemname varchar2(20),  --제품명
	descrip varchar2(2000),  --제품설명
	price number(5)  --가격

);

--첨부파일 테이블
create table itemfiles(
	fnum number(5) primary key,  --파일번호
	inum number(5) references bitem(inum),
	orgfilename varchar2(150),  --원본파일명
	savefilename varchar2(150),  --저장된 파일명
	filesize number  --파일크기
);


create sequence item_seq;
create sequence itemfiles_seq;