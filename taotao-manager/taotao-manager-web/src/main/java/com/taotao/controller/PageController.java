package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

 
@Controller
public class PageController {

	// 展示首页
	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}
	
	// 展示功能页面
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
}
