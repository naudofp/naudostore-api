package com.naudo.controller.product;



import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.naudo.dto.product.ProductCardDTO;
import com.naudo.dto.product.ProductSaveDTO;
import com.naudo.service.product.ProductService;

/** 
 * @author Fellipe Naudo  
 * @github naudofp
 */

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/product")
public class ProductController {

	private final ProductService service;

	public ProductController(ProductService service) {
		this.service = service;
	}

	@PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<ProductSaveDTO> save(@RequestPart("file") MultipartFile file, @RequestPart("product") ProductSaveDTO product) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(product, file));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteOne(@PathVariable("id") String id){
		service.delete(UUID.fromString(id));
		return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully");
	}
	
	@GetMapping()
	public ResponseEntity<List<ProductCardDTO>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(service.findProducts());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductCardDTO> getOne(@PathVariable("id") String id){
		return ResponseEntity.status(HttpStatus.OK).body(service.findProduct(UUID.fromString(id)));
	}
}
