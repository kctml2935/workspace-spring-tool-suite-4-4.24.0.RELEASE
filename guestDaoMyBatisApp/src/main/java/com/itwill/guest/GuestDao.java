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
		
		return 0;
	}


	public int update(Guest guest) throws Exception {
		
		return 0;
	}


	public int delete(int guestNo) throws Exception {
	
		return 0;
	}

	
	public Guest findByGuestNo(int guestNo) throws Exception {
		
		return null;
	}

	
	public List<Guest> findByAll() throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		List<Guest> guestList= sqlSession.selectList(NAMESPACE+"selectAll");
		return guestList;
	}

}
