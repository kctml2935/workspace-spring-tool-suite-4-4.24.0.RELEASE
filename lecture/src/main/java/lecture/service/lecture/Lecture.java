package lecture.service.lecture;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lecture {
	private int l_no;
	private String l_name;
	private String l_desc;
	private int l_price;
	private String l_image;
	private int C_no;//카테고리 넘버

}
