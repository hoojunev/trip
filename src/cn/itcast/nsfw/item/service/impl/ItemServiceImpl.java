package cn.itcast.nsfw.item.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.core.service.impl.BaseServiceImpl;
import cn.itcast.nsfw.item.dao.ItemDao;
import cn.itcast.nsfw.item.entity.Item;
import cn.itcast.nsfw.item.service.ItemService;

@Service("itemService")
public class ItemServiceImpl extends BaseServiceImpl<Item> implements
		ItemService {
	
	ItemDao itemDao;
	
	@Resource
	public void setItemDao(ItemDao itemDao) {
		super.setBaseDao(itemDao);
		this.itemDao = itemDao;
	}
	

}
