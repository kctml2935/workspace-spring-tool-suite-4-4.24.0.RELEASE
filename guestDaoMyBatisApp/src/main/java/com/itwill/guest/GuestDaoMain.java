package com.itwill.guest;

public class GuestDaoMain {

	public static void main(String[] args)throws Exception {
		GuestDao guestDao=new GuestDao();
		System.out.println("----------findByAll--------------");
		System.out.println(guestDao.findByAll());
		System.out.println("----------findByGuestNo----------");
		System.out.println(guestDao.findByGuestNo(3));
		System.out.println("----------delete-----------------");
		System.out.println(guestDao.delete(4));
		System.out.println("----------update-----------------");
		System.out.println(guestDao.update(Guest.builder()
										.guestNo(29)
										.guestName("흑종완")
										.guestEmail("black@gmail.com")
										.guestHomepage("http://ww.balck.co.kr")
										.guestTitle("오늘의흑종원요리는!!")
										.guestContent("흑백숙~~~")
										.build()));
		
		System.out.println("----------insert-----------------");
		System.out.println(guestDao.insert(Guest.builder()
											.guestName("백종완")
											.guestEmail("baek@gmail.com")
											.guestHomepage("http://www.baek.co.kr")
											.guestTitle("오늘의요리")
											.guestContent("아주맛있는 요리여요!!!")
											.build()));
		
		
	}

}