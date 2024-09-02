package lecture.service.order;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lecture.service.userinfo.Userinfo;

class OrderDaoTest {
	OrderDao orderDao;
	
	@Test
	@BeforeEach
	void setUp() throws Exception {
		orderDao = new OrderDao();
	}
/*	전체 테스트 성공
	@Test
	void testDeleteByUserId() throws Exception {
		int Count = orderDao.deleteByUserId("aaa");
		assertEquals(3, Count);
	}

	@Test
	
	 void testDeleteByOrderNo() throws Exception { 
		int Count = orderDao.deleteByOrderNo(3); 
		assertEquals(4, Count); 
		System.out.println(Count);
		}
	

	@Test
	void testInsert() throws Exception {
		Order order = Order.builder().order_no(4).order_price(2222).userinfo(Userinfo.builder().user_id("bbb").build()).build();
		int insertRowCount = orderDao.insert(order);
		assertEquals(1, insertRowCount);
	}

	@Test
	void testFindOrderByUserId() throws Exception{
		List<Order> orderList = orderDao.findOrderByUserId("aaa");
		System.out.println(orderList);
		for (Order order : orderList) {
			assertEquals("aaa", order.getUserinfo().getUser_id());
		}
	}
	
	@Test
	void testFindOrderWithOrderItemByUserId() throws Exception {
		List<Order> orderList = orderDao.findOrderWithOrderItemByUserId("bbb");
		System.out.println(orderList);
		for (Order order : orderList) {
			assertEquals(2,order.getOrder_no());
			assertEquals(800000,order.getOrder_price());
			assertNotNull(order.getUserinfo());
			assertEquals("bbb", order.getUserinfo().getUser_id());
			assertNotNull(order.getOrderItems());
			assertEquals(4, order.getOrderItems().size());
		}
		
	}*/
	@Test
	void testfindOrderWithOrderItemByOrderNo()throws Exception{
		List<Order> orders = orderDao.findOrderWithOrderItemByOrderNo(1);

        assertNotNull(orders);
        System.out.println(orders);
        assertEquals(1, orders.size());
	}

}
