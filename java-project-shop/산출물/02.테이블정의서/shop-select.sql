/**********************userinfo insert************************/
insert into userinfo(userid,password,name,email) values('guard1','1111','김경호1','guard1@korea.com');
insert into userinfo(userid,password,name,email) values('guard2','2222','김경호2','guard2@korea.com');
insert into userinfo(userid,password,name,email) values('guard3','3333','김경호3','guard3@korea.com');

/**********************product insert************************/

insert into product values(product_p_no_SEQ.nextval, '비글', 550000, 'bigle.png','기타 상세 정보 등...', 0);
insert into product values(product_p_no_SEQ.nextval, '달마시안', 500000, 'dalma.jpg','기타 상세 정보 등...', 0);
insert into product values(product_p_no_SEQ.nextval, '퍼그', 400000, 'pug.jpg','기타 상세 정보 등...', 0);
insert into product values(product_p_no_SEQ.nextval, '페키니즈', 450000, 'pekiniz.png','기타 상세 정보 등...', 0);
insert into product values(product_p_no_SEQ.nextval, '포메라니안', 800000, 'pomeranian.jpg','기타 상세 정보 등...', 0);
insert into product values(product_p_no_SEQ.nextval, '샤페이', 700000, 'shaipei.jpg','기타 상세 정보 등...', 0);
insert into product values(product_p_no_SEQ.nextval, '닥스훈트', 800000, 'dachshund.jpg','기타 상세 정보 등...', 0);
insert into product values(product_p_no_SEQ.nextval, '사모예드', 800000, 'samoyed.jpg','기타 상세 정보 등...', 0);


/**********************cart insert************************/
--guard1님이 1번1개,2번2개,3번3개 제품담기
insert into cart(cart_no,userId,p_no,cart_qty) values(cart_cart_no_seq.nextval,'guard1',1,1); 
insert into cart(cart_no,userId,p_no,cart_qty) values(cart_cart_no_seq.nextval,'guard1',2,2); 
insert into cart(cart_no,userId,p_no,cart_qty) values(cart_cart_no_seq.nextval,'guard1',3,3); 
--guard2님이 1번3개,2번2개,3번1개 제품담기
insert into cart(cart_no,userId,p_no,cart_qty) values(cart_cart_no_seq.nextval,'guard2',1,3); 
insert into cart(cart_no,userId,p_no,cart_qty) values(cart_cart_no_seq.nextval,'guard2',2,2); 
insert into cart(cart_no,userId,p_no,cart_qty) values(cart_cart_no_seq.nextval,'guard2',3,1); 


--guard3님이 1번1개,2번1개,3번1개,4번1개,5번1개,6번1개,7번1개,8번1개 제품담기
insert into cart(cart_no,userId,p_no,cart_qty) values(cart_cart_no_seq.nextval,'guard3',1,1); 
insert into cart(cart_no,userId,p_no,cart_qty) values(cart_cart_no_seq.nextval,'guard3',2,1); 
insert into cart(cart_no,userId,p_no,cart_qty) values(cart_cart_no_seq.nextval,'guard3',3,1); 
insert into cart(cart_no,userId,p_no,cart_qty) values(cart_cart_no_seq.nextval,'guard3',4,1); 
insert into cart(cart_no,userId,p_no,cart_qty) values(cart_cart_no_seq.nextval,'guard3',5,1); 
insert into cart(cart_no,userId,p_no,cart_qty) values(cart_cart_no_seq.nextval,'guard3',6,1); 
insert into cart(cart_no,userId,p_no,cart_qty) values(cart_cart_no_seq.nextval,'guard3',7,1); 
insert into cart(cart_no,userId,p_no,cart_qty) values(cart_cart_no_seq.nextval,'guard3',8,1); 

/**********************orders insert************************/
--guard1
--제품상세보기에서주문

--카트에서주문(guard1님이 1번1개,2번2개,3번3개 제품담기)
insert into orders(o_no,o_desc,o_date,o_price,userid) values(orders_o_no_SEQ.nextval,'비글외1종',sysdate,950000,'guard1');
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,1);
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,2,orders_o_no_SEQ.currval,2);
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,3,orders_o_no_SEQ.currval,3);

--delete from cart where userid='guard1';

--guard2
--제품상세보기에서주문

--카트에서주문(guard2님이 1번3개,2번2개,3번1개 제품담기)
insert into orders(o_no,o_desc,o_date,o_price,userid) values(orders_o_no_SEQ.nextval,'비글외1종',sysdate,950000,'guard1');
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,3,orders_o_no_SEQ.currval,1);
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,2,orders_o_no_SEQ.currval,2);
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,3);
--delete from cart where userid='guard2';


--guard3
--제품상세보기에서주문

--카트에서주문(guard3님이 1번1개,2번1개,3번1개,4번1개,5번1개,6번1개,7번1개,8번1개 제품담기)
insert into orders(o_no,o_desc,o_date,o_price,userid) values(orders_o_no_SEQ.nextval,'비글외7종',sysdate,7200000,'guard3');
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,1);
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,2);
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,3);
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,4);
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,5);
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,6);
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,7);
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,8);
--delete from cart where userid='guard3';

commit;