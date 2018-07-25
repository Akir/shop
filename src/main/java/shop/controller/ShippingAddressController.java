package shop.controller;

import javax.validation.Valid;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shop.config.UserDetailsImpl;
import shop.model.ShippingAddress;
import shop.model.Username;
import shop.service.ShippingAddressService;

@Controller
public class ShippingAddressController {
	private ShippingAddressService shippingAddressService;

	public ShippingAddressController(ShippingAddressService shippingAddressService) {
		this.shippingAddressService = shippingAddressService;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/uc/shippingAddress")
	public String shippingAddress(Model model) {
		model.addAttribute("shippingAddresses", shippingAddressService.findAll());
		return "shippingAddress";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/uc/shippingAddress/add")
	public String add(@ModelAttribute ShippingAddress shippingAddress) {
		return "ShippingAddress-add";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/uc/shippingAddress/add")
	public String create(@ModelAttribute @Valid ShippingAddress shippingAddress, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "ShippingAddress-add";
		}
		Username username = ShippingAddressController.getCurrentUser();
		shippingAddress.setUsername(username);
		shippingAddressService.create(shippingAddress);
		return "redirect:/uc/shippingAddress";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/uc/shippingAddress/delete/{id}")
	public String delete(@PathVariable Long id) {
		shippingAddressService.delete(id);
		return "redirect:/uc/shippingAddress";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/uc/shippingAddress/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("shippingAddress", shippingAddressService.findOne(id));
		return "ShippingAddress-add";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/uc/shippingAddress/edit/{id}")
	public String update(@PathVariable Long id, @ModelAttribute @Valid ShippingAddress shippingAddress, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "ShippingAddress-add";
		}
		shippingAddress.setId(id);
		shippingAddressService.update(shippingAddress);
		return "redirect:/uc/shippingAddress";
	}
	
	private static Username getCurrentUser() {
		UserDetailsImpl ud = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Username u = ud.getUser();
		return u;
	}
}
