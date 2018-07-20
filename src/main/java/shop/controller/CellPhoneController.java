package shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shop.controller.form.CellPhoneForm;
import shop.service.BrandService;
import shop.service.CellPhoneService;

@Controller
public class CellPhoneController {
	private CellPhoneService cellPhoneService;
	private BrandService brandService;

	public CellPhoneController(CellPhoneService cellPhoneService, BrandService brandService) {
		this.cellPhoneService = cellPhoneService;
		this.brandService = brandService;
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
}
