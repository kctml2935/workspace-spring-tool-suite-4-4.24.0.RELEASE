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
	private int oi_qty;
	private Order order;
	private Lecture lecture;

}
