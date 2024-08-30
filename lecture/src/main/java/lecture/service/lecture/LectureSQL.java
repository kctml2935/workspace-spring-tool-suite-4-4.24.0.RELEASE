package lecture.service.lecture;

public class LectureSQL {
	public static final String LECTURE_SELECT_ALL="select * from lecture";
	public static final String LECTURE_SELECT_BY_NO="select l.* from lecture l join lecture_category c on l.C_no=c.C_no where l.l_no=?";
	public static final String LECTURECATEGORY_SELECT_ALL="select * from lecture_category";
	public static final String LECTURECATEGORY_SELECT_BY_NO="select * from lecture where C_no=?";

}
