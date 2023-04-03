package spkt.nhom16.Controller.site;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import spkt.nhom16.Entity.Category;
import spkt.nhom16.Entity.Product;
import spkt.nhom16.Service.ICartItemService;
import spkt.nhom16.Service.ICartService;
import spkt.nhom16.Service.ICategoryService;
import spkt.nhom16.Service.IProductService;
import spkt.nhom16.Service.IStoreService;

@Controller
@RequestMapping(value = { "/", "home" })
public class HomeController {
	@Autowired
	ICategoryService categoryService;
	@Autowired
	IProductService productService;
	@Autowired
	IStoreService storeService;
	@Autowired
	ICartService cartService;
	@Autowired
	ICartItemService cartItemService;
	
	@RequestMapping(value = { "", "home" })
	public String Home(ModelMap model) {
		List<Category> listCategory = categoryService.findAll();
		model.addAttribute("categories", listCategory);
		List<Product> listProduct = productService.findAll();
		model.addAttribute("products", listProduct);
		return "site/home/Home";
	}
	
}