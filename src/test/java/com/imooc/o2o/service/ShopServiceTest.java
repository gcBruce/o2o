package com.imooc.o2o.service;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.dto.ImageHolder;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;
import com.imooc.o2o.enums.ShopStateEnum;
import com.imooc.o2o.exceptions.ShopOperationException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;

    @Test
    public void testGetShopList(){
        Shop shopCondition=new Shop();
        PersonInfo owner=new PersonInfo();
        Area area=new Area();
        area.setAreaId(3);
        owner.setUserId(1L);
        shopCondition.setArea(area);
        shopCondition.setOwner(owner);
        System.out.println(shopService.getShopList(shopCondition,1,5).getShopList().size());

    }

    @Test
    public void testModifyShop() throws ShopOperationException,FileNotFoundException{
        Shop shop=new Shop();
        shop.setShopId(38L);
        shop.setShopName("修改后的店铺名称");
        File shopImg=new File("D:\\a954fba1b1085b3a4b3fc0af0c5f6cb8f5ab4fc5.gif");
        InputStream is=new FileInputStream(shopImg);
        ImageHolder imageHolder=new ImageHolder(shopImg.getName(),is);
        ShopExecution shopExecution=shopService.modifyShop(shop,imageHolder);
    }

    @Test
    public void testAddShop() throws FileNotFoundException {
        Shop shop=new Shop();
        PersonInfo owner=new PersonInfo();
        Area area=new Area();
        ShopCategory shopCategory=new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(10L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺3");
        shop.setShopDesc("test3");
        shop.setShopAddr("test3");
        shop.setPhone("test3");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");
        File shopImg=new File("D:\\timg.jpg");
        InputStream is=new FileInputStream(shopImg);
        ImageHolder imageHolder=new ImageHolder(shopImg.getName(),is);
        ShopExecution shopExecution =shopService.addShop(shop,imageHolder);
        assertEquals(ShopStateEnum.CHECK.getState(),shopExecution.getState());
    }

}
