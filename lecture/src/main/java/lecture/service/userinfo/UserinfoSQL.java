package lecture.service.userinfo;

public class UserinfoSQL {
	public static final String USER_INSERT = "insert into userinfo(user_id,username,password) values(?,?,?)";
	public static final String USER_SELECT_BY_ID="select user_id,username,password from userinfo where user_id=?";
	public static final String USER_UPDATE="update userinfo set username=?,password=? where user_id=?";
	public static final String USER_SELECT_BY_ID_COUNT="select count(*) from userinfo where user_id=?";
	public static final String USER_LOGIN = "select password from userinfo where user_id=? and password=?";
}
