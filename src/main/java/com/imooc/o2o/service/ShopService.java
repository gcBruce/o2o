package com.imooc.o2o.service;

import com.imooc.o2o.dto.ImageHolder;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.exceptions.ShopOperationException;

import java.io.File;
import java.io.InputStream;

public interface ShopService {
    /**
     * 根据shopCondition分页返回相应列表数据
     * @param shopCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    ShopExecution getShopList(Shop shopCondition,int pageIndex,int pageSize);
    /**
     * 通过店铺Id获得店铺信息
     * @param shopId
     * @return
     */
    Shop getByShopId(long shopId);


    /**
     * 更新店铺信息
     * @param shop
     * @param shopImgInputStream
     * @param fileName
     * @return
     * @throws ShopOperationException
     */
    ShopExecution modifyShop(Shop shop, ImageHolder thumbnail)throws ShopOperationException;

    /**
     * 注册店铺信息，包括图片处理
     * @param shop
     * @param shopImgInputStream
     * @param fileName
     * @return
     */
    ShopExecution addShop(Shop shop, ImageHolder thumbnail)throws ShopOperationException;
}
