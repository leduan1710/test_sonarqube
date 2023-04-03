package spkt.nhom16.Controller.site;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spkt.nhom16.Entity.Product;
import spkt.nhom16.Service.IProductService;

@Controller
public class DetailController {
	@Autowired
	IProductService productService;
	
	@RequestMapping("detail")
	public String ProductDetail(ModelMap model, @RequestParam(name = "pid") Long id) {
		Optional<Product> product = productService.findById(id);
		Product detail = product.get();
		model.addAttribute("detail", detail);
		return "/site/cart/Detail";
	}
}
