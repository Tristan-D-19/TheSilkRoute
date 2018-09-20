package com.aws.codestar.silkroute.controller;

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

@Controller
public class UploadController {

	@Autowired
	PictureRepository picRepo;
	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public ModelAndView submit(@RequestParam("file") MultipartFile file, HttpSession session) {
		ModelAndView mav = new ModelAndView("fileUploadView");
		User user = (User) session.getAttribute("user");
		Picture pic = new Picture(user, file.getOriginalFilename());
		picRepo.save(pic);
		mav.addObject("file", file);
	    return mav;
	}
	
	@GetMapping("/fileUpload")
	public ModelAndView fileUpload() {
		ModelAndView mav = new ModelAndView("fileUpload");
		return mav;
	}
}
