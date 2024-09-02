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
	private LectureCategory lectureCategory;
	
	public void selectWithLecture(String l_name,String l_desc,String l_image)throws Exception {
		this.l_name=l_name;
		this.l_desc=l_desc;
		this.l_image=l_image;
	}

}
