package com.shyam.springboot.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shyam.springboot.entity.OrdersEntity;
import com.shyam.springboot.entity.Products;
import com.shyam.springboot.entity.User;
import com.shyam.springboot.service.OrderService;
import com.shyam.springboot.service.ProductService;

@Controller
public class ProductController {
	
	
	@Autowired
	UserController  userController;
	
	private ProductService productService;
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}


	@RequestMapping("/productlist")
	public String showProductList(Model model)
	{
		model.addAttribute("productlist", productService.getProductList());
		
		return "ListOfProducts";
	}
	
	@RequestMapping("/adminproductlist")
	public String adminProductList(Model model)
	{
		model.addAttribute("adminproductList", productService.getProductList());
		
		return "AdminListOfProducts";
	}
	
	@GetMapping("/editProduct{id}")
	public String studentEdit(@PathVariable Long id, Model model)
	{
		model.addAttribute("productbyid", productService.getProductById(id));
		
		return "EditProductForm";
	}
	
	@PostMapping("/updateProduct{id}")
	public String updateStudent(@PathVariable Long id, Products productUpdated)
	{
		Products existingProduct = productService.getProductById(id);
		existingProduct.setId(id);
		existingProduct.setProductName(productUpdated.getProductName());
		existingProduct.setCategory(productUpdated.getCategory());
		existingProduct.setPrice(productUpdated.getPrice());
		existingProduct.setSize(productUpdated.getSize());
		
		productService.updateProduct(existingProduct);
		return "redirect:/adminproductlist";
	}
	
	@GetMapping("/deleteProduct{id}")
	public String deleteStudent(@PathVariable Long id)
	{
		productService.deleteProduct(id);
		
		return "redirect:/adminproductlist";
	}
	
	@GetMapping("/addnewproduct")
	public String addNewProduct()
	{
		return "AddProductForm";
	}
	
	@PostMapping("/saveProduct")
	public String saveproduct(@ModelAttribute("prod") Products products)
	{
		//products.setUserName(userController.getUserName());
		productService.addNewProduct(products);
		
		return "redirect:/adminproductlist";
	}
	
	@GetMapping("/buyProduct{id}")
	public String buyproduct(@PathVariable Long id, Model model)
	{
		model.addAttribute("productPurchase", productService.getProductById(id));
		
		return "OrderForm";
	}
}
