package spkt.nhom16.Controller.site;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spkt.nhom16.Entity.Category;
import spkt.nhom16.Entity.Product;
import spkt.nhom16.Service.ICategoryService;
import spkt.nhom16.Service.IProductService;

@Controller
@RequestMapping(value = {"", "/", "home"})
public class ProductController{
	@Autowired
	IProductService productService;
	@Autowired
	ICategoryService categoryService;
	
	@RequestMapping("category")
	public String ListProductByCategory(ModelMap model, @RequestParam(name = "cid") Category category) {
		List<Category> listCategory = categoryService.findAll();
		model.addAttribute("categories",listCategory);
		List<Product> listProduct = productService.findByCategory(category);
		model.addAttribute("products",listProduct);
		model.addAttribute("tag", category.getCategoryId());
		return "site/home/Home";
	}
	
	@RequestMapping("search")
	public String Search(ModelMap model, @RequestParam(name = "search", required = false) String name) {
		List<Product> list = null;
		if(StringUtils.hasText(name)) {
			list = productService.findByNameContaining(name);
		} else {
			list = productService.findAll();
		}
		model.addAttribute("products", list);
		List<Category> listCategory = categoryService.findAll();
		model.addAttribute("categories",listCategory);
		return "site/home/Home";
	}
}