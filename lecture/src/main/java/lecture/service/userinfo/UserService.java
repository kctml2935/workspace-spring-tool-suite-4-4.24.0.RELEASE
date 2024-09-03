package lecture.service.userinfo;

public class UserService {
	private UserinfoDao userinfoDao;
	public UserService() throws Exception{
		userinfoDao = new UserinfoDao();
	}
	//회원가입
	public int create(Userinfo userinfo) throws Exception{
		if(userinfoDao.countByUserId(userinfo.getUser_id())>=1) {
			return -1;
		}else {
		int rowCount = userinfoDao.insert(userinfo);
		return rowCount;
		}
	}
	//아이디비번 맞으면 1 아니면 0
	public int login(String user_id,String password) throws Exception{
		int result = 0;
		if((userinfoDao.findByUserIdAndPassword(user_id, password))==1) {
			result = 1;
		}else {
			result = 0;
		}
		
		return result;
	}
	//아이디중복체크
	public boolean isDuplicated(String user_id) throws Exception{
		if(userinfoDao.countByUserId(user_id)>=1) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
}
