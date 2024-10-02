package com.itwill.guest;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
public class GuestDao {
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE = "com.itwill.guest.mapper.GuestMapper.";
	public GuestDao() {
		try {
			InputStream myBatisConfigInputStream = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			this.sqlSessionFactory = sqlSessionFactoryBuilder.build(myBatisConfigInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int insert(Guest guest) throws Exception {
		SqlSession sqlSession=
				sqlSessionFactory.openSession(true);
		int insertRowCount=
				sqlSession.insert(NAMESPACE+"insert",guest);
		sqlSession.close();
		return guest.getGuestNo();
	}


	public int update(Guest guest) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int updateRowCount=
				sqlSession.update(NAMESPACE+"update",guest);
		sqlSession.close();
		return updateRowCount;
	}


	public int delete(int guestNo) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int deleteRowCount=sqlSession.delete(NAMESPACE+"delete",guestNo);
		sqlSession.close();
		return deleteRowCount;
	}

	
	public Guest findByGuestNo(int guestNo) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		Guest guest= sqlSession.selectOne(NAMESPACE+"findByGuestNo",guestNo);
		sqlSession.close();
		return guest;
	}

	
	public List<Guest> findByAll() throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		List<Guest> guestList= sqlSession.selectList(NAMESPACE+"findByAll");
		sqlSession.close();
		return guestList;
	}

}