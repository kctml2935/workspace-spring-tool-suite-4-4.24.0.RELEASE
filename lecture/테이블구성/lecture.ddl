DROP TABLE order_item CASCADE CONSTRAINTS;
DROP TABLE orders CASCADE CONSTRAINTS;
DROP TABLE lecture CASCADE CONSTRAINTS;
DROP TABLE lecture_category CASCADE CONSTRAINTS;
DROP TABLE userinfo CASCADE CONSTRAINTS;

CREATE TABLE userinfo(
		user_id                       		VARCHAR2(100)		 NULL ,
		username                      		VARCHAR2(100)		 NULL ,
		password                      		VARCHAR2(100)		 NULL 
);


CREATE TABLE lecture_category(
		C_no                          		NUMBER(10)		 NULL ,
		C_name                        		VARCHAR2(100)		 NULL 
);

DROP SEQUENCE lecture_category_C_no_SEQ;

CREATE SEQUENCE lecture_category_C_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TABLE lecture(
		l_no                          		NUMBER(10)		 NULL ,
		l_name                        		VARCHAR2(100)		 NULL ,
		l_desc                        		VARCHAR2(200)		 NULL ,
		l_price                       		NUMBER(10)		 NULL ,
		l_image                       		VARCHAR2(100)		 NULL ,
		C_no                          		NUMBER(10)		 NULL 
);

DROP SEQUENCE lecture_l_no_SEQ;

CREATE SEQUENCE lecture_l_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TABLE orders(
		order_no                      		NUMBER(10)		 NULL ,
		order_price                   		NUMBER(10)		 NULL ,
		user_id                       		VARCHAR2(100)		 NULL 
);

DROP SEQUENCE orders_order_no_SEQ;

CREATE SEQUENCE orders_order_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


CREATE TABLE order_item(
		oi_no                         		NUMBER(10)		 NULL ,
		order_no                      		NUMBER(10)		 NULL ,
		l_no                          		NUMBER(10)		 NULL 
);
DROP SEQUENCE order_item_oi_no_SEQ;

CREATE SEQUENCE order_item_oi_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


ALTER TABLE userinfo ADD CONSTRAINT IDX_userinfo_PK PRIMARY KEY (user_id);

ALTER TABLE lecture_category ADD CONSTRAINT IDX_lecture_category_PK PRIMARY KEY (C_no);

ALTER TABLE lecture ADD CONSTRAINT IDX_lecture_PK PRIMARY KEY (l_no);
ALTER TABLE lecture ADD CONSTRAINT IDX_lecture_FK0 FOREIGN KEY (C_no) REFERENCES lecture_category (C_no);

ALTER TABLE orders ADD CONSTRAINT IDX_orders_PK PRIMARY KEY (order_no);
ALTER TABLE orders ADD CONSTRAINT IDX_orders_FK0 FOREIGN KEY (user_id) REFERENCES userinfo (user_id);

ALTER TABLE order_item ADD CONSTRAINT IDX_order_item_FK0 FOREIGN KEY (l_no) REFERENCES lecture (l_no);
ALTER TABLE order_item ADD CONSTRAINT IDX_order_item_FK1 FOREIGN KEY (order_no) REFERENCES orders (order_no);

