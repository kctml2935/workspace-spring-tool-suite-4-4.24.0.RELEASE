package com.itwill.guest;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.itwill.guest.mapper.GuestMapper;

public class GuestDaoImplMyBatisInterface implements GuestDao{
	private SqlSessionFactory sqlSessionFactory;
	public GuestDaoImplMyBatisInterface() {
		try {
			InputStream myBatisConfigInputStream = Resources.getResourceAsStream("mybatis-config-interface.xml");
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			this.sqlSessionFactory = sqlSessionFactoryBuilder.build(myBatisConfigInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public int insert(Guest guest) throws Exception {
	
		return 0;
	}

	@Override
	public int update(Guest guest) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int guestNo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Guest findByGuestNo(int guestNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findByAll() throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		GuestMapper guestMapper = sqlSession.getMapper(GuestMapper.class);
		List guestList= guestMapper.findByAll();
		return guestList;
	}

}