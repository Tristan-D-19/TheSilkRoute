package com.aws.codestar.silkroute.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.aws.codestar.silkroute.models.Picture;
import com.aws.codestar.silkroute.models.User;
import com.aws.codestar.silkroute.repositories.PictureRepository;
import com.aws.codestar.silkroute.service.StorageService;

@Controller
public class UploadController {

	@Autowired
	private PictureRepository picRepo;
	
	@Autowired
	private StorageService storageService;
	
	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public ModelAndView submit(@RequestParam("files") MultipartFile[] files, HttpSession session) {
		ModelAndView mav = new ModelAndView("fileUploadView");
		User user = (User) session.getAttribute("user");

		List<MultipartFile> pics = new ArrayList<MultipartFile>(Arrays.asList(files));
		
		for(MultipartFile file: pics) {
			storageService.store(file); //store image
			Picture pic = new Picture(user, file.getOriginalFilename());
			picRepo.save(pic); //create reference to image
		}
//				pics.stream()
//				.map((file) -> {
//					storageService.store(file);
//					Picture pic = new Picture(user, file.getOriginalFilename());
//					})
//				.collect(Collectors.toList());
//		Picture pic = new Picture(user, file.getOriginalFilename());
		
//		picRepo.save(pics);
//		mav.addObject("file", file);
		mav.addObject("pics",pics);
	    return mav;
	}
	
	
	
	
	@GetMapping("/fileUpload")
	public ModelAndView fileUpload() {
		ModelAndView mav = new ModelAndView("fileUpload");
		return mav;
	}
}
