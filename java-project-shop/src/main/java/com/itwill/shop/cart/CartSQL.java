package com.itwill.shop.cart;
public class CartSQL {
	
	/*
	<< guard1사용자가 카트에 1번제품 3개담기 >>
	  
	--guard1 멤버한사람의  카트에 제품번호 존재여부
	select count(*)  as p_count from cart where userid='guard1' and p_no=1;
	
	--guard1 멤버한사람의  카트에 제품번호 존재안하면
	--insert
	into cart(cart_no,cart_qty,p_no,userid) values(cart_cart_no_SEQ.nextval,3,1,'guard1');
	
	--guard1 멤버한사람의  카트에 제품번호 존재하면
	--로그인한멤버(guard1)의 제품1개의 수량증가(변경)
	update cart set cart_qty=cart_qty+3 where userid='guard' and p_no=1;
	
	
	--로그인한멤버(guard1)의 카트리스트(cart + product)
	select * from cart c join product p on c.p_no=p.p_no where userid='guard1' ;
	
	
	---로그인한멤버(guard1)의 카트한개삭제(pk삭제)
	delete from cart where cart_no=1;
	
	

	
	--카트아이템한개의 수량증가(PK조건)
	update cart set cart_qty=10 where cart_no=3;
	 */
	public static final String CART_INSERT = "insert into cart(cart_no,cart_qty,p_no,userid) values(cart_cart_no_SEQ.nextval,?,?,?)";
	public static final String CART_SELECT_BY_USERID = "select c.*,p.* from cart c join product p on c.p_no=p.p_no where userid=?";
	public static final String CART_SELECT_BY_CART_NO = "select * from cart c join product p on c.p_no=p.p_no where cart_no=?";
	public static final String CART_COUNT_BY_USERID_PRODUCT_NO = "select count(*) as p_count from cart where userId=? and p_no=?";
	public static final String CART_DELETE_BY_CART_NO = "delete from cart where cart_no=?";
	public static final String CART_DELETE_BY_USERID = "delete from cart where userid=?";
	public static final String CART_UPDATE_BY_CART_NO = "update cart set cart_qty=? where cart_no=?";
	public static final String CART_UPDATE_BY_PRODUCT_NO_USERID = "update cart set cart_qty=cart_qty+? where userid=? and p_no=?";
}