package com.aws.codestar.silkroute.DAO;

import java.util.List;

import com.aws.codestar.silkroute.models.Picture;

public class ProductPictureDAO implements ProductPictureDAOI {

	
	@Override
	public List<Picture> getPicturesByProduct(long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createNewProductPicture(long prodId, long picId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeProductPicture(long prodId, long picId) {
		// TODO Auto-generated method stub
		return false;
	}

}
