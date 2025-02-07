drop table board;

create table board(
	num number(5) primary key,	 --글번호
	writer varchar2(100),   --작성자
	title varchar2(100),	  --제목
	content varchar2(2000),	--내용
	ref number(5),	 --그룹번호
	lev number(5),	 --depth(게시글-답글-답글의 답글 인지...)
	step number(5)	 --출력순서
);


--정렬방식
select * from board 
order by ref desc,step asc;

--페이지처리 게시글 10개씩 조회(1~10)
select * from(
    select b.*,rownum rn from(
        select * from board
        order by ref desc,step asc
    )b
)where rn>=1 and rn<=10;

--페이지처리 게시글 10개씩 조회(11~20)
select * from(
    select b.*,rownum rn from(
        select * from board
        order by ref desc,step asc
    )b
)where rn>=11 and rn<=20;



insert into board values(1,'김씨','김','내용1',1,0,0);
insert into board values(3,'삼씨','삼','답글1-1',1,1,1);
insert into board values(4,'사씨','사','답글1-2',1,2,2);
insert into board values(2,'이씨','이','내용2',2,0,0);
insert into board values(5,'오씨','오','답글2-1',2,1,1);
insert into board values(6,'송씨','송','답글1-3',1,3,3);


--페이징처리 확인을 위한 쿼리 복제
insert into board values(7,'a','d','내용1',7,0,0);
insert into board values(8,'b','ss','내용1',8,0,0);
insert into board values(9,'c','dd','내용1',9,0,0);
insert into board values(10,'d','df','내용1',10,0,0);
insert into board values(11,'e','gg','내용1',11,0,0);
insert into board values(12,'f','ax','내용1',12,0,0);
insert into board values(13,'g','er','내용1',13,0,0);
insert into board values(14,'h','egh','내용1',14,0,0);


commit;