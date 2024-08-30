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
	private String user_id;
	
	@Default
	private List<OrderItem> orderItems=new ArrayList<OrderItem>();
}
