package com.aws.codestar.silkroute.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.aws.codestar.silkroute.FileStorageProperties;
import com.aws.codestar.silkroute.customexceptions.FileStorageException;
import com.aws.codestar.silkroute.customexceptions.MyFileNotFoundException;
import com.aws.codestar.silkroute.models.Picture;
import com.aws.codestar.silkroute.repositories.PictureRepository;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

@Service
public class StorageService {
	
	
	private final Path fileStorageLocation;
	
	@Autowired
	private PictureRepository pictureRepository;
	
	@Value("${upload.file.extensions}")
	  private String validExtensions;
	
	@Autowired
    public StorageService(FileStorageProperties fileStorageProperties) {
		//get the directory for image uploads
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

	}
	
    public void init() {
    	
    }

    public String store(MultipartFile file) {
    	 String fileName = StringUtils.cleanPath(file.getOriginalFilename());

         try {
             // Check if the file's name contains invalid characters
             if(fileName.contains("..")) {
                 throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
             }

             // Copy file to the target location (Replacing existing file with the same name)
             Path targetLocation = this.fileStorageLocation.resolve(fileName);
             Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

             return fileName;
         } catch (IOException ex) {
             throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
         }
    }

    public String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf(".");
        if(dotIndex < 0) {
          return null;
        }
        return fileName.substring(dotIndex+1);
      }
    public Stream<Path> loadAll(){
    	
    	return null;
    }

    public Path load(String filename) {
    	
    	return null;
    }

    public Resource loadAsResource(String filename) {
    	return null;
    }

    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }
    
    
    public void deleteFile() {
    	
    }

}