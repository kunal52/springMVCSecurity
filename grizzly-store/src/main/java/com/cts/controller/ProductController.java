package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.entity.Product;
import com.cts.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/list")
	String getProductList(Model model)
	{
		List<Product> productList = productService.getProductList();
		model.addAttribute("products",productList);
		return "productlist";
	}
	
	@GetMapping("/addproduct")
	String showAddProductForm(Model model)
	{
		Product product=new Product();
		model.addAttribute("product", product);
		System.out.println("ADD Product");
		return "addproduct";
	}
	
	@PostMapping("/saveproduct")
	String addProduct(@ModelAttribute("product")Product product)
	{
		System.out.println(product);
		productService.createProduct(product);
		//return "addproduct";
		return "redirect:/product/list";
	}
	
	@GetMapping("/delete")
	String deleteProduct(@RequestParam("id")int id)
	{
		productService.deleteProduct(id);
		return "redirect:/product/list";
	}
	
	@GetMapping("/update")
	String updateProduct(@RequestParam("id")int id,Model model)
	{
		Product product=new Product();
		product.setProduct_id(id);
		model.addAttribute("product", product);
		return "addproduct";
	}
	
}
