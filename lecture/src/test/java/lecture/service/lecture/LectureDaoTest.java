package lecture.service.lecture;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LectureDaoTest {
	LectureDao lectureDao;
	
	@Test
	@BeforeEach
	void setUp() throws Exception {
		lectureDao=new LectureDao();
	}

/*
	@Test
	void testFindByNo() throws Exception {
		Lecture lecture = lectureDao.findByNo(1);
		assertNotNull(lecture);
		System.out.println(lecture);
		
		
	}
	@Test
	void testFindAll() throws Exception {
		List<Lecture> lectureList = lectureDao.findAll();
		assertNotNull(lectureList);
		System.out.println(lectureList);
		
	}
 */

/*	@Test
	void testFindByCNo() throws Exception {
		LectureCategory lecture = lectureDao.findByCNo(2);
		assertNotNull(lecture);
		System.out.println(lecture);
	}
*/
	/*
	@Test
	void testFindAllC() {
		fail("Not yet implemented");
	}

	@Test
	void testFindOrderWithLecture() {
		fail("Not yet implemented");
	}
*/
}
