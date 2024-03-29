package com.naudo.service.product;

import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.naudo.dto.product.ProductCardDTO;
import com.naudo.dto.product.ProductSaveDTO;

/** 
 * @author Fellipe Naudo  
 * @github naudofp
 */

public interface ProductService {

	ProductSaveDTO save(ProductSaveDTO dto, MultipartFile file);
	
	List<ProductCardDTO> findProducts();
	
	ProductCardDTO findProduct(UUID id);
	
	void delete(UUID id);
}
