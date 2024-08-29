--유저 설정
insert into userinfo(user_id,username,password) values('aaa','kim','aaaa');
insert into userinfo(user_id,username,password) values('bbb','chan','bbbb');
insert into userinfo(user_id,username,password) values('ccc','yeong','cccc');

--카테고리 설정
insert into lecture_category(C_no,C_name) values(lecture_category_C_no_SEQ.nextval,'프로그래밍');
insert into lecture_category(C_no,C_name) values(lecture_category_C_no_SEQ.nextval,'3D디자인');
insert into lecture_category(C_no,C_name) values(lecture_category_C_no_SEQ.nextval,'사진/영상');

--카테고리 1번의 강의들 강의번호 1~3번
insert into lecture values(lecture_l_no_SEQ.nextval,'JAVA','',100000,'.png',1);
insert into lecture values(lecture_l_no_SEQ.nextval,'C++','',80000,'.jpg',1);
insert into lecture values(lecture_l_no_SEQ.nextval,'Python','',60000,'',1);

--카테고리 2번의 강의들 강의번호 4~7번
insert into lecture values(lecture_l_no_SEQ.nextval,'블렌더','desc',120000,'image',2);
insert into lecture values(lecture_l_no_SEQ.nextval,'zbrush','',200000,'',2);
insert into lecture values(lecture_l_no_SEQ.nextval,'maya','',300000,'',2);
insert into lecture values(lecture_l_no_SEQ.nextval,'3dsMax','',350000,'',2);

--카테고리 3번의 강의들 강의번호 8~11번
insert into lecture values(lecture_l_no_SEQ.nextval,'에프터이펙트','desc',130000,'image',3);
insert into lecture values(lecture_l_no_SEQ.nextval,'포토샵','',50000,'',3);
insert into lecture values(lecture_l_no_SEQ.nextval,'프리미어프로','',70000,'',3);
insert into lecture values(lecture_l_no_SEQ.nextval,'다빈치리졸브','',30000,'',3);

insert into cart(cart_no,cart_qty,user_id,l_no) values(cart_cart_no_SEQ.nextval,1,'aaa',1);
insert into cart(cart_no,cart_qty,user_id,l_no) values(cart_cart_no_SEQ.nextval,1,'aaa',4);
insert into cart(cart_no,cart_qty,user_id,l_no) values(cart_cart_no_SEQ.nextval,1,'aaa',11);

insert into cart(cart_no,cart_qty,user_id,l_no) values(cart_cart_no_SEQ.nextval,1,'bbb',2);
insert into cart(cart_no,cart_qty,user_id,l_no) values(cart_cart_no_SEQ.nextval,1,'bbb',6);
insert into cart(cart_no,cart_qty,user_id,l_no) values(cart_cart_no_SEQ.nextval,1,'bbb',7);
insert into cart(cart_no,cart_qty,user_id,l_no) values(cart_cart_no_SEQ.nextval,1,'bbb',10);

insert into cart(cart_no,cart_qty,user_id,l_no) values(cart_cart_no_SEQ.nextval,1,'ccc',3);
insert into cart(cart_no,cart_qty,user_id,l_no) values(cart_cart_no_SEQ.nextval,1,'ccc',5);
insert into cart(cart_no,cart_qty,user_id,l_no) values(cart_cart_no_SEQ.nextval,1,'ccc',8);
insert into cart(cart_no,cart_qty,user_id,l_no) values(cart_cart_no_SEQ.nextval,1,'ccc',9);

--aaa주문
insert into orders(order_no,order_price,user_id) values(orders_order_no_SEQ.nextval,270000,'aaa');
insert into order_item(oi_no,oi_qty,order_no,l_no) values(order_item_oi_no_SEQ.nextval,1,orders_order_no_SEQ.currval,1);
insert into order_item(oi_no,oi_qty,order_no,l_no) values(order_item_oi_no_SEQ.nextval,1,orders_order_no_SEQ.currval,4);
insert into order_item(oi_no,oi_qty,order_no,l_no) values(order_item_oi_no_SEQ.nextval,1,orders_order_no_SEQ.currval,11);

--bbb주문
insert into orders(order_no,order_price,user_id) values(orders_order_no_SEQ.nextval,800000,'bbb');
insert into order_item(oi_no,oi_qty,order_no,l_no) values(order_item_oi_no_SEQ.nextval,1,orders_order_no_SEQ.currval,2);
insert into order_item(oi_no,oi_qty,order_no,l_no) values(order_item_oi_no_SEQ.nextval,1,orders_order_no_SEQ.currval,6);
insert into order_item(oi_no,oi_qty,order_no,l_no) values(order_item_oi_no_SEQ.nextval,1,orders_order_no_SEQ.currval,7);
insert into order_item(oi_no,oi_qty,order_no,l_no) values(order_item_oi_no_SEQ.nextval,1,orders_order_no_SEQ.currval,10);

--ccc주문
insert into orders(order_no,order_price,user_id) values(orders_order_no_SEQ.nextval,440000,'ccc');
insert into order_item(oi_no,oi_qty,order_no,l_no) values(order_item_oi_no_SEQ.nextval,1,orders_order_no_SEQ.currval,3);
insert into order_item(oi_no,oi_qty,order_no,l_no) values(order_item_oi_no_SEQ.nextval,1,orders_order_no_SEQ.currval,5);
insert into order_item(oi_no,oi_qty,order_no,l_no) values(order_item_oi_no_SEQ.nextval,1,orders_order_no_SEQ.currval,8);
insert into order_item(oi_no,oi_qty,order_no,l_no) values(order_item_oi_no_SEQ.nextval,1,orders_order_no_SEQ.currval,9);

commit;