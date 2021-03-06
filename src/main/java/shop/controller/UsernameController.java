package shop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shop.model.Username;
import shop.service.UsernameService;
import shop.service.exception.UsernameExistException;

@Controller
public class UsernameController {
	private UsernameService usernameService;

	@Autowired
	public UsernameController(UsernameService usernameService) {
		this.usernameService = usernameService;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/register")
	public String registerPage(@ModelAttribute Username username) {
		return "register";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public String register(@ModelAttribute @Valid Username username, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()){
			return "register";
		}
		try {
			usernameService.create(username);
		}catch (UsernameExistException e) {
			System.out.println(e.getMessage());
			bindingResult.rejectValue("username", "0", "用户名已存在");
			return "register";
		}
		return "redirect:/";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public String loginPage() {
		return "login";
	}
	
}
