DROP TABLE order_item CASCADE CONSTRAINTS;
DROP TABLE orders CASCADE CONSTRAINTS;
DROP TABLE cart CASCADE CONSTRAINTS;
DROP TABLE lecture CASCADE CONSTRAINTS;
DROP TABLE userinfo CASCADE CONSTRAINTS;

CREATE TABLE userinfo(
		user_id                       		VARCHAR2(100)		 NULL ,
		username                      		VARCHAR2(100)		 NULL ,
		password                      		VARCHAR2(100)		 NULL 
);


CREATE TABLE lecture(
		L_no                          		NUMBER(10)		 NULL ,
		L_name                        		VARCHAR2(100)		 NULL ,
		L_desc                        		VARCHAR2(200)		 NULL ,
		L_price                       		NUMBER(50)		 NULL ,
		L_image                       		VARCHAR2(100)		 NULL 
);

DROP SEQUENCE lecture_L_no_SEQ;

CREATE SEQUENCE lecture_L_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


CREATE TABLE cart(
		cart_no                       		NUMBER(10)		 NULL ,
		cart_qty                      		NUMBER(10)		 NULL ,
		user_id                       		VARCHAR2(100)		 NULL ,
		L_no                          		NUMBER(10)		 NULL 
);

DROP SEQUENCE cart_cart_no_SEQ;

CREATE SEQUENCE cart_cart_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


CREATE TABLE orders(
		order_no                      		NUMBER(10)		 NULL ,
		order_price                   		NUMBER(10)		 NULL ,
		order_tot                     		NUMBER(10)		 NULL ,
		user_id                       		VARCHAR2(100)		 NULL 
);

DROP SEQUENCE orders_order_no_SEQ;

CREATE SEQUENCE orders_order_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


CREATE TABLE order_item(
		oi_no                         		NUMBER(10)		 NULL ,
		oi_qty                        		NUMBER(10)		 NULL ,
		L_no                          		NUMBER(10)		 NULL ,
		order_no                      		NUMBER(10)		 NULL 
);



ALTER TABLE userinfo ADD CONSTRAINT IDX_userinfo_PK PRIMARY KEY (user_id);

ALTER TABLE lecture ADD CONSTRAINT IDX_lecture_PK PRIMARY KEY (L_no);

ALTER TABLE cart ADD CONSTRAINT IDX_cart_PK PRIMARY KEY (cart_no);
ALTER TABLE cart ADD CONSTRAINT IDX_cart_FK0 FOREIGN KEY (user_id) REFERENCES userinfo (user_id);
ALTER TABLE cart ADD CONSTRAINT IDX_cart_FK1 FOREIGN KEY (L_no) REFERENCES lecture (L_no);

ALTER TABLE orders ADD CONSTRAINT IDX_orders_PK PRIMARY KEY (order_no);
ALTER TABLE orders ADD CONSTRAINT IDX_orders_FK0 FOREIGN KEY (user_id) REFERENCES userinfo (user_id);

ALTER TABLE order_item ADD CONSTRAINT IDX_order_item_FK0 FOREIGN KEY (L_no) REFERENCES lecture (L_no);
ALTER TABLE order_item ADD CONSTRAINT IDX_order_item_FK1 FOREIGN KEY (order_no) REFERENCES orders (order_no);

