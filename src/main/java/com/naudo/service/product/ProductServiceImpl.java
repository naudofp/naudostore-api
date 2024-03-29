package com.naudo.service.product;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.naudo.dto.product.ProductCardDTO;
import com.naudo.dto.product.ProductSaveDTO;
import com.naudo.exception.ProductNotFoundException;
import com.naudo.model.product.Product;
import com.naudo.repository.product.ProductRepository;
import com.naudo.service.image.ImageService;
import com.naudo.util.mapper.UtilMapper;

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
	public void delete(UUID id) {
		System.out.println(id);
		Product entity = repository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product " + id + " was not found"));
		repository.delete(entity);
	}

	@Override
	public List<ProductCardDTO> findProducts() {
		
		List<Product> products = repository.findAll();
		List<ProductCardDTO> dtos = UtilMapper.eAllProductsToAllProductCardDTO(products);
		
		return dtos;
	}

	@Override
	public ProductCardDTO findProduct(UUID id) {
		Product product = repository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product " + id + " was not found"));
		return UtilMapper.eProductToProductCardDTO(product);
	}
	
}
