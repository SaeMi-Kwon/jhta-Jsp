create table myboard(
	num number(5) primary key,
	writer varchar2(30),
	title varchar2(30),
	content varchar2(4000),
	regdate date
);

create sequence myboard_seq;
insert into myboard values(myboard_seq.nextval,'test','hello','비가 오네요..',sysdate);

commit;

--최근글 10개 조회 하기 (글번호로 내림차순 정렬 : rownum1-10)
select * from(
    select board.*,rownum rn from(
        select * from myboard order by num desc
    )board 
)where rn>=1 and rn<=10;