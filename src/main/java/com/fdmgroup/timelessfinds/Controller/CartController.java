package com.fdmgroup.timelessfinds.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {

    @GetMapping("/cartpage")
	public String showCartPage() {
		return "cartpage";
	}
    
}
