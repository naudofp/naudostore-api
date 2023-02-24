package com.naudo.service.image;

import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.naudo.exception.ImageByteUnvalidException;
import com.naudo.model.product.Product;

/** 
 * @author Fellipe Naudo  
 * @github naudofp
 */

@Service
public class ImageService {
	
	public static Product uploadImage(MultipartFile file, Product entity) {
		try {
			entity.setImage(file.getBytes());
			return entity;
		} catch (IOException e) {
			throw new ImageByteUnvalidException("Image's bytes unvalid");
		}
	}

	public static String getImageBase64(Product entity) {
       return Base64.getEncoder().encodeToString(entity.getImage());
    }
}
