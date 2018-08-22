package com.aws.codestar.silkroute.DAO;
import com.aws.codestar.silkroute.models.*;
import java.util.List;



/**
 * PictureDAOI is an interface for querying the table TSR_Picuture 
 * This interface can access the url for pictures.
 */
public interface PictureDAOI { 

    
    enum SQL {
        GETALLUSERSPICS("SELECT * FROM TSR_ADMIN.TSR_PICTURE WHERE USER_ID=?"),
        UPLOADPHOTOS("INSERT INTO TSR_ADMIN.TSR_PICTURES (IMAGE, USER_ID ) values (?,?)"),
        REMOVEPHOTOS("DELETE FROM TSR_ADMIN.TSR_PICTURES WHERE PICTURE_ID=?");
		
		String query;
		
		SQL(String givenQuery){
			query = givenQuery;
		}
		
		String getQuery() {
			return query;
		}
    }

    /**
     * getAllUsersPics gets all of a users pics from the data base.
     * @param userId the user's ID
     * @return a list of Pictures owned by the user type List
     */
   public List<Picture> getAllUsersPics(long userId);

   
   /**uploadPhotos uploads a set of photos from the user
    * @param images a list of images to upload 
    * @param userId the user's id
    * @return a boolean indicating the upload was successfull
    */

    public boolean uploadPhotos(List<Picture> pics, long userId );

    /**
     * removePhoto removes a user's photo from the table TSR_PHOTO 
     * @param picId the picture's ID. 
     * @return boolean indicating if the removal was successfull
     */
    public boolean removePhoto(long picId);
}