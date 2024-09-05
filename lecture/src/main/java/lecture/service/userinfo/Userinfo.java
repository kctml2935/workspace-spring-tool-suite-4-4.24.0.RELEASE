package lecture.service.userinfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Userinfo {
	private String user_id;
	private String username;
	private String password;

	public Userinfo(String user_id) {
		this.user_id=user_id;
	}
	
}
