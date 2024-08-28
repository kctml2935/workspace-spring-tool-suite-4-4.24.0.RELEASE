--유저 설정
insert into userinfo(user_id,username,password) values('aaa','kim','aaaa');
insert into userinfo(user_id,username,password) values('bbb','chan','bbbb');
insert into userinfo(user_id,username,password) values('ccc','yeong','cccc');

--카테고리 설정
insert into lecture_category(C_no,C_name) values(lecture_category_C_no_SEQ.nextval,'프로그래밍');
insert into lecture_category(C_no,C_name) values(lecture_category_C_no_SEQ.nextval,'3D디자인');
insert into lecture_category(C_no,C_name) values(lecture_category_C_no_SEQ.nextval,'사진/영상');

--카테고리 1번의 강의들 강의번호 1~3번
insert into lecture values(lecture_L_no_SEQ.nextval,'JAVA','',0,'.png',1);
insert into lecture values(lecture_L_no_SEQ.nextval,'C++','',0,'.jpg',1);
insert into lecture values(lecture_L_no_SEQ.nextval,'Python','',0,'',1);

--카테고리 2번의 강의들 강의번호 4~7번
insert into lecture values(lecture_L_no_SEQ.nextval,'블렌더','',0,'',2);
insert into lecture values(lecture_L_no_SEQ.nextval,'zbrush','',0,'',2);
insert into lecture values(lecture_L_no_SEQ.nextval,'maya','',0,'',2);
insert into lecture values(lecture_L_no_SEQ.nextval,'3dsMax','',0,'',2);

--카테고리 3번의 강의들 강의번호 8~11번
insert into lecture values(lecture_L_no_SEQ.nextval,'에프터이펙트','',0,'',3);
insert into lecture values(lecture_L_no_SEQ.nextval,'포토샵','',0,'',3);
insert into lecture values(lecture_L_no_SEQ.nextval,'프리미어프로','',0,'',3);
insert into lecture values(lecture_L_no_SEQ.nextval,'다빈치리졸브','',0,'',3);

insert into cart(cart_no,cart_qty,user_id,L_no) values(cart_cart_no_SEQ.nextval,1,'aaa',1);
insert into cart(cart_no,cart_qty,user_id,L_no) values(cart_cart_no_SEQ.nextval,1,'aaa',4);
insert into cart(cart_no,cart_qty,user_id,L_no) values(cart_cart_no_SEQ.nextval,1,'aaa',11);

insert into cart(cart_no,cart_qty,user_id,L_no) values(cart_cart_no_SEQ.nextval,1,'bbb',2);
insert into cart(cart_no,cart_qty,user_id,L_no) values(cart_cart_no_SEQ.nextval,1,'bbb',6);
insert into cart(cart_no,cart_qty,user_id,L_no) values(cart_cart_no_SEQ.nextval,1,'bbb',7);
insert into cart(cart_no,cart_qty,user_id,L_no) values(cart_cart_no_SEQ.nextval,1,'bbb',10);

insert into cart(cart_no,cart_qty,user_id,L_no) values(cart_cart_no_SEQ.nextval,1,'ccc',3);
insert into cart(cart_no,cart_qty,user_id,L_no) values(cart_cart_no_SEQ.nextval,1,'ccc',5);
insert into cart(cart_no,cart_qty,user_id,L_no) values(cart_cart_no_SEQ.nextval,1,'ccc',8);
insert into cart(cart_no,cart_qty,user_id,L_no) values(cart_cart_no_SEQ.nextval,1,'ccc',9);

insert into orders(order_no,order_price,order_tot,user_id) values();