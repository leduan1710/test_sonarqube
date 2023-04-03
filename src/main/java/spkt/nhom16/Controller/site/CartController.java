package spkt.nhom16.Controller.site;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spkt.nhom16.Entity.Cart;
import spkt.nhom16.Entity.CartItem;
import spkt.nhom16.Entity.Product;
import spkt.nhom16.Entity.Users;
import spkt.nhom16.Service.ICartItemService;
import spkt.nhom16.Service.ICartService;
import spkt.nhom16.Service.IProductService;

@Controller
public class CartController {

	@Autowired
	ICartItemService cartItemService;
	@Autowired
	ICartService cartService;
	@Autowired
	IProductService productService;

	@RequestMapping("cart")
	public String cart(ModelMap model, HttpSession session) {
		Users userLogin = (Users) session.getAttribute("user");
		Cart cart = cartService.findByUser(userLogin);

		int total = 0;
		List<CartItem> items = cartItemService.findByCart(cart);
		List<CartItem> itemsView = new ArrayList<>();
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).getStatus() == null)
			{
				itemsView.add(items.get(i));
				total += items.get(i).getProduct().getPrice();
			}
		}
		model.addAttribute("cartItem", itemsView);
		model.addAttribute("total", total);
		return "site/cart/Cart";
	}

	@GetMapping("add")
	public String add(@RequestParam(name = "pid") Long productId, HttpSession session) {
		Users userLogin = (Users) session.getAttribute("user");
		if (userLogin == null) {
			return "site/login/Login";
		}
		Cart cart = new Cart();
		if (cartService.findByUser(userLogin) == null) {
			cart.setUser(userLogin);
			cartService.save(cart);
		} else {
			cart = cartService.findByUser(userLogin);
		}
		Product product = productService.findById(productId).get();
		CartItem item = cartItemService.checkExist(product, cart);
		if (item != null && item.getStatus() == null) {
			cartItemService.update(item.getCartItemId(), item.getCount() + 1);
		} else {
			item = new CartItem();
			item.setCart(cart);
			item.setProduct(product);
			item.setCount(1);
			cartItemService.save(item);
		}
		return "forward:home";
	}
	
	@GetMapping("buy")
	public String buy(HttpSession session) {
		Users userLogin = (Users) session.getAttribute("user");
		Cart cart = cartService.findByUser(userLogin);
		
		List<CartItem> items = cartItemService.findByCart(cart);
		items.forEach((item) -> {
			item.setStatus("buy");
			cartItemService.save(item);
		});
		return "forward:cart";
	}
	
	@GetMapping("delete")
	public String delete(@RequestParam(name = "ciid") Long id, HttpSession session) {
		cartItemService.deleteById(id);
		
		return "forward:cart";
	}
}
