package sample.service;

import java.util.List;

import sample.dto.Product;

public interface ProductService {
	List<Product> selectProductList() throws Exception;
	void insertProduct(Product product) throws Exception;

}
