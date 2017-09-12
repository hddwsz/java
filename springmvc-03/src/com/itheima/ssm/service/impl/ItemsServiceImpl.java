package com.itheima.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.ssm.mapper.ItemsMapper;
import com.itheima.ssm.pojo.Items;
import com.itheima.ssm.pojo.ItemsExample;
import com.itheima.ssm.service.ItemsService;

@Service
public class ItemsServiceImpl implements ItemsService {

	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	public List<Items> getItemList() {
		ItemsExample example = new ItemsExample();
		List<Items> list = itemsMapper.selectByExample(example);
		return list;
	}

	@Override
	public Items getItemById(int id) {
		Items items = itemsMapper.selectByPrimaryKey(id);
		return items;
	}

	@Override
	public void updateById(Items items) {
		itemsMapper.updateByPrimaryKeyWithBLOBs(items);
	}

}
