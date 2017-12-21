package cn.e3mall.service;

import cn.e3mall.common.pojo.DatagridResult;
import cn.e3mall.pojo.TbItem;

public interface ItemService {

	public TbItem findByTbItemId(long id);

	public DatagridResult findItemListByPage(int page, int rows);
}
