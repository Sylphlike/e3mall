package cn.e3mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.Mapper.TbItemCatMapper;
import cn.e3mall.common.pojo.TreeNode;
import cn.e3mall.pojo.TbItemCat;
import cn.e3mall.pojo.TbItemCatExample;
import cn.e3mall.pojo.TbItemCatExample.Criteria;
import cn.e3mall.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper itemCatMapper;
	@Override
	public List<TreeNode> findCatWithTree(long parentId) {
		
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> itemCats = itemCatMapper.selectByExample(example);
		List<TreeNode> treeNodes =new ArrayList<>();
		for (TbItemCat tbItemCat : itemCats) {
			TreeNode treeNode = new TreeNode();
			treeNode.setId(tbItemCat.getId());
			treeNode.setState(tbItemCat.getIsParent()?"closed":"open");
			treeNode.setText(tbItemCat.getName());
			treeNodes.add(treeNode);
		}
		return treeNodes;
	}

}
