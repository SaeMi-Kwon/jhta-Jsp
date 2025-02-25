--movie.sql
drop table comments;
drop table movie;
drop sequence movie_seq;
drop sequence comments_seq;

create table movie(
	mnum number(5) primary key,
	title varchar2(50),
	content varchar2(100),
	director varchar2(20)
);

create table comments(
	num number(5) primary key,  --댓글번호
	mnum number(5) references movie(mnum), --영화번호
	id varchar2(10),  --작성자
	comments varchar2(100)  --내용
);

create sequence movie_seq;
create sequence comments_seq;

insert into movie values(movie_seq.nextval,'캡틴아메리카','이감독','재밌는영화');
insert into movie values(movie_seq.nextval,'무서운영화','김감독','무서워요');
commit;

--mybatis04 (영화 평점 테이블)
create table mrating(
	num number(5) primary key, --평점번호
	mnum number(5) references movie(mnum),  --영화번호
	rating number(5,2),  --평점
	audience NUMBER  --관객수
);

create sequence mrating_seq;
insert into mrating values(mrating_seq.nextval,1,9.6,100);
insert into mrating values(mrating_seq.nextval,2,7.5,10);
commit;









