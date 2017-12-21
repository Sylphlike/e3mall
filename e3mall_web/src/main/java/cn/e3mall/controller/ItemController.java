package cn.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.DatagridResult;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem findTbItemById(@PathVariable long itemId){
		return itemService.findByTbItemId(itemId);
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public DatagridResult findItemListByPage(int page,int rows){
		DatagridResult result=itemService.findItemListByPage(page,rows);
		return result;
	}
	
	
}
