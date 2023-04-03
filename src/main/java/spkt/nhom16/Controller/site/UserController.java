package spkt.nhom16.Controller.site;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spkt.nhom16.Entity.*;
import spkt.nhom16.Model.*;
import spkt.nhom16.Service.IStoreService;
import spkt.nhom16.Service.*;

@Controller
public class UserController {
	@Autowired
	IUserService usersService;
	@Autowired
	IStoreService storeService;
	@GetMapping("login")
	public String Login() {
		return "site/login/Login";
	}

	@PostMapping("login")
	public String Login(ModelMap model, @RequestParam(name = "username", required = false) String userName,
			@RequestParam(name = "password", required = false) String passWord, HttpSession session) {

		Users userLogin = usersService.Login(userName, passWord);
		if (userLogin == null) {
			model.addAttribute("message", "Wrong username or password");
			return "site/login/Login";
		} else {
			session.setAttribute("user", userLogin);
			if (userLogin.getRole() == 2) {
				session.setAttribute("store", storeService.findByUserStore(userLogin).get(0));
			}
			return "forward:home";
		}
	}

	
	@GetMapping("signup")
	public String SignUp() {

		return "site/login/SignUp";
	}

	@RequestMapping("signup")
	public String SignUp(ModelMap model, @RequestParam(name = "user", required = false) String userName,
			@RequestParam(name = "pass", required = false) String pass,
			@RequestParam(name = "repass", required = false) String rePass,
			@RequestParam(name = "fullname", required = false) String fullName, HttpSession session) {
		if (usersService.checkUsersExist(userName)) {
			model.addAttribute("message", "Account already exists");
			return "site/login/SignUp";
		} else if (userName.trim().length() < 6 && userName.trim().length() > 24) {
			model.addAttribute("massage", "Username must be 6-24 characters");
			return "site/login/SignUp";
		} else if (pass.trim().length() < 6) {
			model.addAttribute("message", "Password must be at least 6 characters");
			return "site/login/SignUp";
		} else if (!pass.equals(rePass)) {
			model.addAttribute("message", "Password and repeat password doest not match");
			return "site/login/SignUp";
		} else {
			Users newUser = new Users();
			newUser.setUserName(userName);
			newUser.setPassWord(pass);
			newUser.setFullName(fullName);
			newUser.setRole(1);
			usersService.save(newUser);
			session.setAttribute("user", newUser);
			return "redirect:profile";
		}
	}

	@RequestMapping("logout")
	public String Logout(HttpSession session) {
		session.removeAttribute("user");
		if (session.getAttribute("storeId") != null) {
			session.removeAttribute("storeId");
		}
		return "forward:home";
	}

	@GetMapping("profile")
	public String Profile(ModelMap model, HttpSession session) {
		Users user = (Users) session.getAttribute("user");
		model.addAttribute("user", user);
		return "site/profile/Profile";
	}

	@GetMapping("edit")
	public String Edit(ModelMap model, HttpSession session) {
		Users user = (Users) session.getAttribute("user");
		model.addAttribute("user", user);
		return "site/profile/Edit";
	}

	@PostMapping("edit")
	public String EditProfile(ModelMap model, @Valid @ModelAttribute("user") UserModel user, HttpSession session) {
		Users userUpdate = (Users) session.getAttribute("user");

		usersService.updateUser(userUpdate.getUserId(), user.getFullName(), user.getPhone(), user.getEmail(),
				user.getAddresses());
		;
		return "site/profile/Profile";
	}

	@GetMapping("register")
	public String StoreRegistration(ModelMap model, HttpSession session) {
		
		StoreModel newStore = (StoreModel) model.getAttribute("store");
	
		model.addAttribute("store", newStore);
		return "site/profile/StoreRegistration";
	}

	@PostMapping("register")
	public String StoreRegistration(ModelMap model, HttpSession session, @Valid @ModelAttribute("store") StoreModel store) {
		
		Users user = (Users) session.getAttribute("user");
		if (storeService.checkStoreExist(store.getName())) {
			model.addAttribute("message", "Store name is already exists");
			return "forward:register";
		}
		Store newStore = new Store();
		BeanUtils.copyProperties(store, newStore);
		newStore.setUserStore(user);
		
		user.setStore(newStore);
		user.setRole(2);
		user.setUserName(user.getUserName().trim());
		user.setPassWord(user.getPassWord().trim());
		usersService.save(user);
		
		session.setAttribute("store", newStore);
		return "site/profile/Profile";
	}
}