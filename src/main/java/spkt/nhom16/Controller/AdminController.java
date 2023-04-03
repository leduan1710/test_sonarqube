package spkt.nhom16.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

import spkt.nhom16.Entity.Category;
import spkt.nhom16.Entity.Product;
import spkt.nhom16.Entity.Users;
import spkt.nhom16.Model.*;
import spkt.nhom16.Service.*;


@Controller
@RequestMapping("admin")
public class AdminController {
	@Autowired
	ICategoryService categoryService;
	
	@Autowired
	IUserService userService;
	@Autowired
	IProductService proService;
	@RequestMapping("home")
	public String home(ModelMap model) {
		return "/admin/index";
	}
	@GetMapping("categories/add")
	public String Add(ModelMap model) {
		CategoryModel category = new CategoryModel();
		category.setIsEdit(false);
		model.addAttribute("category", category);
		return "/admin/categories/addOrEdit";
	}
	@PostMapping("categories/saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, 
			@Valid @ModelAttribute("category") CategoryModel cate, BindingResult result) 
	{
		if(result.hasErrors()) {
			return new ModelAndView("admin/categories/addOrEdit");
		}
		Category entity = new Category();
		BeanUtils.copyProperties(cate, entity);
		categoryService.save(entity);
		
		String message ="";
		if (cate.getIsEdit() == true)
		{
			message="Category đã được cập nhật";
		}
		else {
			message="Category đã được thêm thành công";
		}
		model.addAttribute("message", message);
		return new ModelAndView("redirect:/admin/categories/searchpagenated", model);
	}
	@GetMapping("categories/edit/{categoryId}")
	public ModelAndView edit(ModelMap model,
			@PathVariable("categoryId") Long categoryId) {
		Optional<Category> opt = categoryService.findById(categoryId);
		
		CategoryModel category = new CategoryModel();
		if(opt.isPresent()) {
			Category entity = opt.get();
			BeanUtils.copyProperties(entity, category);
			category.setIsEdit(true);
			model.addAttribute("category", category);
			return new ModelAndView("admin/categories/addOrEdit");
		}
		model.addAttribute("message","Category không tồn tại");
		
		return new ModelAndView("admin/categories", model);
	}
	@GetMapping("categories/delete/{categoryId}")
	public ModelAndView delete(ModelMap model,
			@PathVariable("categoryId") Long categoryId) {
		categoryService.deleteById(categoryId);
		model.addAttribute("message", "Category đã được xóa thành công");
		return new ModelAndView("redirect:/admin/categories/searchpagenated", model);
	}
	@GetMapping("categories/searchpagenated")
	public String search(ModelMap model,
			@RequestParam(name="name", required = false) String name,
			@RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		int count = (int) categoryService.count();
		int currentPage = page.orElse(1);
		int pageSize =size.orElse(3);
		
		Pageable pageable = PageRequest.of(currentPage-1, pageSize,Sort.by("categoryId"));
		Page<Category> resultPage = null;
		if(StringUtils.hasText(name)) {
			resultPage = categoryService.findBynameContaining(name, pageable);
			model.addAttribute("name", name);
		}else {
			resultPage =categoryService.findAll(pageable);
		}
		
		int totalPages =resultPage.getTotalPages();
		if(totalPages >0) {
			int start = Math.max(1, currentPage-2);
			int end = Math.min(currentPage +2, totalPages);
			if (totalPages > count) {
				if(end == totalPages) start =end-count;
				else if (start == 1) end = start +count;
			}
			List<Integer> pageNumbers = IntStream.rangeClosed(start, end)
					.boxed()
					.collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
		model.addAttribute("categoryPage", resultPage);
		return "admin/categories/searchpagenated";
	}
	
	//Controller cho Users
	@GetMapping("users/delete/{userId}")
	public ModelAndView usersDelete(ModelMap model,
			@PathVariable("userId") Long userId) {
		userService.deleteById(userId);
		model.addAttribute("message", "User đã được xóa thành công");
		return new ModelAndView("redirect:/admin/users/searchpagenated", model);
	}
	@GetMapping("users/searchpagenated")
	public String usersSearch(ModelMap model,
			@RequestParam(name="name", required = false) String name,
			@RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		int count = (int) userService.count();
		int currentPage = page.orElse(1);
		int pageSize =size.orElse(3);
		
		Pageable pageable = PageRequest.of(currentPage-1, pageSize,Sort.by("userId"));
		Page<Users> resultPage = null;
		if(StringUtils.hasText(name)) {
			resultPage = userService.findByuserNameContaining(name, pageable);
			model.addAttribute("name", name);
		}else {
			resultPage =userService.findAll(pageable);
		}
		
		int totalPages =resultPage.getTotalPages();
		if(totalPages >0) {
			int start = Math.max(1, currentPage-2);
			int end = Math.min(currentPage +2, totalPages);
			if (totalPages > count) {
				if(end == totalPages) start =end-count;
				else if (start == 1) end = start +count;
			}
			List<Integer> pageNumbers = IntStream.rangeClosed(start, end)
					.boxed()
					.collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
		model.addAttribute("userPage", resultPage);
		return "/admin/users/searchpagenated";
	}
	@GetMapping("products/delete/{productId}")
	public ModelAndView productDelete(ModelMap model,
			@PathVariable("productId") Long productId) {
		proService.deleteById(productId);
		model.addAttribute("message", "Product đã được xóa thành công");
		return new ModelAndView("redirect:/admin/product/searchpagenated", model);
	}
	@GetMapping("products/searchpagenated")
	public String searchProduct(ModelMap model,
			@RequestParam(name="name", required = false) String name,
			@RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		int count = (int) proService.count();
		int currentPage = page.orElse(1);
		int pageSize =size.orElse(3);
		
		Pageable pageable = PageRequest.of(currentPage-1, pageSize,Sort.by("productId"));
		Page<Product> resultPage = null;
		if(StringUtils.hasText(name)) {
			resultPage = proService.findBynameContaining(name, pageable);
			model.addAttribute("name", name);
		}else {
			resultPage =proService.findAll(pageable);
		}
		
		int totalPages =resultPage.getTotalPages();
		if(totalPages >0) {
			int start = Math.max(1, currentPage-2);
			int end = Math.min(currentPage +2, totalPages);
			if (totalPages > count) {
				if(end == totalPages) start =end-count;
				else if (start == 1) end = start +count;
			}
			List<Integer> pageNumbers = IntStream.rangeClosed(start, end)
					.boxed()
					.collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
		model.addAttribute("productPage", resultPage);
		return "admin/products/searchpagenated";
	}
}
