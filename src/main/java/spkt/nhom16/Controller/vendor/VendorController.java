package spkt.nhom16.Controller.vendor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spkt.nhom16.Entity.CartItem;
import spkt.nhom16.Entity.Category;
import spkt.nhom16.Entity.Product;
import spkt.nhom16.Entity.Store;
import spkt.nhom16.Model.ProductModel;
import spkt.nhom16.Model.StoreModel;
import spkt.nhom16.Service.ICategoryService;
import spkt.nhom16.Service.IProductService;
import spkt.nhom16.Service.IStoreService;
import spkt.nhom16.Service.*;

@Controller
@RequestMapping(value = { "/", "seller" })
public class VendorController {
	@Autowired
	IProductService productService;
	@Autowired
	ICategoryService categoryService;
	@Autowired
	IStoreService storeService;
	@Autowired
	IUserService usersService;
	@Autowired
	ICartItemService cartItemService;
	
	@GetMapping(value = "seller/{StoreId}")
	public String ProductOfStore(ModelMap model, @PathVariable("StoreId") Store store) {
		List<Product> listProduct = productService.findByStore(store);
		model.addAttribute("products", listProduct);
		Store storeModel = storeService.findById(store.getStoreId());
		model.addAttribute("store", storeModel);
		
		List<CartItem> cartItem = new ArrayList<CartItem>();
		int total = 0;
		for(int i = 0; i < listProduct.size(); i++) {
			for(int j = 0; j < cartItemService.findByProduct(listProduct.get(i)).size(); j++){
				if(cartItemService.findByProduct(listProduct.get(i)).get(j).getStatus() != null) {
					cartItem.add(cartItemService.findByProduct(listProduct.get(i)).get(j));
					total += cartItemService.findByProduct(listProduct.get(i)).get(j).getProduct().getPrice();
				}
			}
		}
		model.addAttribute("cartItem", cartItem);
		model.addAttribute("total", total);
		return "vendor/home/Home";
	}

	@GetMapping(value = "add/{StoreId}")
	public String GetAdd(ModelMap model, @PathVariable("StoreId") Store store) {
		List<Category> categories = categoryService.findAll();
		ProductModel productModel = new ProductModel();
		productModel.setIsEdit(false);
		model.addAttribute("categories", categories);
		model.addAttribute("storeId",store.getStoreId());
		return "vendor/home/AddOrUpdate";
	}

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model,@RequestParam(name="category",required = true)Long categoryId
			,@RequestParam(name="storeId",required = false) Long storeId, @Valid @ModelAttribute("products") ProductModel productModel,
			BindingResult result) {
		if (result.hasErrors()) {
			List<Category> categories = categoryService.findAll();
			model.addAttribute("categories", categories);
			return new ModelAndView("vendor/home/AddOrUpdate");
		}
		Product product = new Product();
		BeanUtils.copyProperties(productModel, product);
		product.setStore(storeService.findById(storeId));
		//product.setCategory(categoryService.findById(categoryId).get());
		productService.save(product);
		return new ModelAndView("redirect:/seller/" + Long.toString(product.getStore().getStoreId()));
	}

	@PostMapping("EditStore")
	public ModelAndView EditStore(ModelMap model, @RequestParam(name = "userId", required = false) Long users,
			@Valid @ModelAttribute("store") StoreModel storeModel, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("vendor/home/StoreEdit");
		}
		Store new_store = new Store();
		BeanUtils.copyProperties(storeModel, new_store);
		new_store.setUserStore(usersService.findById(users).get());
		storeService.save(new_store);
		return new ModelAndView("redirect:/seller/" + Long.toString(new_store.getStoreId()));
	}

	@GetMapping("StoreEdit/{storeId}")
	public ModelAndView StoreEdit(ModelMap model, @PathVariable("storeId") Store store) {
		model.addAttribute("store", store);
		return new ModelAndView("vendor/home/StoreEdit", model);
	}

	@GetMapping("delete/{productId}")
	public ModelAndView delete(ModelMap model, @PathVariable("productId") Long productId) {
		Product product=productService.findById(productId).get();
		String storeId=Long.toString(product.getStore().getStoreId());
		productService.deleteById(productId);
		model.addAttribute("message", "Category đã được xóa thành công");
		return new ModelAndView("redirect:/seller/"+storeId, model);
	}

	@GetMapping("edit/{productId}")
	public ModelAndView edit(ModelMap model, @PathVariable("productId") Long productId) {
		Optional<Product> opt = productService.findById(productId);
		Product Product = opt.get();
		ProductModel product = new ProductModel();
		product.setProductId(productId);
		product.setName(Product.getName());
		product.setPrice(Product.getPrice());
		product.setQuantity(Product.getQuantity());
		product.setIsEdit(true);
		product.setCategory(Product.getCategory());
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);

		model.addAttribute("products", product);
		model.addAttribute("storeId",Product.getStore().getStoreId());
		return new ModelAndView("vendor/home/AddOrUpdate", model);

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
		return "vendor/home/Home";
	}
}
