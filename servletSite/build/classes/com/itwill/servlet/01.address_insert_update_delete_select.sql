--insert
insert into address values(address_no_seq.nextval,'KIM','123-4568','경기도 성남시');
insert into address values(address_no_seq.nextval,'PARK','123-4568','경기도 구리시');
insert into address values(address_no_seq.nextval,'CHOI','123-4568','경기도 포천시');
insert into address values(address_no_seq.nextval,'GOO','123-4568','경기도 이천시');
insert into address values(address_no_seq.nextval,'JUNG','123-4568','경기도 군포시');
insert into address values(address_no_seq.nextval,'LEE','123-4568','경기도 안양시');
insert into address values(address_no_seq.nextval,'JOO','123-4568','경기도 안산시');
insert into address values(address_no_seq.nextval,'YANG','123-4568','경기도 인천시');
insert into address values(address_no_seq.nextval,'INN','123-4568','경기도 시흥시');


--insert into address values(address_no_seq.nextval ,'김경호','123-4568','경기도 성남시');
commit;

--update(pk update)
update address set name='김경호',phone='899-9999',address='서울시 강남구' where no = 1;
commit;

--delete (pk delete)
delete address where no=1;


--select (pk select)
select no,name,phone,address from address where no = 3;
--select(all select)
select no,name,phone,address from address; 