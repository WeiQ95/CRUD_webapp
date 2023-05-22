package com.fdmgroup.timelessfinds.Controller;

import java.nio.file.AccessDeniedException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.timelessfinds.Model.Cart;
import com.fdmgroup.timelessfinds.Model.Product;
import com.fdmgroup.timelessfinds.Model.User;
import com.fdmgroup.timelessfinds.Repository.ProductRepository;
import com.fdmgroup.timelessfinds.Service.CartService;
import com.fdmgroup.timelessfinds.Service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProductController {

    private ProductService productService;
    
    private CartService cartService;

    @Autowired
    public ProductController(ProductService productService, CartService cartService) {
		this.productService = productService;
		this.cartService = cartService;
	}

    @GetMapping("/productslist")
    public String getAllProducts(Model model, HttpSession session) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        model.addAttribute("loggedInUser", loggedInUser);
        return "productslist";
    }

    @GetMapping("/create")
    public String createProduct(Model model) {
        model.addAttribute("newProduct", new Product());
        return "productform";
    }

    @PostMapping("/create")
    public String saveProduct(@ModelAttribute("newProduct") Product newProduct, HttpSession session) throws AccessDeniedException{
    	User currentUser = (User) session.getAttribute("loggedInUser");
    	if(currentUser == null) {
    		return "redirect:/login";
    		}
    	productService.addProduct(newProduct, currentUser);
    	return "redirect:/productslist";
    	}

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") Long id, Model model, HttpSession session) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        model.addAttribute("loggedInUser", loggedInUser);
        return "editproduct";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable("id") Long id, @ModelAttribute("product") Product updatedProduct, HttpSession session) throws AccessDeniedException {
    	User currentUser = (User) session.getAttribute("loggedInUser");
    	if(currentUser == null) {
    		return "redirect:/login";
    		}
    	productService.updateProduct(id, updatedProduct, currentUser);
        return "redirect:/productslist";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id, Model model, HttpSession session) throws AccessDeniedException {
    	User loggedInUser = (User) session.getAttribute("loggedInUser");
        model.addAttribute("loggedInUser", loggedInUser);
    	productService.deleteProduct(id, loggedInUser);
        return "redirect:/productslist";
    }
    
    @PostMapping("/delete/{id}")
    public String removeProduct(@PathVariable("id") Long id, Model model, HttpSession session) {
    	User currentUser = (User) session.getAttribute("loggedInUser");
    	if(currentUser == null) {
    		return "redirect:/login";
    		}
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "redirect:/productslist";
    }
    
    @PostMapping("/productcatalogue/search")
	public String goToProductCatalogue(Model model, String searchTerm) {
    	List<Product> products = productService.findProductsByMatchingName(searchTerm);
    	model.addAttribute("products", products);
		return "productcatalogue";
	}

    @GetMapping("/productcatalogue")
    public String getAllProductCatalogue(Model model, HttpSession session) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "productcatalogue";
    }
    
    @PostMapping("/productcatalogue/addtocart")
    public String addProductToCart(HttpSession session, @RequestParam Long productId) {
    	User user = (User) session.getAttribute("loggedInUser");
    	if (user == null) {
    		return "redirect:/login";
    	}
    	long cartId = user.getCart().getCartId();
    	cartService.addProductToCart(cartId, productId);
    	return "redirect:/productcatalogue";
    }

    
}