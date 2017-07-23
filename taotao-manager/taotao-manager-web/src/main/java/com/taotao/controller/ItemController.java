package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

/**
 * 商品查询Controller
 * @author Administrator
 *
 */

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable(value="itemId") Long itemId) {
		TbItem item = itemService.getItemById(itemId);
		return item;
	}
	
	/**
	 * 查询商品列表
	 * Integer 防止传入为空时报错
	 * @ResponseBody 返回json数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(@RequestParam(defaultValue="1") Integer page, 
			@RequestParam(defaultValue="30") Integer rows) {
		//调用service查询商品列表
		EasyUIDataGridResult result = itemService.getItemList(page, rows);
		//返回结果
		return result;
		
	}
}
