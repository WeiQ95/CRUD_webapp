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

@Controller
public class UserController {
    @Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUserAccount(@ModelAttribute("user")@Validated User user, BindingResult result) {
		User existingUser = userService.findByEmail(user.getEmail());
		if(existingUser != null) {
			result.rejectValue("email", null, "There is already an account registered with that email");
		}
		if (result.hasErrors()) {
			return "register";
		}
		
		userService.save(user);
		
		return "redirect:login";
	}
}
