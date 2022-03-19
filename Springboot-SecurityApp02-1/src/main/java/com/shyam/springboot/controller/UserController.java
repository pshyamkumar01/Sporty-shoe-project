package com.shyam.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shyam.springboot.entity.OrdersEntity;
import com.shyam.springboot.entity.User;
import com.shyam.springboot.service.UserService;

@Controller
public class UserController {
	
	private String username;
//	private User user;
//	public UserController(User user) {
//		super();
//		this.user = user;
//	}

	private UserService userService;
	public UserController(UserService userService) {
	
		super();
		this.userService = userService;
	}

//	private UserListService userListService;
//	public UserController(UserListService userListService) {
//		super();
//		this.userListService = userListService;
//	}

	@RequestMapping("/login")
	public String showLogin()
	{
		return "Login";
	}
	
	@PostMapping("/logindetails")
	public String loginDetails(@RequestParam("username") String username, @RequestParam("password") String password) {
		
		System.out.println("user name is: "+username);
		System.out.println("user password is: "+password);
		
		User existinguser = userService.getUserByName(username);
		
		System.out.println("--------------------------------");
		System.out.println("Existring admin name is: "+existinguser.getUsername()+" Existing admin password is: "+existinguser.getPassword());
		
		if(existinguser.getId() == 1)
		{
			if(username.equals(existinguser.getUsername()) && password.equals(existinguser.getPassword()))
			{
				setUserName(username);
				return"Dashboard";
			}
			else
			{
				return "Error";
			}
		}
		else if(username.equals(existinguser.getUsername()) && password.equals(existinguser.getPassword()))
		{
			setUserName(username);
			return "redirect:/productlist";
		}
		else
		return "Error";
	}

	@RequestMapping("/showdashboard")
	public String showDashboard()
	{
		return "Dashboard";
	}
	
	
	@GetMapping("/adduser")
	public String addUser()
	{
		return "AddNewUser";
	}
	
	@PostMapping("/saveuser")
	public String saveUser(@ModelAttribute("newuser") User newuser)
	{
		userService.addNewUser(newuser);
		
		return "LoginSuccess";
	}
	
	@GetMapping("/listofusers")
	public String listOfUsers(Model model)
	{
		model.addAttribute("userlist", userService.getUserList());
		
		
		return "ListOfUsers";
	}
	
	@RequestMapping("/changePassword")
	public String changePass()
	{
		return "ChangePassword";
	}
	
	@PostMapping("/savePassword")
	public String updatePassword(@RequestParam("oldpassword") String oldpassword, @RequestParam("newpassword") String newpassword)
	{
		User userpass = userService.getUserByPass(oldpassword);
		if(userpass!=null)
		{
			userpass.setPassword(newpassword);
			userService.updateUser(userpass);
		}
		else
		{
			return "CannotChangePassword";
		}
		
		return "redirect:/login";
	}
	
	@GetMapping("/searchuser")
	public String searchUser(@RequestParam("uname") String uname, Model model)
	{
		model.addAttribute("getbyname", userService.getUserByName(uname));
		
		return "UserNameTable";
	}
	
	@RequestMapping("/adminlogout")
	public String adminLogout()
	{
		return "redirect:/login";
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}
	
}
