package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.models.Person;

@Controller
public class Helloworldcontroller {
	
//	string response to a url
	@GetMapping("/test1")
	@ResponseBody // for text
	public String printhello() {
	return "hello dayo";
	}
	
//	string response to a page
	@GetMapping("/test2")
	public String printpageDayo(Model model) {
		model.addAttribute("message","have a great day");
		model.addAttribute("rating",99);
		model.addAttribute("report","have a great day");
		
	return "hello";
	}
	
	@GetMapping("/test3")
	public ModelAndView printpageDayoafain() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message","have a great day");
		mv.addObject("rating",99);
		mv.addObject("report","have a great day");
		mv.setViewName("hello");
		
	return mv;
	}
	
	@GetMapping("/test4")
	public String printpageDayer(@RequestParam("message")String message,Model model) {
		model.addAttribute("message", message); 
		model.addAttribute("message","have a great day");
		model.addAttribute("rating",99);
		model.addAttribute("report","have a great day");
		
	return "hello";
	}

	
//	string response to a page
	@GetMapping("/people")
	public String showFriends(Model model) {
List<Person> friends = new ArrayList<Person>();
friends.add(new Person(1, "John", "Doe", 25, 50000.0f, "Software Engineer", 70.0f));
friends.add(new Person(2, "Jane", "Doe", 28, 60000.0f, "Doctor", 60.0f));
friends.add(new Person(3, "Bob", "Smith", 30, 70000.0f, "Lawyer", 80.0f));
friends.add(new Person(4, "Alice", "Johnson", 35, 80000.0f, "Teacher", 65.0f));
friends.add(new Person(5, "Charlie", "Brown", 40, 90000.0f, "Accountant", 75.0f));
friends.add(new Person(6, "Dave", "Williams", 45, 100000.0f, "Manager", 85.0f));friends.add( new Person(7, "Emily", "Jones", 50, 110000.0f, "CEO", 90.0f));friends.add( new Person(8, "Frank", "Miller", 55, 120000.0f, "CFO", 95.0f)); friends.add(new Person(9, "Grace", "Davis", 60, 130000.0f, "CTO", 100.0f));
friends.add( new Person(10, "Henry", "Garcia", 65, 140000.0f, "COO", 105.0f));
friends.add( new Person(11, "Isabella", "Rodriguez", 70, 150000.0f, "CIO", 110.0f));
friends.add( new Person(12, "Jack", "Wilson", 75, 160000.0f,"Retired" ,115.0f));
friends.add( new Person(13,"Kim","Lee" ,80 ,170000.0f,"Engineer" ,120.0f));
 friends.add(new Person(14,"Liam","Harris" ,85 ,180000.0f,"Architect" ,125.0f));
friends.add( new Person(15,"Mia","Clark" ,90 ,190000.0f,"Designer" ,130.0f));
friends.add( new Person(16,"Noah","Lewis" ,95 ,200000.0f,"Artist" ,135.0f));
friends.add( new Person(17,"Olivia","Walker" ,100 ,210000.0f,"Musician" ,140.0f));
friends.add( new Person(18,"Parker","Hall" ,105 ,220000.0f,"Writer" ,145.0f));
friends.add( new Person(19,"Quinn","Allen" ,110 ,230000.0f,"Journalist" ,150.0f));
friends.add( new Person(20,"Riley","Young" ,115 ,240000.0f,"Editor" ,155.0f));
		
System.out.println(friends);

model.addAttribute("people",friends);
	return "showme";
	}
	


	//string response to a page
	@GetMapping("/peoplejson")
	@ResponseBody
	public List<Person> showFriendJson(Model model) {
		
	List<Person> friends = new ArrayList<Person>();

	friends.add(new Person(1, "John", "Doe", 25, 50000.0f, "Software Engineer", 70.0f));
	friends.add(new Person(2, "Jane", "Doe", 28, 60000.0f, "Doctor", 60.0f));
	friends.add(new Person(3, "Bob", "Smith", 30, 70000.0f, "Lawyer", 80.0f));
	friends.add(new Person(4, "Alice", "Johnson", 35, 80000.0f, "Teacher", 65.0f));
	friends.add(new Person(5, "Charlie", "Brown", 40, 90000.0f, "Accountant", 75.0f));
	friends.add(new Person(6, "Dave", "Williams", 45, 100000.0f, "Manager", 85.0f));
	friends.add( new Person(7, "Emily", "Jones", 50, 110000.0f, "CEO", 90.0f));
	friends.add( new Person(8, "Frank", "Miller", 55, 120000.0f, "CFO", 95.0f));
	friends.add(new Person(9, "Grace", "Davis", 60, 130000.0f, "CTO", 100.0f));
	friends.add( new Person(10, "Henry", "Garcia", 65, 140000.0f, "COO", 105.0f));
	friends.add( new Person(11, "Isabella", "Rodriguez", 70, 150000.0f, "CIO", 110.0f));
	friends.add( new Person(12, "Jack", "Wilson", 75, 160000.0f,"Retired" ,115.0f));
	friends.add( new Person(13,"Kim","Lee" ,80 ,170000.0f,"Engineer" ,120.0f));
	friends.add(new Person(14,"Liam","Harris" ,85 ,180000.0f,"Architect" ,125.0f));
	friends.add( new Person(15,"Mia","Clark" ,90 ,190000.0f,"Designer" ,130.0f));
	friends.add( new Person(16,"Noah","Lewis" ,95 ,200000.0f,"Artist" ,135.0f));
	friends.add( new Person(17,"Olivia","Walker" ,100 ,210000.0f,"Musician" ,140.0f));
	friends.add( new Person(18,"Parker","Hall" ,105 ,220000.0f,"Writer" ,145.0f));
	friends.add( new Person(19,"Quinn","Allen" ,110 ,230000.0f,"Journalist" ,150.0f));
	friends.add( new Person(20,"Riley","Young" ,115 ,240000.0f,"Editor" ,155.0f));
		
	System.out.println(friends);

	model.addAttribute("people",friends);
	return friends;
	}
	

}
