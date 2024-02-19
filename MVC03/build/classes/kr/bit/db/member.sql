--member(회원) table
--auto_increment는 자동증가
create table member(
num int primary key auto_increment, 
id varchar(20) not null,
pass varchar(20) not null,
name varchar(30) not null,
age int not null,
email varchar(30) not null,
phone varchar(30) not null,
unique key(id)
);
--SQL(CRUD), JDBC
--검색
select * from member;

--INSERT(저장)
insert into member(id, pass, name, age, email, phone)
values('admin','admin','관리자',40,'bit@naver.com','010-1234-5678');

--update(수정)
update member set age=45, phone='010-1234-1234' where id='admin';

--delete(삭제)
delete from member where id='admin';

--table삭제
drop table member;
