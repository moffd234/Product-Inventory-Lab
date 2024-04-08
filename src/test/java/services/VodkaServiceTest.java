package services;

import models.BottleSize;
import models.Vodka;
import org.junit.Assert;
import org.junit.Test;

public class VodkaServiceTest {

    @Test
    public void createTest(){

        // (1)
        String expectedBrand = "Smirnoff";
        BottleSize expectedSize = BottleSize.HANDLE;
        int expectedQty = 10;
        int expectedProof = 80;
        double expectedPrice = 80.00;

        // (2)
        VodkaService vodkasService = new VodkaService();
        Vodka testVodka = vodkasService.create(expectedBrand, expectedProof,
                expectedSize, expectedPrice, expectedQty);

        // (3)
        int actualId = testVodka.getId();
        String actualBrand = testVodka.getBrand();
        BottleSize actualSize = testVodka.getBottleSize();
        int actualQty = testVodka.getQuantity();
        int actualProof = testVodka.getProof();
        double actualPrice = testVodka.getPrice();

        // (4)
        Assert.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assert.assertEquals(expectedBrand, actualBrand);
        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertEquals(expectedQty, actualQty);
        Assert.assertEquals(expectedProof, actualProof);
        Assert.assertEquals((Double) expectedPrice, (Double) actualPrice);

    }
}
