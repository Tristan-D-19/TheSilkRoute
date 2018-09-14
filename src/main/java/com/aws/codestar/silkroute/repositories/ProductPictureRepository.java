package com.aws.codestar.silkroute.repositories;

import org.springframework.data.repository.CrudRepository;

import com.aws.codestar.silkroute.models.ProductPicture;
import com.aws.codestar.silkroute.models.Product;
import java.util.List;

public interface ProductPictureRepository extends CrudRepository<ProductPicture, Long> {

	List<ProductPicture> findByProduct(Product product);
	
}
