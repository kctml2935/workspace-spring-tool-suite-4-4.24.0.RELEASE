package lecture.service.order;

import lecture.service.lecture.Lecture;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
	private int oi_no;
	private Order order;
	private Lecture lecture;
	
	public OrderItem(int oi_no, Lecture lecture) throws Exception{
		this.oi_no=oi_no;
		this.lecture=lecture;
	}
}

