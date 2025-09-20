package com.eccentric.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eccentric.product.dao.ProductRepository;
import com.eccentric.product.dto.ProductRequest;
import com.eccentric.product.entity.Product;

@Service
public class ProductService {

	private final ProductRepository repository;
	private final FileStorageService service;

	@Autowired
	public ProductService(ProductRepository repository, FileStorageService service) {
		this.repository = repository;
		this.service = service;
	}

	public Product addProduct(ProductRequest req) {
		String fileName = service.saveFile(req.getFile());
		Product product = new Product.Builder()
			.name(req.getName())
			.brand(req.getBrand())
			.description(req.getDescription())
			.price(req.getPrice())
			.stock(req.getStock())
			.imgPath(service.getUploadDir() + "/" + fileName)
			.build();
		return repository.save(product);
	}

	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	public Product getProductById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("No such product available"));
	}
}
