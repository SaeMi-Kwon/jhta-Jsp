create table myusers(
	id varchar2(20) primary key,
	pwd varchar2(20),
	email varchar2(20),
	regdate date
);

insert into myusers values('hello','1234','hello@test.com',sysdate);
insert into myusers values('test','0000','test@test.com',sysdate);
commit;