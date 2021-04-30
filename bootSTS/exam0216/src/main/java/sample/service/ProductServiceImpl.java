package sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.dto.Product;
import sample.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public List<Product> selectProductList() throws Exception {
		return productMapper.selectProductList();
	}

	@Override
	public void insertProduct(Product product) throws Exception {
		productMapper.insertProduct(product);
	}	

}
