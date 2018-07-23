package shop.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import shop.config.UserDetailsImpl;
import shop.model.Username;
import shop.service.ShoppingCartService;
import shop.service.UsernameService;

@Controller
public class ShoppingCartController {
	private ShoppingCartService shoppingCartService;
	private UsernameService usernameService;
	
	public ShoppingCartController(ShoppingCartService shoppingCartService, UsernameService usernameService) {
		this.shoppingCartService = shoppingCartService;
		this.usernameService = usernameService;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/uc/CellPhone/{id}")
	public String ShoppingCart(@PathVariable long id, Model model, WebRequest webRequest) {
		Username username = usernameService.findUserByName(webRequest.getUserPrincipal().getName());
		shoppingCartService.addCart(username.getId(), id);
		return "redirect:/CellPhone/" + id;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/uc/ShoppingCart")
	public String ShoppingCartDetail(Model model) {
		Username username = ShoppingCartController.getCurrentUser();
		model.addAttribute("ShoppingCart", shoppingCartService.findShoppingCart(username.getId()));
		return "ShoppingCart";
	}

	private static Username getCurrentUser() {
		UserDetailsImpl ud = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Username u = ud.getUser();
		return u;
	}
}
