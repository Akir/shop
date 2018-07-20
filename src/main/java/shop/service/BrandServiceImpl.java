package shop.service;

import org.springframework.stereotype.Service;

import shop.mapper.BrandMapper;

@Service
public class BrandServiceImpl implements BrandService {
	private BrandMapper brandMapper;
	
	public BrandServiceImpl(BrandMapper brandMapper) {
		this.brandMapper = brandMapper;
	}
	
	public long findIdByName(String brandName) {
		Long id = brandMapper.findIdByName(brandName);
		if(id == null) {
			return 0;
		}
		return id;
	}

}
