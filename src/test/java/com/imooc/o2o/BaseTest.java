package com.imooc.o2o;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *
 * 配置spring和junit整合，junit启动时加载springIOC容器
 *
 */
//用哪个类去运行测试
@RunWith(SpringJUnit4ClassRunner.class)
//配置junit spring配置文件的位置
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" , "classpath:spring/spring-web.xml", "classpath:spring/spring-redis.xml" })
@WebAppConfiguration
public class BaseTest {
}
