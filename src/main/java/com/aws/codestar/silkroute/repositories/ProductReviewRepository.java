package com.aws.codestar.silkroute.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aws.codestar.silkroute.models.Product;
import com.aws.codestar.silkroute.models.ProductReview;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Long> {

	public List<ProductReview> findByProduct(Product product);


}
