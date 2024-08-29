package lecture.service.cart;


import lecture.service.lecture.Lecture;
import lecture.service.userinfo.Userinfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {
	private int cart_no;
	private int cart_qty;
	private Userinfo userinfo;
	private Lecture lecture;

}
