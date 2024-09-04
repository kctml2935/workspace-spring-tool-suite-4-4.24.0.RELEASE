package lecture.service.lecture;

import java.util.List;

public class LectureService {
	private LectureDao lectureDao;
	public LectureService() throws Exception{
		lectureDao=new LectureDao();
	}
	//전체상품보기
	public List<Lecture> lectureList() throws Exception{
		return lectureDao.findAll();
	}
	//상품상제보기
	public Lecture lectureDetail(int l_no) throws Exception{
		return lectureDao.findByNo(l_no);
	}
	//상품이름으로보기
	public List<Lecture> lectureDetailByuserId(String user_id) throws Exception{
		return lectureDao.findOrderWithLecture(user_id);
	}
	
}
