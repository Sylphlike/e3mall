package cn.e3mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.Mapper.TbItemMapper;
import cn.e3mall.common.pojo.DatagridResult;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	@Override
	public TbItem findByTbItemId(long id) {
		return itemMapper.selectByPrimaryKey(id);
	}
	@Override
	public DatagridResult findItemListByPage(int page, int rows) {
		PageHelper.startPage(page, rows);
		TbItemExample example=new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(example);
		PageInfo<TbItem> pageInfo=new PageInfo<>(list);
		DatagridResult result = new DatagridResult();
		result.setTotal(pageInfo.getTotal());
		result.setRows(list);
		
		return result;
	}
	
	
}
