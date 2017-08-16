package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.pojo.PictureResult;
import com.taotao.common.utils.JsonUtils;
import com.taotao.service.IPictureService;

@Controller
@RequestMapping("/pic")
public class PictureController {

	@Autowired
	private IPictureService pictureService;
	
	@RequestMapping(value = "/upload")
	@ResponseBody
	public String uploadFile(MultipartFile uploadFile){
		PictureResult result = pictureService.uploadPicture(uploadFile);
//		System.out.println("上传的图片url："+result.getUrl());
		return JsonUtils.objectToJson(result);
	}
}
