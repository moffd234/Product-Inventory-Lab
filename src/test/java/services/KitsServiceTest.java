package services;

import models.Kit;
import models.KitSize;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KitsServiceTest {

    KitsService ks;

    @Before
    public void setup(){
        ks = new KitsService();
    }

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
        Kit testKit = ks.create(expectedKitNum, expectedQty, expectedPrice,
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

    @Test
    public void deleteTest() {
        int expectedSize = 9;
//        populateInventory();

        boolean deleted = ks.delete(2);
        int actualSize = ks.getKitsInventory().size();

        Assert.assertTrue(deleted);
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void deleteTestFalse() {
        int expectedSize = 10;
//        populateInventory();

        boolean deleted = ks.delete(50);
        int actualSize = ks.getKitsInventory().size();

        Assert.assertFalse(deleted);
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testFind() {

        Kit expected = ks.create(10, 10, 20,
                "Philadelphia Union", "Nike", "Gazdag", KitSize.LARGE, 10);

        Kit actual = ks.find(10);
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testFindNull() {

        Kit actual = ks.find(100);

        Assert.assertNull(actual);
    }

    @Test
    public void testFindAll(){
        Kit[] expected = new Kit[10];
        for(int i = 0; i < 10; i++){
            Kit tempKit = ks.find(i + 1);
            expected[i] = tempKit;
        }

        Kit[] actualInventory = ks.findAll();

        Assert.assertArrayEquals(expected, actualInventory);
    }

    public void populateInventory(){
        for(int i = 0; i < 10; i++){
            ks.create(i + 1, i * 10, i * 20,
                    "Barcelona", "Adidas", "Silva", KitSize.MEDIUM);
        }
    }
}
