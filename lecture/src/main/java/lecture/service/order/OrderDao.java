package lecture.service.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import lecture.service.common.DataSource;
import lecture.service.lecture.Lecture;
import lecture.service.userinfo.Userinfo;

public class OrderDao {
	private DataSource dataSource;
	
	public OrderDao() throws Exception{
		dataSource = new DataSource();
	}
	//User의 주문 전체삭제
	public int deleteByUserId(String sUserId) throws Exception{
		Connection con= null;
		PreparedStatement pstmt = null;
		int rowCount=0;
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(OrderSQL.ORDER_DELETE_BY_USERID);
			pstmt.setString(1, sUserId);
			rowCount = pstmt.executeUpdate();
			con.commit();
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			if(con != null)
				con.close();
		}
		return rowCount;
	}
	//OrderNumber로 주문삭제
	public int deleteByOrderNo(int order_no) throws Exception{
		Connection con= null;
		PreparedStatement pstmt = null;
		int rowCount=0;
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(OrderSQL.ORDER_DELETE_BY_ORDER_NO);
			pstmt.setInt(1,order_no);
			rowCount = pstmt.executeUpdate();
			con.commit();
		}catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			throw e;
		}
		
		return rowCount;
	}
	//주문 생성
	public int insert(Order order) throws Exception{
		Connection con= null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt1 = con.prepareStatement(OrderSQL.ORDER_INSERT);
			pstmt1.setInt(1, order.getOrder_price());
			pstmt1.setString(2, order.getUser_id());
			pstmt1.executeUpdate();
			
			pstmt2 = con.prepareStatement(OrderSQL.ORDERITEM_INSERT);
			for(OrderItem orderItem : order.getOrderItems()) {
				pstmt2.setInt(1, orderItem.getLecture().getL_no());
			}
			con.commit();
		}catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			throw e;
		}finally {
			if(con != null)
				con.close();
		}
		
		return 0;
	}
	//주문 전체(특정사용자==user_id)
	public List<Order> findOrderByUserId(String sUserId) throws Exception{
		ArrayList<Order> orderList = new ArrayList<Order>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			pstmt=con.prepareStatement(OrderSQL.ORDER_SELECT_BY_USER_ID);
			pstmt.setString(1, sUserId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				orderList.add(new Order(rs.getInt("order_no"),rs.getInt("order_price"),rs.getString("user_id"),null));
			}
		}finally {
			if(con != null) {
				con.close();
			}
		}
		
		return orderList;
	}
	
	
	//주문+주문아이템 전체(특정사용자)
	public List<Order> findOrderWithOrderItemByUserId(String sUserId)throws Exception{
		List<Order> orderList = new ArrayList<Order>();
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		try {
			con = dataSource.getConnection();
			pstmt1 = con.prepareStatement(OrderSQL.ORDER_SELECT_BY_USER_ID);
			rs1 = pstmt1.executeQuery();
			while(rs1.next()) {
				orderList.add(new Order(rs1.getInt("order_no"),rs1.getInt("order_price"),rs1.getString("user_id"),null));
				
			}
			pstmt2 = con.prepareStatement(OrderSQL.ORDER_SELECT_WITH_ORDERITEM_BY_ORDER_NO);
			for (int i = 0; i < orderList.size(); i++) {
				Order tempOrder = orderList.get(i);
				pstmt2.setInt(1, tempOrder.getOrder_no());
				rs2 = pstmt2.executeQuery();
				Order orderWithOrderItem=null;
				if(rs2.next()){
					orderWithOrderItem = new Order(rs2.getInt("order_no"),rs2.getInt("order_price"),rs2.getString("user_id"),null);
					do {
						orderWithOrderItem.getOrderItems()
									.add(new OrderItem(rs2.getInt("oi_no"),
														rs2.getInt("order_no"),new Lecture(rs2.getInt("l_no"),
														rs2.getString("l_name"),rs2.getString("l_desc"),rs2.getInt("l_price"),
														rs2.getString("l_image"),rs2.getInt("C_no"))));
					}while(rs2.next());
				}
				orderList.set(i, orderWithOrderItem);
			}
		}finally {
			if(con !=null){
				con.close();
			}
		}
		
		
		return orderList;
	}
	
	
}
