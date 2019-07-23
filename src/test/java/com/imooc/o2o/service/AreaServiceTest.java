package com.imooc.o2o.service;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.service.AreaService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AreaServiceTest extends BaseTest {
    @Autowired
    private AreaService areaService;
    @Autowired
    private CacheService cacheService;
    @Test
    public void testGetAreaList(){
        System.out.println(areaService.getAreaList());
        cacheService.removeFromCache(areaService.AREALISTKEY);
        System.out.println(areaService.getAreaList());
    }
}
