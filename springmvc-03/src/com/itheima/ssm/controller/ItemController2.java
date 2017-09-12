package com.itheima.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.ssm.pojo.Items;
import com.itheima.ssm.service.ItemsService;

@Controller
public class ItemController2 {
	
	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping("/item-info")
	@ResponseBody
	public Items getItemsById(int id) {
		Items items = itemsService.getItemById(id);
		return items;
	}
	
	@RequestMapping("/recive/json")
	@ResponseBody
	public String getJson(@RequestBody Items items) {
		return items.getName();
	}
}
