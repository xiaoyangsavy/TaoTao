package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EasyUITreeNode;


public interface ItemCatService {

	//获取商品类别列表
	List<EasyUITreeNode> getItemCatList(long parentId);
}
