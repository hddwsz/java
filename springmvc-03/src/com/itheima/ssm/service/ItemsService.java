package com.itheima.ssm.service;

import java.util.List;

import com.itheima.ssm.pojo.Items;

public interface ItemsService {
	
	List<Items> getItemList();

	Items getItemById(int id);

	void updateById(Items items);
}
