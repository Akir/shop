package shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
