package lecture.service.cart;

public class CartSQL {
	public static final String CART_INSERT ="insert into cart(cart_no,cart_qty,user_id,l_no) values(cart_cart_no_SEQ.nextval,1,?,?)";
	public static final String CART_SELECT_BY_USERID = "select c.*,l.* from cart c join lecture l on c.l_no=l.l_no where user_id=?";
	public static final String CART_SELECT_BY_CART_NO = "select c.*,l.* from cart c join lecture l on c.l_no=l.l_no where cart_no=?";
	public static final String CART_COUNT_BY_USERID_LECTURE_NO = "select count(*) from cart where user_id=? and l_no=?";
	
	
	
}
