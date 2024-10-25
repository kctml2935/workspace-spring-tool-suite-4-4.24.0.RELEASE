package com.itwill.guest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

@Controller
public class GuestController {
	@Autowired
	private GuestService guestService;
	public GuestController() {
		System.out.println("### GuestController()생성자");
	}
	@GetMapping("/guest_main")
	public String guest_main() {
		return "guest_main";
	}
	
	@GetMapping("/guest_list")
	public String guest_list(Model model) throws Exception {
		List<Guest> guest = guestService.guestList();
		model.addAttribute("guestList", guest);
		return "guest_list";
	}
	
	@GetMapping("/guest_view")
	public String guest_view(@RequestParam("guest_no") int guestNo,Model model) throws Exception {
		Guest guest = guestService.guestDetail(guestNo);
		model.addAttribute("guest", guest);
		return "guest_view";
	}
	@GetMapping("/guest_write_form")
	public String guest_write_form() {
		return "guest_write_form";
	}
	@PostMapping("/guest_write_action")
	public String guest_write_action(@RequestParam("guest_name") String guestName,
		    @RequestParam("guest_email") String guestEmail,
		    @RequestParam("guest_homepage") String guestHomepage,
		    @RequestParam("guest_title") String guestTitle,
		    @RequestParam("guest_content") String guestContent) throws Exception {
		
		Guest guest = new Guest();
		guest.setGuestName(guestName);
		guest.setGuestEmail(guestEmail);
		guest.setGuestHomepage(guestHomepage);
		guest.setGuestTitle(guestTitle);
		guest.setGuestContent(guestContent);
		
		guestService.guestWrite(guest);
		return "redirect:/guest_list";
	}
	
	@PostMapping("/guest_modify_form")
	public String guest_modify_form(@RequestParam("guest_no") int guestNo, Model model) throws Exception {
	    Guest guest = guestService.guestDetail(guestNo);
	    model.addAttribute("guest", guest);
		return "guest_modify_form";
	}
	
	@PostMapping("/guest_modify_action")
	public String guest_modify_action(@RequestParam("guest_no") int guestNo,
			@RequestParam("guest_name") String guestName,
		    @RequestParam("guest_email") String guestEmail,
		    @RequestParam("guest_homepage") String guestHomepage,
		    @RequestParam("guest_title") String guestTitle,
		    @RequestParam("guest_content") String guestContent) throws Exception{
		
		
		Guest guest1 = new Guest();
		guest1.setGuestNo(guestNo);
		guest1.setGuestName(guestName);
		guest1.setGuestEmail(guestEmail);
		guest1.setGuestHomepage(guestHomepage);
		guest1.setGuestTitle(guestTitle);
		guest1.setGuestContent(guestContent);
		System.out.println(guest1);
		guestService.guestUpdate(guest1);
		    	
		return "redirect:/guest_view?guest_no="+guestNo;
		    }
	
	@PostMapping("/guest_remove_action")
	public String guest_remove_action(@RequestParam("guest_no")int guestno) throws Exception {
		guestService.guestDelete(guestno);
		return "redirect:/guest_list";
	}
	
	/*
	<<요청 url(command)>>
	/guest_main			 --forward --> guest_main.jsp
	/guest_list			 --forward --> guest_list.jsp
	/guest_view			 --forward --> guest_view.jsp
	/guest_write_form	 --forward --> guest_write_form.jsp
	/guest_write_action  --redirect--> guest_list
	/guest_modify_form	 --forward --> guest_modify_form.jsp
	/guest_modify_action --redirect--> guest_view
	/guest_remove_action --redirect--> guest_list
	 */
	
}
