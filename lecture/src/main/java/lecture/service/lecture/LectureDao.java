package lecture.service.lecture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import lecture.service.common.DataSource;

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
			lecture = new Lecture(
							rs.getInt("l_no"),
							rs.getString("l_name"),
							rs.getString("l_desc"),
							rs.getInt("l_price"),
							rs.getString("l_image"),
							rs.getInt("C_no")
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
			Lecture lecture = new Lecture(rs.getInt("l_no"),
							rs.getString("l_name"),
							rs.getString("l_desc"),
							rs.getInt("l_price"),
							rs.getString("l_image"),
							rs.getInt("C_no"));
			lectureList.add(lecture);
		}
		
		return lectureList;
	}
	public LectureCategory findByCNo(int C_no) throws Exception{
		LectureCategory category=null;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(LectureSQL.LECTURECATEGORY_SELECT_BY_NO);
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

}
