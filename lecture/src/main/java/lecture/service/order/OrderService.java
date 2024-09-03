package lecture.service.order;

import java.util.ArrayList;
import java.util.List;

import lecture.service.lecture.Lecture;
import lecture.service.lecture.LectureDao;
import lecture.service.userinfo.Userinfo;
import lecture.service.userinfo.UserinfoDao;

public class OrderService {
	private OrderDao orderDao;
	private LectureDao lectureDao;
	private UserinfoDao userinfoDao;
	
	public OrderService() throws Exception{
		orderDao = new OrderDao();
		lectureDao = new LectureDao();
		userinfoDao = new UserinfoDao();
	}
	public int deleteByOrderNo(int order_no)throws Exception{
		return orderDao.deleteByOrderNo(order_no);
	}
	public int delete(String sUserId)throws Exception{
		return orderDao.deleteByUserId(sUserId);
	}
	public List<Order> orderList(String sUser) throws Exception{
		return orderDao.findOrderByUserId(sUser);
	}
	public List<Order> orderitemList(String sUserId) throws Exception{
		return orderDao.findOrderWithOrderItemByUserId(sUserId);
	}
	public List<Order> orderitemListwithNo(int order_no) throws Exception{
		return orderDao.findOrderWithOrderItemByOrderNo(order_no);
		
	}
	
	
	public int create(String sUserId,int l_no) throws Exception{
		ArrayList<OrderItem> orderitemList = new ArrayList<OrderItem>();
		int o_tot_price=0;
		Userinfo user = userinfoDao.findByUserId(sUserId);
		Lecture lecture = lectureDao.findByNo(l_no);
		OrderItem orderItem = new OrderItem(0,lecture);
		orderitemList.add(orderItem);
		o_tot_price += orderitemList.get(0).getLecture().getL_price();
		Order newOrder = new Order(0,o_tot_price,user);
		return orderDao.insert(newOrder);
	}

}
