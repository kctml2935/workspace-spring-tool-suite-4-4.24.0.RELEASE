package com.itwill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.guest.GuestService;



@SpringBootApplication
@ComponentScan(basePackages = {"com.itwill.guest"})
public class SpringBootApplicationMain {

	public static void main(String[] args) throws Exception {
		System.out.println("-------- spring boot ApplicationContext 객체생성시작 ---------");
		ApplicationContext applicationContext	= 
				SpringApplication.run(SpringBootApplicationMain.class, args);
		System.out.println("-------- spring boot ApplicationContext 객체생성끝  --------");
		
		//GuestService guestService=(GuestService)applicationContext.getBean("guestServiceImpl");
		GuestService guestService=(GuestService)applicationContext.getBean(GuestService.class);
		System.out.println(guestService.guestList());
		System.out.println(guestService.guestDetail(1));
		

	}

}