package com.naudo.service.product;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.naudo.dto.product.ProductCardDTO;
import com.naudo.dto.product.ProductSaveDTO;
import com.naudo.model.product.Product;
import com.naudo.repository.product.ProductRepository;
import com.naudo.service.image.ImageService;

/** 
 * @author Fellipe Naudo  
 * @github naudofp
 */

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository repository;
	
	public ProductServiceImpl(ProductRepository repository) {
		this.repository = repository;
	}

	@Override
	public ProductSaveDTO save(ProductSaveDTO dto, MultipartFile file) {

		Product product = new Product(null, dto.name(), dto.description(), dto.price(), null);
		product = ImageService.uploadImage(file, product);
		Product productSaved = repository.save(product);
		
		return new ProductSaveDTO(productSaved.getId(), productSaved.getName(), productSaved.getDescription(), productSaved.getPrice());
	}

	@Override
	public List<ProductCardDTO> findItems() {
		return null;
	}

	
}
