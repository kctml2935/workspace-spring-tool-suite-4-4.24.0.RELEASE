package lecture.service.order;

public class OrderSQL {
	public final static String ORDER_DELETE_BY_USERID = "delete from orders where user_id=?";
	public final static String ORDER_DELETE_BY_ORDER_NO = "delete from orders where order_no=?";
	public final static String ORDER_INSERT ="insert into orders(order_no,order_price,user_id) values(orders_order_no_SEQ.nextval,?,?)";
	public final static String ORDERITEM_INSERT ="insert into order_item(oi_no,order_no,l_no) values(order_item_oi_no_SEQ.nextval,orders_order_no_SEQ.currval,?)";
	public final static String ORDER_SELECT_BY_USER_ID="select * from orders where user_id=?";
	public final static String ORDER_SELECT_WITH_ORDERITEM_BY_ORDER_NO = "select * from orders o join order_item oi on o.order_no=oi.order_no join lecture l on oi.l_no=l.l_no where o.order_no=?";
	public final static String ORDER_SELECT_WITH_ORDERITEM_BY_USER_ID="select * from orders o join order_item oi on o.order_no=oi.order_no join lecture on oi.l_no=l.l_no where o.user_id=?";
	public final static String ORDER_SELECT_WITH_LECTURE_BY_USER_ID = "select l.l_name,l.l_desc,l.l_image from orders o join order_item oi on o.order_no=oi.order_no join lecture l on oi.l_no=l.l_no where o.user_id='?'";
}
