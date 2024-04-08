package services;

import models.Kit;
import models.KitSize;
import org.junit.Assert;
import org.junit.Test;

public class KitsServiceTest {

    @Test
    public void createTest(){

        // (1)
        String expectedPlayer = "Messi";
        String expectedBrand = "Adidas";
        String expectedTeam = "Barcelona";
        KitSize expectedSize = KitSize.MEDIUM;
        int expectedKitNum = 10;
        int expectedQty = 10;
        double expectedPrice = 80.00f;

        // (2)
        KitsService kitsService = new KitsService();
        Kit testKit = kitsService.create(expectedKitNum, expectedQty, expectedPrice,
                expectedTeam, expectedBrand, expectedPlayer, expectedSize);

        // (3)
        int actualId = testKit.getId();
        String actualPlayer = testKit.getPlayer();
        String actualBrand = testKit.getBrand();
        String actualTeam = testKit.getTeam();
        int actualKitNum = testKit.getKitNum();
        int actualQty = testKit.getQuantity();
        double actualPrice = testKit.getPrice();
        KitSize actualSize = testKit.getSize();

        // (4)
        Assert.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assert.assertEquals((Double) expectedPrice, (Double) actualPrice);
        Assert.assertEquals(expectedBrand, actualBrand);
        Assert.assertEquals(expectedPlayer, actualPlayer);
        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertEquals(expectedQty, actualQty);
        Assert.assertEquals(expectedTeam, actualTeam);
        Assert.assertEquals(expectedKitNum, actualKitNum);

    }

}
