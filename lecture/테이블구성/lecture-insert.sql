--유저 설정
insert into userinfo(user_id,username,password) values('aaa','kim','aaaa');
insert into userinfo(user_id,username,password) values('bbb','chan','bbbb');
insert into userinfo(user_id,username,password) values('ccc','yeong','cccc');

--카테고리 설정
insert into lecture_category(C_no,C_name) values(lecture_category_C_no_SEQ.nextval,'프로그래밍');
insert into lecture_category(C_no,C_name) values(lecture_category_C_no_SEQ.nextval,'3D디자인');
insert into lecture_category(C_no,C_name) values(lecture_category_C_no_SEQ.nextval,'사진/영상');

--카테고리 1번의 강의들 강의번호 1~3번
insert into lecture values(lecture_l_no_SEQ.nextval,'JAVA','기타 상세 정보 등...',100000,'java.png',1);
insert into lecture values(lecture_l_no_SEQ.nextval,'C++','기타 상세 정보 등...',80000,'c++.png',1);
insert into lecture values(lecture_l_no_SEQ.nextval,'Python','기타 상세 정보 등...',60000,'python.png',1);

--카테고리 2번의 강의들 강의번호 4~7번
insert into lecture values(lecture_l_no_SEQ.nextval,'블렌더','기타 상세 정보 등...',120000,'blender.png',2);
insert into lecture values(lecture_l_no_SEQ.nextval,'zbrush','기타 상세 정보 등...',200000,'zbrush.jpeg',2);
insert into lecture values(lecture_l_no_SEQ.nextval,'maya','기타 상세 정보 등...',300000,'maya.png',2);
insert into lecture values(lecture_l_no_SEQ.nextval,'3dsMax','기타 상세 정보 등...',350000,'3DSMAX.jpg',2);

--카테고리 3번의 강의들 강의번호 8~11번
insert into lecture values(lecture_l_no_SEQ.nextval,'에프터이펙트','기타 상세 정보 등...',130000,'aftereffect.jpg',3);
insert into lecture values(lecture_l_no_SEQ.nextval,'포토샵','기타 상세 정보 등...',50000,'photoshop.jpg',3);
insert into lecture values(lecture_l_no_SEQ.nextval,'프리미어프로','기타 상세 정보 등...',70000,'premierpro.png',3);
insert into lecture values(lecture_l_no_SEQ.nextval,'다빈치리졸브','기타 상세 정보 등...',30000,'davinchi.png',3);

--aaa주문
insert into orders(order_no,order_price,user_id) values(orders_order_no_SEQ.nextval,270000,'aaa');
insert into order_item(oi_no,order_no,l_no) values(order_item_oi_no_SEQ.nextval,orders_order_no_SEQ.currval,1);
insert into order_item(oi_no,order_no,l_no) values(order_item_oi_no_SEQ.nextval,orders_order_no_SEQ.currval,4);
insert into order_item(oi_no,order_no,l_no) values(order_item_oi_no_SEQ.nextval,orders_order_no_SEQ.currval,11);

--bbb주문
insert into orders(order_no,order_price,user_id) values(orders_order_no_SEQ.nextval,800000,'bbb');
insert into order_item(oi_no,order_no,l_no) values(order_item_oi_no_SEQ.nextval,orders_order_no_SEQ.currval,2);
insert into order_item(oi_no,order_no,l_no) values(order_item_oi_no_SEQ.nextval,orders_order_no_SEQ.currval,6);
insert into order_item(oi_no,order_no,l_no) values(order_item_oi_no_SEQ.nextval,orders_order_no_SEQ.currval,7);
insert into order_item(oi_no,order_no,l_no) values(order_item_oi_no_SEQ.nextval,orders_order_no_SEQ.currval,10);

--ccc주문
insert into orders(order_no,order_price,user_id) values(orders_order_no_SEQ.nextval,440000,'ccc');
insert into order_item(oi_no,order_no,l_no) values(order_item_oi_no_SEQ.nextval,orders_order_no_SEQ.currval,3);
insert into order_item(oi_no,order_no,l_no) values(order_item_oi_no_SEQ.nextval,orders_order_no_SEQ.currval,5);
insert into order_item(oi_no,order_no,l_no) values(order_item_oi_no_SEQ.nextval,orders_order_no_SEQ.currval,8);
insert into order_item(oi_no,order_no,l_no) values(order_item_oi_no_SEQ.nextval,orders_order_no_SEQ.currval,9);

commit;