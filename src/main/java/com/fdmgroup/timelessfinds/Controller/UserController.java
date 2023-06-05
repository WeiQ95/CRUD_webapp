package com.fdmgroup.timelessfinds.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;


import com.fdmgroup.timelessfinds.Model.User;
import com.fdmgroup.timelessfinds.Service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	private UserService userService;
    
    @Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "registrationform";
	}
	
	@PostMapping("/register")
	public String registerUserAccount(@ModelAttribute("user")@Validated User user, BindingResult result) {
		User existingUser = userService.findByEmail(user.getEmail());
		if(existingUser != null) {
			result.rejectValue("email", null, "There is already an account registered with that email");
		}
		if (result.hasErrors()) {
			return "registrationform";
		}
		
		userService.save(user);
		
		return "redirect:login";
	}
	
	@GetMapping("/login")
	public String showLoginForm(Model model) {
		model.addAttribute("user", new User());
		return "loginform";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute User user, HttpSession session) {
		User existingUser = userService.findByEmail(user.getEmail());
		
		if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
			session.setAttribute("loggedInUser", existingUser);
			return "redirect:/productslist";
		} else { 
			return "loginform";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loggedInUser");
		return "redirect:/";
	}
	
	
	@GetMapping("/profile")
	public String showProfile(Model model, HttpSession session) {
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		if (loggedInUser != null) {
			// user is logged in, show their profile page
			model.addAttribute("userId", loggedInUser.getId());
			model.addAttribute("userName", loggedInUser.getEmail());
			return "profile";
		} else {
			// user is not logged in, redirect to login page
			return "redirect:/login";
		}
	}
}
