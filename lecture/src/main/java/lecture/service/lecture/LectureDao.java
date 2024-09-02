package lecture.service.lecture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import lecture.service.common.DataSource;
import lecture.service.order.OrderSQL;

public class LectureDao {
	private DataSource dataSource;
	public LectureDao() throws Exception{
		dataSource=new DataSource();
	}
	public Lecture findByNo(int l_no) throws Exception{
		Lecture lecture =null;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(LectureSQL.LECTURE_SELECT_BY_NO);
		pstmt.setInt(1, l_no);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			LectureCategory category = new LectureCategory(rs.getInt("C_no"));
			lecture = new Lecture(
							rs.getInt("l_no"),
							rs.getString("l_name"),
							rs.getString("l_desc"),
							rs.getInt("l_price"),
							rs.getString("l_image"),
							category
					 );
		}
		return lecture;
		
	}
	
	public List<Lecture> findAll() throws Exception{
		List<Lecture> lectureList = new ArrayList<Lecture>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(LectureSQL.LECTURE_SELECT_ALL);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			LectureCategory category = new LectureCategory(rs.getInt("C_no"));
			Lecture lecture = new Lecture(rs.getInt("l_no"),
							rs.getString("l_name"),
							rs.getString("l_desc"),
							rs.getInt("l_price"),
							rs.getString("l_image"),
							category);
			lectureList.add(lecture);
		}
		
		return lectureList;
	}
	public LectureCategory findByCNo(int c_no) throws Exception{
		LectureCategory category=null;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(LectureSQL.LECTURECATEGORY_SELECT_BY_NO);
		pstmt.setInt(1, c_no);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			category=new LectureCategory(
					rs.getInt("C_no"),
					rs.getString("C_name"));
		}
		
		return category;
	}
	public List<LectureCategory> findAllC() throws Exception{
		List<LectureCategory> categoryList = new ArrayList<LectureCategory>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(LectureSQL.LECTURECATEGORY_SELECT_ALL);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			LectureCategory category=new LectureCategory(rs.getInt("C_no"),rs.getString("C_name"));
			categoryList.add(category);
		}
		
		return categoryList;
	}
		//ORDER_SELECT_WITH_LECTURE_BY_USER_ID
		//L_NAME L_DESC L_IMAGE
		//userid로 lecture 찾기
		public List<Lecture> findOrderWithLecture(String sUserId) throws Exception{
			List<Lecture> LectureorderList = new ArrayList<>();
			Lecture lecture = new Lecture();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(OrderSQL.ORDER_SELECT_WITH_LECTURE_BY_USER_ID);
				pstmt.setString(1, sUserId);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					lecture.setL_name(rs.getString("l_name"));
					lecture.setL_desc(rs.getString("l_desc"));
					lecture.setL_image(rs.getString("l_image"));
					
					LectureorderList.add(lecture);
				}
			}finally {
				if(con != null) {
					con.close();
				}
			}
			
			return LectureorderList;
		}
		

}
