package com.aws.codestar.silkroute.repositories;

import org.springframework.data.repository.CrudRepository;

import com.aws.codestar.silkroute.models.Picture;
import com.aws.codestar.silkroute.models.User;
import java.util.List;
import java.lang.String;

public interface PictureRepository extends CrudRepository<Picture, Long> {

	List<Picture> findByUser(User user);
	
	List<Picture> findByImageUrl(String imageurl);
	
	
}
