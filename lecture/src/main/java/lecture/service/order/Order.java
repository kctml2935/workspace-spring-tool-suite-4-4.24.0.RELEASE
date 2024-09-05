package lecture.service.order;

import java.util.ArrayList;
import java.util.List;

import lecture.service.userinfo.Userinfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
	private int order_no;
	private int order_price;
	private Userinfo userinfo;
	
	@Default
	private List<OrderItem> orderItems=new ArrayList<OrderItem>();
	
	public Order(int order_no) {
		this.order_no=order_no;
	}
	public Order(int order_no,int order_price,Userinfo userinfo) {
		this.order_no=order_no;
		this.order_price=order_price;
		this.userinfo=userinfo; 
	}
	public List<OrderItem> getOrderItems() {
        if (orderItems == null) {
            orderItems = new ArrayList<>();
        }
        return orderItems;
    }
	public List<OrderItem> getOrderItemList(){
		return orderItems != null ? orderItems : new ArrayList<>();
	}
}
