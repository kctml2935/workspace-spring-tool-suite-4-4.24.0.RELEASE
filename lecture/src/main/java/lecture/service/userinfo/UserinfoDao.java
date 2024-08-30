package lecture.service.userinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lecture.service.common.DataSource;

public class UserinfoDao {
	private DataSource dataSource;
	public UserinfoDao() throws Exception{
		dataSource=new DataSource();
	}
	//create(insert):user테이블에 새로운사용자생성
	public int insert(Userinfo userinfo) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(UserinfoSQL.USER_INSERT);
		pstmt.setString(1, userinfo.getUser_id());
		pstmt.setString(2, userinfo.getUsername());
		pstmt.setString(3, userinfo.getPassword());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return rowCount;
	}
	
	//update: 기존의 사용자정보를 수정
	public int update(Userinfo userinfo) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(UserinfoSQL.USER_UPDATE);
		pstmt.setString(1, userinfo.getUsername());
		pstmt.setString(2, userinfo.getPassword());
		pstmt.setString(3, userinfo.getUser_id());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return rowCount;
	}
	
	//사용자아이디에해당하는 정보를 데이타베이스에서 1개 찾아서 User 객체로반환
	public Userinfo findByUserId(String user_id) throws Exception{
		Userinfo user=null;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(UserinfoSQL.USER_SELECT_BY_ID);
		pstmt.setString(1, user_id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			user = new Userinfo(
					rs.getString("user_id"),
					rs.getString("username"),
					rs.getString("password")
					);
		}
		return user;
	}
	//인자로 전달되는 아이디를 가지는 사용자가 존재하는지 여부를 판별
	public int countByUserId(String user_id) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(UserinfoSQL.USER_SELECT_BY_ID_COUNT);
		pstmt.setString(1, user_id);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		int userCount = rs.getInt(1);
		return userCount;
	}
}
