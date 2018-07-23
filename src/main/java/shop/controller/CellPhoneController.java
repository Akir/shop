package shop.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import shop.config.UserDetailsImpl;
import shop.controller.form.CellPhoneForm;
import shop.model.Username;
import shop.service.BrandService;
import shop.service.CellPhoneService;
import shop.service.UsernameService;

@Controller
public class CellPhoneController {
	private CellPhoneService cellPhoneService;
	private BrandService brandService;
	private UsernameService usernameService;

	public CellPhoneController(CellPhoneService cellPhoneService, BrandService brandService,
			UsernameService usernameService) {
		this.cellPhoneService = cellPhoneService;
		this.brandService = brandService;
		this.usernameService = usernameService;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/CellPhone/search")
	public String search (CellPhoneForm cellPhoneForm, Model model) {
		cellPhoneForm.setBrandId(brandService.findIdByName(cellPhoneForm.getBrandName()));
		model.addAttribute("cellPhoneForm", cellPhoneService.findAllByCondition(cellPhoneForm.toCellPhone()));
		return "CellPhone-list";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/CellPhone/{id}")
	public String detail(@PathVariable long id, Model model) {
		model.addAttribute("CellPhone", cellPhoneService.findOne(id));
		return "CellPhone-detail";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/uc/CellPhone/{id}")
	public String ShoppingCart(@PathVariable long id, Model model, WebRequest webRequest) {
		Username username = usernameService.findUserByName(webRequest.getUserPrincipal().getName());
		if(cellPhoneService.shoppingCartExistGoods(username.getId(), id)) {
			cellPhoneService.addQuantity(username.getId(), id);
		}else {
			cellPhoneService.createShoppingCart(username.getId(), id);
		}
		return "redirect:/CellPhone/" + id;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/uc/ShoppingCart")
	public String ShoppingCartDetail(Model model) {
		Username username = CellPhoneController.getCurrentUser();
		model.addAttribute("ShoppingCart", cellPhoneService.findShoppingCart(username.getId()));
		return "ShoppingCart";
	}

	private static Username getCurrentUser() {
		UserDetailsImpl ud = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Username u = ud.getUser();
		return u;
	}
}
