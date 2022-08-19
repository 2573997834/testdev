package com.oms.testdev.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oms.testdev.dao.GoodsInfoDao;
import com.oms.testdev.model.GoodsInfo;
import com.oms.testdev.service.GoodsInfoService;
import com.oms.testdev.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class GoodsInfoServiceImpl implements GoodsInfoService {
    /*<AUTOGEN--BEGIN>*/

    @Autowired
    public GoodsInfoDao goodsInfoDao;


    @Override
    public PageUtil<GoodsInfo> selectPaged(PageUtil<GoodsInfo> pageInfo) {
        GoodsInfo data = pageInfo.getParam();
        Example example = new Example(GoodsInfo.class);
        if (null != data) {
            String classify = data.getClassify();
            String title = data.getTitle();
            Example.Criteria criteria = example.createCriteria();
            criteria.andLike("title", "%" + title + "%");
            criteria.andEqualTo("classify", classify);
        }
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        List<GoodsInfo> goodsInfos = goodsInfoDao.selectByExample(example);
        return PageUtil.success("查询成功",goodsInfos);
    }

    @Override
    public GoodsInfo selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public Integer deleteByPrimaryKey(String id) {
        return null;
    }

    @Override
    public Integer insert(GoodsInfo goodsInfo) {
        return null;
    }

    @Override
    public Integer updateByPrimaryKeySelective(GoodsInfo goodsInfo) {
        return null;
    }
}
