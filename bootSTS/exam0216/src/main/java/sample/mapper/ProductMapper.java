package sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import sample.dto.Product;

@Mapper
public interface ProductMapper {
	List<Product> selectProductList() throws Exception;
	void insertProduct(Product product) throws Exception;

}
