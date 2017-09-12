package com.itheima.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itheima.ssm.pojo.Items;
import com.itheima.ssm.pojo.QueryVo;
import com.itheima.ssm.service.ItemsService;

/**
 * 使用注解开发
 */
@Controller
@RequestMapping("/item")
public class ItemsController {

	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping("list")
	public ModelAndView showList(){
		//查询商品列表
		List<Items> itemList = itemsService.getItemList();
		//把列表传递给jsp
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemList", itemList);
		//设置视图名称
		modelAndView.setViewName("itemList");
		//返回ModelAndView
		return modelAndView;
	}
	
/*	@RequestMapping("/itemEdit")
	public ModelAndView itemEdit(HttpServletRequest request){
		//取参数,商品id
		String strId = request.getParameter("id");
		//将String类型的id转成int类型
		int id = Integer.parseInt(strId);
		//根据商品id查询商品信息
		Items item = itemsService.getItemById(id);
		//把商品信息传递给jsp
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("item", item);
		//设置jsp名称,设置逻辑视图
		modelAndView.setViewName("editItem");
		//返回ModelAndView对象
		return modelAndView;
	}*/
	
	@RequestMapping("/itemEdit")
	public String itemEdit(Integer id,Model model){		
		//根据商品id查询商品信息
		Items item = itemsService.getItemById(id);
		//使用model对象向页面传递数据
		model.addAttribute("item", item);
		return "editItem";
	}
	
	@RequestMapping("/queryitem.action")
	public String queryitem(QueryVo queryVo,int[] ids){		
		//int i = 1/0;
		System.out.println(queryVo.getItems().getId());
		System.out.println(queryVo.getItems().getName());
		System.out.println(Arrays.toString(ids));
		System.out.println(queryVo.getIds());
		//返回逻辑视图
		return "success";
	}
	
	/*@RequestMapping("/updateitem.action")
	public String updateById(Items items){		
		//更新数据库
		itemsService.updateById(items);
		//返回逻辑视图
		return "success";
	}*/
	
	@RequestMapping("/updateitem.action")
	public String updateById(Items items,MultipartFile pictureFile) throws Exception {		
		//接收图片
		//取文件的原始名称
		String originalFilename = pictureFile.getOriginalFilename();
		//从原始名称中截取扩展名
		String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
		//使用uuid生成文件名
		String fileName = UUID.randomUUID() + extName;
		//把文件保存到磁盘
		pictureFile.transferTo(new File("D:/temp/image/" + fileName));
		//把文件名保存到数据库
		items.setPic(fileName);
		//更新数据库
		itemsService.updateById(items);
		//返回逻辑视图
		return "success";
	}
}
