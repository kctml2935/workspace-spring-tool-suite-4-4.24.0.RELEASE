package lecture.service.lecture;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LectureCategory {
	private int C_no;
	private String C_name;
	
}
