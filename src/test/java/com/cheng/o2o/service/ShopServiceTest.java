package com.cheng.o2o.service;

import com.cheng.o2o.BaseTest;
import com.cheng.o2o.dto.ShopExecution;
import com.cheng.o2o.entity.Area;
import com.cheng.o2o.entity.PersonInfo;
import com.cheng.o2o.entity.Shop;
import com.cheng.o2o.entity.ShopCategory;
import com.cheng.o2o.enums.ShopStateEnum;
import com.cheng.o2o.service.ShopService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

/**
 * ShopService Tester.
 *
 * @author cheng
 * @version 1.0
 * @since <pre>03/29/2018</pre>
 */
public class ShopServiceTest extends BaseTest {

    @Autowired
    private ShopService shopService;

    @Test
    public void testAddShop() throws FileNotFoundException {

        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(2L);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试店铺5");
        shop.setShopDesc("test5");
        shop.setShopAddr("test5");
        shop.setPhone("test5");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");

        File shopImg = new File("D:/IntelliJProject/O2O/target/test-classes/img/002.png");
        FileInputStream fis = new FileInputStream(shopImg);
        ShopExecution se = shopService.addShop(shop, fis, shopImg.getName());
        Assert.assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
    }
}
