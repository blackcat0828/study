package sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import sample.dto.Product;
import sample.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping("/productInsert")
	public String ProductInsertForm() {
		return "/productInsertForm";
	}
	
	@PostMapping("/productInsert")
	public String productInsert(Product product) throws Exception {
		productService.insertProduct(product);
		
		return "redirect:/productList";
	}
	
	@GetMapping("/productList")
	public ModelAndView productList() throws Exception {
		ModelAndView mv = new ModelAndView("/productList");
		List<Product> list = productService.selectProductList();
		mv.addObject("list", list);
		return mv;
	}
}
